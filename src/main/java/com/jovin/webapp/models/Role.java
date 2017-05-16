package com.jovin.webapp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by hexad3cimal on 7/5/17.
 */

@Entity
@Table(name = "role")
public class Role extends SuperModelClass implements Serializable {

    private String roleName;
    private Set<User> users;


   @Column(name = "role_name",nullable = false,length = 45)
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @OneToMany(mappedBy = "role")
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
