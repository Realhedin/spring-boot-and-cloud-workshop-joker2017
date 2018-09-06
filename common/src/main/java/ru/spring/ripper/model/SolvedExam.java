package ru.spring.ripper.model;

import lombok.*;

import java.util.List;

/**
 * Created by dkorolev on 9/5/2018.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
//@SuperBuilder
public class SolvedExam extends BasicExam {

    @Builder
    public SolvedExam(String title, List<Section> sectionList, Student student) {
        super(title, sectionList);
        this.student = student;
    }

    Student student;
}
