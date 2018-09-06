package ru.spring.ripper.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.experimental.SuperBuilder;

import java.util.List;

/**
 * Created by dkorolev on 9/5/2018.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
class BasicExam {

    private String title;

    @Singular("addSection")
    private List<Section> sectionList;

}
