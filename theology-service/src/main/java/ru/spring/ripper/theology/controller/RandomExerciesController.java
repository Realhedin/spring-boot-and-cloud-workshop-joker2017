package ru.spring.ripper.theology.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.spring.ripper.examinator.domain.Exercise;
import ru.spring.ripper.theology.repository.ExerciseRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by dkorolev on 9/17/2018.
 */
@RestController
public class RandomExerciesController {

    @Autowired
    private ExerciseRepository repository;

    @GetMapping("/exercise/random")
    public List<Exercise> randomExam(@RequestParam int count) {
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
