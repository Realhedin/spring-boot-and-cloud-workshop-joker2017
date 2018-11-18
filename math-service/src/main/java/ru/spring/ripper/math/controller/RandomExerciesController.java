package ru.spring.ripper.math.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.spring.ripper.examinator.domain.Exercise;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by dkorolev on 11/18/2018.
 */
@RestController
public class RandomExerciesController {

    @GetMapping("/exercise/random")
    public List<Exercise> randomExercises(@RequestParam(defaultValue = "3") int count) {
        return IntStream.range(1, count).mapToObj(i -> Exercise.builder()
                .question("question #" + i)
                .answer("answer #" + i)
                .id((long) i)
                .build())
                .collect(Collectors.toList());
    }
}
