package ru.spring.ripper.examinator.model;

import java.util.List;

/**
 * Created by dkorolev on 9/5/2018.
 */
public class Section {

    private String title;

    private String description;

    private List<Excercise> excerciseList;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Excercise> getExcerciseList() {
        return excerciseList;
    }

    public void setExcerciseList(List<Excercise> excerciseList) {
        this.excerciseList = excerciseList;
    }
}
