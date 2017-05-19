package com.vani.webapp.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by hexad3cimal on 7/5/17.
 */

@Entity
@Table(name = "school")
public class School extends SuperModelClass implements Serializable{

    @Column(name = "school_name",nullable = false,length = 300)
    private String schoolName;
    @Column(name = "address")
    private String address;
    private String phone;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "school")
    private Set<Class> classes = new HashSet<>();


    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Set<Class> getClasses() {
        return classes;
    }

    public void setClasses(Set<Class> classes) {
        this.classes = classes;
    }

}
