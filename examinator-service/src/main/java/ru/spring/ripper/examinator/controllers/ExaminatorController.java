package ru.spring.ripper.examinator.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.spring.ripper.model.CheckedExam;
import ru.spring.ripper.model.SolvedExam;

/**
 * Created by dkorolev on 9/5/2018.
 */
@RestController
public class ExaminatorController {

    //curl -X POST http://localhost:8080/examine -d '{"title" : "exam"}' -H "Content-Type: application/json"
    @RequestMapping(path = "/examine", method = RequestMethod.POST)
    public CheckedExam examine(@RequestBody SolvedExam solvedExam) {
        return CheckedExam.builder()
                .mark(5)
                .title(solvedExam.getTitle())
                .build();
    }

    //curl -X GET http://localhost:8080/examine -H "Content-Type: application/json"
    @RequestMapping(path = "/examine", method = RequestMethod.GET)
    public CheckedExam examine2() {
        return CheckedExam.builder()
                .mark(2)
                .build();
    }

    //curl -X GET http://localhost:8080/examine2 -H "Content-Type: application/json"
    @GetMapping(path = "/examine2", produces = MediaType.APPLICATION_JSON_VALUE)
    public CheckedExam examine3() {
        return CheckedExam.builder()
                .mark(2)
                .build();
    }

    // curl -X GET http://localhost:8080/examnin3/curl?debug=true -H "Content-Type: application/json"
    @GetMapping(path = "/examine3/{title}")
    public CheckedExam examine2(@PathVariable String title, @RequestParam Boolean debug) {
        return CheckedExam.builder()
                .mark(3)
                .title(title)
                .build();
    }
}
