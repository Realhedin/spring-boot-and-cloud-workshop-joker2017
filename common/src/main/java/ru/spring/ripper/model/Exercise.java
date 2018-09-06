package ru.spring.ripper.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by dkorolev on 9/5/2018.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Exercise {

    private String question;

    private String answer;

}
