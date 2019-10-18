package com.company.issuelog.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Project {

    private StringProperty projectId;

    public Project() {

    }

    public Project(String projectId) {
        this.projectId = new SimpleStringProperty(projectId);
    }

    public String getProjectId() {
        return projectId.get();
    }

    public StringProperty projectIdProperty() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId.set(projectId);
    }
}
