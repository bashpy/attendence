package com.jovin.webapp.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by hexad3cimal on 7/5/17.
 */

@Entity
@Table(name = "attendance")
public class Attendance extends SuperModelClass implements Serializable {

    private Date attendanceDate;
    private Division division;
    private Student student;

    @Column(name = "date")
    public Date getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(Date attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    @ManyToOne
    @JoinColumn(name = "division_id")
    public Division getDivision() {
        return division;
    }

    @ManyToOne
    @JoinColumn(name = "division_id")
    public void setDivision(Division division) {
        this.division = division;
    }

    @ManyToOne
    @JoinColumn(name = "student_id")
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
