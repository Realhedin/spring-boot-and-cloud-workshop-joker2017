package ru.spring.ripper.examinator.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import ru.spring.ripper.examinator.domain.Exercise;

import java.util.List;

/**
 * Created by dkorolev on 10/13/2018.
 */
@RestController
public class CombinedController {

    private RestTemplate restTemplate;

    @GetMapping("/exercise/theology")
    public List<Exercise> callTheologyServiceToGetExercices() {
        restTemplate = new RestTemplate();
        ResponseEntity<List> forEntity = restTemplate.getForEntity("http://localhost:8080/exercise/random", List.class);
        if (forEntity.getStatusCode().equals(HttpStatus.OK)) {
            return forEntity.getBody();
        }
        return null;
    }


}
