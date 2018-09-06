package ru.spring.ripper.model;

import lombok.*;

import java.util.List;

/**
 * Created by dkorolev on 9/5/2018.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class Section {

    private String title;

    private String description;

    @Singular("addExcercise")
    private List<Excercise> excerciseList;

}
