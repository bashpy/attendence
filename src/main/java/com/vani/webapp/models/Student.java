package com.vani.webapp.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by hexad3cimal on 7/5/17.
 */

@Entity
@Table(name = "student")
public class Student extends SuperModelClass implements Serializable{

    private String studentName;
    private Division division;
    private User parent;
    private Integer presentToday;
    private Set<Attendance> attendances = new HashSet<>();

    @Column(name = "student_name")
    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @JoinColumn(name = "division_id")
    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    @JoinColumn(name = "parent_id")
    public User getParent() {
        return parent;
    }

    public void setParent(User parent) {
        this.parent = parent;
    }

    @Column(name = "present_today")
    public Integer getPresentToday() {
        return presentToday;
    }

    public void setPresentToday(Integer presentToday) {
        this.presentToday = presentToday;
    }

    @OneToMany(mappedBy = "student")
    public Set<Attendance> getAttendances() {
        return attendances;
    }

    public void setAttendances(Set<Attendance> attendances) {
        this.attendances = attendances;
    }
}
