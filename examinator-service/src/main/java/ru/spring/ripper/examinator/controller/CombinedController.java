package ru.spring.ripper.examinator.controller;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import ru.spring.ripper.examinator.ExternalServiceProperties;
import ru.spring.ripper.examinator.domain.Exercise;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * Created by dkorolev on 10/13/2018.
 */
@RestController
public class CombinedController {

    private RestTemplate restTemplate;
    private ExternalServiceProperties serviceProperties;

    public CombinedController(RestTemplateBuilder restTemplate, ExternalServiceProperties serviceProperties) {
        this.restTemplate = restTemplate.build();
        this.serviceProperties = serviceProperties;
    }

    @GetMapping("/exercise/theology")
    public List<Exercise> callTheologyServiceToGetExercices() {
        ResponseEntity<List> forEntity = restTemplate.getForEntity(getTheologyUrl()+"/exercise/random?count=2", List.class);
        if (forEntity.getStatusCode().equals(HttpStatus.OK)) {
            return forEntity.getBody();
        }
        return null;
    }

    private String getTheologyUrl() {
        Collection<String> values = serviceProperties.getUrls().values();
        Optional<String> first = values.stream().findFirst();
        return first.orElse("wrong URL");
    }


}
