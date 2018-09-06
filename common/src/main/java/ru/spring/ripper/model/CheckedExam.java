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
public class CheckedExam extends BasicExam {

    @Builder
    public CheckedExam(String title, List<Section> sectionList, int mark) {
        super(title, sectionList);
        this.mark = mark;
    }

    private int mark;

}
