package ru.spring.ripper.examinator.controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.spring.ripper.examinator.model.CheckedExam;
import ru.spring.ripper.examinator.model.SolvedExam;

/**
 * Created by dkorolev on 9/5/2018.
 */
@RestController
public class ExaminatorController {

    @RequestMapping("/examine")
    public CheckedExam examine(@RequestBody SolvedExam solvedExam) {
        CheckedExam checkedExam = new CheckedExam();
        checkedExam.setMark(5);
        checkedExam.setSectionList(solvedExam.getSectionList());
        checkedExam.setTitle(solvedExam.getTitle());
        return checkedExam;
    }
}
