package com.vani.webapp.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vani.webapp.utils.IdGenerator;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by vani on 16/8/16.
 */


@MappedSuperclass
public abstract class SuperModelClass {

    @Id
    private String id = IdGenerator.createId();

    @Version
    @Column(name = "version", nullable = false)
    private Integer version;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date created_time_stamp;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @JsonIgnore
    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @JsonIgnore
    public Date getCreated_time_stamp() {
        return created_time_stamp;
    }

    public void setCreated_time_stamp(Date created_time_stamp) {
        this.created_time_stamp = created_time_stamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SuperModelClass that = (SuperModelClass) o;

        return id != null ? id.equals(that.id) : that.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
