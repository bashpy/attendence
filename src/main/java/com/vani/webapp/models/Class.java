package com.vani.webapp.models;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by hexad3cimal on 7/5/17.
 */

@Entity
@Table(name = "class")
public class Class extends SuperModelClass implements Serializable {

    private String className;
    private School school;

    @Column(name = "class_name")
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @ManyToOne
    @JoinColumn(name = "school_id")
    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}
