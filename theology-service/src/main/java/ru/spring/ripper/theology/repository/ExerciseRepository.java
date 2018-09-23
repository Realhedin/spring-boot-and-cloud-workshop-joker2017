package ru.spring.ripper.theology.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import ru.spring.ripper.examinator.domain.Exercise;

/**
 * Created by dkorolev on 9/17/2018.
 */
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

    Exercise findByQuestion(@Param("question") String question);

}
