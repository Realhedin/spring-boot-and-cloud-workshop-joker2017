package ru.spring.ripper.theology.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.spring.ripper.examinator.domain.Exercise;

import java.util.List;

/**
 * Allows to make GET requests with REST without implicit controller.
 * Added all REST advantages, as HATEOS.
 *
 * Use first curl and then get information about links from response.
 *
 * Created by dkorolev on 9/23/2018.
 */

//curl -X GET http://localhost:8080/exercises
@RepositoryRestResource(collectionResourceRel = "exercises", path = "exercises")
public interface ExerciseRestRepository extends PagingAndSortingRepository<Exercise, Long> {

    //curl http://localhost:8080/exercises/search/findByAnswer?answer=42
    List<Exercise> findByAnswer(@Param("answer") String answer);
}
