package ru.spring.ripper.math;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import ru.spring.ripper.examinator.domain.Exercise;

/**
 * Created by dkorolev on 11/18/2018.
 */
@SpringBootApplication
@EntityScan(basePackageClasses = Exercise.class)
public class MathApplication {

    public static void main(String[] args) {
        SpringApplication.run(MathApplication.class,args);
    }
}
