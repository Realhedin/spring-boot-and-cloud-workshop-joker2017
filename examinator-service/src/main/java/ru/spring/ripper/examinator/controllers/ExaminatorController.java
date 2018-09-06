package ru.spring.ripper.examinator.controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.spring.ripper.model.CheckedExam;
import ru.spring.ripper.model.SolvedExam;

/**
 * Created by dkorolev on 9/5/2018.
 */
@RestController
public class ExaminatorController {

    @RequestMapping("/examine")
    public CheckedExam examine(@RequestBody SolvedExam solvedExam) {
        return CheckedExam.builder()
                .mark(5)
                .title(solvedExam.getTitle())
                .build();
    }
}
