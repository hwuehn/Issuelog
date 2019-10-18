package com.company.issuelog.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
* Model class for an issue.
*
* @author Henning Wuehn
*/
public class Issue {

    private StringProperty name;
    private StringProperty status;
    private StringProperty synopsis;
    private StringProperty detail;

    /**
     * Default constructor.
     *
     */
     public Issue() {
         this(null, null, null);
     };

     /**
     *
     * Constructor with data.
     * @param name
     * @param status
     * @param synopsis
     */
    public Issue(String name, String status, String synopsis) {
        this.name = new SimpleStringProperty(name);
        this.status = new SimpleStringProperty(status);
        this.synopsis = new SimpleStringProperty(synopsis);
        this.detail = new SimpleStringProperty("some text");
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getStatus() {
        return status.get();
    }

    public StringProperty statusProperty() {
        return status;
    }

    public void setStatus(String status) {
        this.status.set(status);
    }

    public String getSynopsis() {
        return synopsis.get();
    }

    public StringProperty synopsisProperty() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis.set(synopsis);
    }

    public String getDetail() {
        return detail.get();
    }

    public StringProperty detailProperty() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail.set(detail);
    }
}
