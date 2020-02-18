package com.course_selection.pojo;

import java.util.List;

public class ShowExperiment {
    private List<Experiment> experimentList;
    private Student student;

    public List<Experiment> getExperimentList() {
        return experimentList;
    }

    public void setExperimentList(List<Experiment> experimentList) {
        this.experimentList = experimentList;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
