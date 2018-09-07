package ru.spring.ripper.model;

import lombok.*;

import java.util.List;

/**
 * Created by dkorolev on 9/5/2018.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public
//@SuperBuilder
class BasicExam {

    private String title;

    @Singular("addSection")
    private List<Section> sectionList;

}
