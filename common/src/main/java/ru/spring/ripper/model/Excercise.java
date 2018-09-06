package ru.spring.ripper.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by dkorolev on 9/5/2018.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
class Excercise {

    private String question;

    private String answer;

}
