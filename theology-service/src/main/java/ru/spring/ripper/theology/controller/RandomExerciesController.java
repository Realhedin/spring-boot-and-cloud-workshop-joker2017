package ru.spring.ripper.theology.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.spring.ripper.examinator.domain.Exercise;
import ru.spring.ripper.theology.repository.ExerciseRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Simple rest controller for hadling requests.
 *
 * Created by dkorolev on 9/17/2018.
 */
@RestController
@RequiredArgsConstructor //allows no to set autowire on field, because it creates Constructor with setting repository.
                         //It's better practice than inject fields (no curcuit dependency). Lombok annotation.
public class RandomExerciesController {

    private final ExerciseRepository repository;

    @GetMapping("/exercise/random")
    public List<Exercise> randomExam(@RequestParam(defaultValue = "5") int count) {
        List<Exercise> all = repository.findAll();
        List<Exercise> exercises = new ArrayList<>(3);
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            int index = random.nextInt(all.size());
            exercises.add(all.get(index));
        }
        return exercises;
    }

    @GetMapping("/exercise/findByQuestion")
    public Exercise findExamByName(@RequestParam String question) {
        return repository.findByQuestion(question);
    }
}
