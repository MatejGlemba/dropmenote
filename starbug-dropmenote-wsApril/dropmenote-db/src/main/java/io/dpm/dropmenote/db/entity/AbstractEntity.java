package io.dpm.dropmenote.db.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(includeFieldNames = true)
@MappedSuperclass
public class AbstractEntity implements Serializable {
    /**
     * Serializable
     */
    private static final long serialVersionUID = 1L;

    /**
     * Default constructor
     */
    public AbstractEntity() {
    }

    @Column(name = "created", updatable = false)
    @CreationTimestamp
    private Timestamp created;

    @Column(name = "updated")
    @UpdateTimestamp
    private Timestamp updated;
}
