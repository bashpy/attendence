package com.vani.webapp.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by hexad3cimal on 7/5/17.
 */

@Entity
@Table(name = "division")
public class Division extends SuperModelClass implements Serializable {

    private String divisionName;
    private User classTeacher;
    private Class parentClass;
    @OneToMany(mappedBy = "division")
    private Set<Attendance> attendances = new HashSet<>();

   @Column(name = "division")
    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    @JoinColumn(name = "teacher_id")
    public User getClassTeacher() {
        return classTeacher;
    }

    public void setClassTeacher(User classTeacher) {
        this.classTeacher = classTeacher;
    }

    @JoinColumn(name = "class_id")
    public Class getParentClass() {
        return parentClass;
    }

    public void setParentClass(Class parentClass) {
        this.parentClass = parentClass;
    }

    public Set<Attendance> getAttendances() {
        return attendances;
    }

    public void setAttendances(Set<Attendance> attendances) {
        this.attendances = attendances;
    }
}
