package ru.spring.ripper.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * Created by dkorolev on 9/5/2018.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class SolvedExam extends BasicExam {

//    @Builder
//    public SolvedExam(String title, List<Section> sectionList, Student student) {
//        super(title, sectionList);
//        this.student = student;
//    }

    Student student;
}
