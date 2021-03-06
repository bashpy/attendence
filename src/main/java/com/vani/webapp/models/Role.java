package com.vani.webapp.models;
// Generated 2 Jun, 2017 4:27:33 PM by Hibernate Tools 5.0.6.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

/**
 * Role generated by hbm2java
 */
@Entity
@Table(name = "role", catalog = "attendance")
public class Role implements java.io.Serializable {

	private Integer id;
	private Integer version;
	private String roleName;
	private Date createdTimeStamp;
	private Set<Student> students = new HashSet<Student>(0);
	private Set<User> users = new HashSet<User>(0);

	public Role() {
	}

	public Role(String roleName, Date createdTimeStamp) {
		this.roleName = roleName;
		this.createdTimeStamp = createdTimeStamp;
	}

	public Role(String roleName, Date createdTimeStamp, Set<Student> students, Set<User> users) {
		this.roleName = roleName;
		this.createdTimeStamp = createdTimeStamp;
		this.students = students;
		this.users = users;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
	public Set<Student> getStudents() {
		return this.students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
	public Set<User> getUsers() {
		return this.users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}
