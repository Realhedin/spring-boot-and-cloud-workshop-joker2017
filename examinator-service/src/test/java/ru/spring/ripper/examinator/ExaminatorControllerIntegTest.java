package ru.spring.ripper.examinator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.spring.ripper.examinator.controllers.ExaminatorController;
import ru.spring.ripper.model.*;

import java.io.IOException;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author tolkv
 * @version 25/10/2017
 */
@RunWith(SpringRunner.class)
@WebMvcTest
public class ExaminatorControllerIntegTest {

    private static String content = "{ \"title\":\"exam\", \"student\": \"Толкачёв Кирилл\" }";

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    ExaminatorController examinatorController;


    @Test
    public void checkExamineContract() throws Exception {

        mockMvc.perform(
                post("/examine")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(createStringSolvedExamFromOjbect())
        )
                .andExpect(jsonPath("$.mark", allOf(greaterThan(0), lessThan(101))))
                .andExpect(jsonPath("$.title", equalTo("exam")))
                .andExpect(jsonPath("$.student").doesNotExist())
                .andExpect(jsonPath("$.examine").doesNotExist())
                .andExpect(status().isOk());
    }

    private String createStringSolvedExamFromOjbect() throws JsonProcessingException {
        SolvedExam solvedExam = SolvedExam.builder()
                .student(Student.builder().name("Dmitry").build())
                .title("exam")
                .build();
        return objectMapper.writeValueAsString(solvedExam);
    }

    @Test
    public void createSolvedExamViaObjectMapper() throws IOException {
        SolvedExam solvedExam = objectMapper.readerFor(SolvedExam.class)
                .readValue(content);
        Assert.assertEquals(solvedExam.getTitle(), "exam");
        Assert.assertEquals(solvedExam.getStudent().getName(), "Толкачёв Кирилл");
    }


    @Test
    public void changeSolvedIntoCheckedViaExaminatorService() {
        CheckedExam examine = examinatorController.examine(SolvedExam.builder()
                .student(new Student("Dmitry"))
                .title("test")
                .build());
        Assert.assertEquals(examine.getMark(), 5);
        Assert.assertEquals(examine.getTitle(), "test");
    }


    @Test
    public void name() throws JsonProcessingException {
        SolvedExam build = SolvedExam.builder()
                .title("Вступительный экзамен на JokerConf")
                .sectionList(Arrays.asList(Section.builder()
                                .title("Java")
                                .description("простые вопросы по java")
                                .excerciseList(Arrays.asList(Exercise.builder()
                                                .question("в чем разница между spring string и swing")
                                                .answer("без spring`а не обойтись")
                                                .build(),
                                        (Exercise.builder()
                                                .question("в чем разница между final finally finalize")
                                                .answer("за finalize отрывают руки")
                                                .build())))
                                .build(),
                        Section.builder()
                                .title("философия")
                                .description("сложные вопросы по философии")
                                .excerciseList(Arrays.asList(Exercise.builder()
                                                .question("В чем смысл жизни")
                                                .answer("42")
                                                .build(),
                                        Exercise.builder()
                                                .question("Что появилось раньше, яйцо или курица")
                                                .answer("петух")
                                                .build()))
                        .build()))
                .student(Student.builder().name("Борисов Евгений").build())
                .build();

        String s = objectMapper.writeValueAsString(build);
        System.out.println("s = " + s);
    }
}