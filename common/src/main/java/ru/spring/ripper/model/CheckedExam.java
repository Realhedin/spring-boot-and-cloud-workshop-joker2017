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
public class CheckedExam extends BasicExam {

//    @Builder
//    public CheckedExam(String title, List<Section> sectionList, int mark) {
//        super(title, sectionList);
//        this.mark = mark;
//    }

    private int mark;

}
