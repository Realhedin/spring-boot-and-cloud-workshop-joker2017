package ru.spring.ripper.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

/**
 * Created by dkorolev on 9/5/2018.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@SuperBuilder
public class CheckedExam {

    //    @Builder
//    public CheckedExam(String title, List<Section> sectionList, int mark) {
//        super(title, sectionList);
//        this.mark = mark;
//    }
    @Delegate
    @JsonIgnore
    private BasicExam basicExam = new BasicExam();

    private int mark;

}
