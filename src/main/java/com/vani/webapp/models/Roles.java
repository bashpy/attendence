package com.vani.webapp.models;
// Generated 29 May, 2017 12:02:51 AM by Hibernate Tools 5.2.3.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

/**
 * Roles generated by hbm2java
 */
@Entity
@Table(name = "role", catalog = "attendance")
public class Roles implements java.io.Serializable {

	private int id;
	private Integer version;
	private String roleName;
	private Date createdTimeStamp;
	private Set<User> users = new HashSet<User>(0);

	public Roles() {
	}

	public Roles(int id, String roleName, Date createdTimeStamp) {
		this.id = id;
		this.roleName = roleName;
		this.createdTimeStamp = createdTimeStamp;
	}

	public Roles(int id, String roleName, Date createdTimeStamp, Set<User> users) {
		this.id = id;
		this.roleName = roleName;
		this.createdTimeStamp = createdTimeStamp;
		this.users = users;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Version
	@Column(name = "version")
	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	@Column(name = "role_name", nullable = false, length = 45)
	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_time_stamp", nullable = false, length = 19)
	public Date getCreatedTimeStamp() {
		return this.createdTimeStamp;
	}

	public void setCreatedTimeStamp(Date createdTimeStamp) {
		this.createdTimeStamp = createdTimeStamp;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "roles")
	public Set<User> getUsers() {
		return this.users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}