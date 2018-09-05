package ru.spring.ripper.examinator.model;

import java.util.List;

/**
 * Created by dkorolev on 9/5/2018.
 */
public abstract class BasicExam {

    private String title;

    private List<Section> sectionList;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Section> getSectionList() {
        return sectionList;
    }

    public void setSectionList(List<Section> sectionList) {
        this.sectionList = sectionList;
    }
}
