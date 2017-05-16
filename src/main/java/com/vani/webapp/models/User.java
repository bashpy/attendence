package com.vani.webapp.models;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by hexad3cimal on 7/5/17.
 */

@Entity
@Table(name = "user")
public class User extends SuperModelClass implements Serializable  {


    private String email;
    private String phoneNo;
    private String password;
    private String fullName;
    private Role role;

    @Column(name = "email",unique = true, nullable = false,length = 45)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "phone_number",length = 13)
    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    @Column(name = "password",length = 20)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "full_name",length = 100)
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @ManyToOne
    @JoinColumn(name = "role_id")
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
