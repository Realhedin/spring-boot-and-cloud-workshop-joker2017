package ru.spring.ripper.examinator.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import ru.spring.ripper.examinator.ExternalServiceProperties;
import ru.spring.ripper.examinator.domain.Examine;
import ru.spring.ripper.examinator.domain.Exercise;
import ru.spring.ripper.examinator.domain.Section;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by dkorolev on 11/17/2018.
 */
@RestController
public class ExaminatorComposerController {

    private final RestTemplate restTemplate;
    private ExternalServiceProperties serviceProperties;

    public ExaminatorComposerController(
            RestTemplate restTemplate,
            ExternalServiceProperties externalServiceProperties) {
        this.restTemplate = restTemplate;
        this.serviceProperties = externalServiceProperties;
    }


    @PostMapping("/examine/collect")
    public Examine composeExercises(@RequestBody Map<String,Integer> serviceMap) {
        List<Section> sections = serviceMap.entrySet().stream()
                .map(serviceEntry -> {
                    String serviceName = serviceEntry.getKey();
                    Integer numberOfExercises = serviceEntry.getValue();
                    String url = discoverUrl(serviceName, numberOfExercises);

                    return Section.builder()
                            .title(serviceName)
                            .exercises(Arrays.asList(restTemplate.getForObject(url,Exercise[].class)))
                            .build();
                }).collect(Collectors.toList());

        return Examine.builder()
                .sections(sections)
                .title("exam test")
                .build();
    }


    private String discoverUrl(String serviceName, Integer numberOfExercises) {
        String serviceUrl = serviceProperties.getUrls().get(serviceName);
        return serviceUrl + "exercise/random?count=" + numberOfExercises;
    }


}
