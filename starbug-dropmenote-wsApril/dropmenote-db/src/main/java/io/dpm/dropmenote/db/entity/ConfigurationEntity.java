package io.dpm.dropmenote.db.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import io.dpm.dropmenote.db.constant.Schema;
import lombok.Data;
import lombok.ToString;

/**
 * @author Peterko
 *
 */
@Data
@ToString(includeFieldNames = true)
@Entity
@Table(schema = Schema.SCHEMA, name = "CONFIGURATION")
@NamedQuery(name = "ConfigurationEntity.findAll", query = "SELECT a FROM ConfigurationEntity a")
public class ConfigurationEntity extends AbstractEntity implements Serializable {
    /**
     * Serializable
     */
    private static final long serialVersionUID = 1L;

    /**
     * Default constructor
     */
    public ConfigurationEntity() {

    }

    @Id
    @SequenceGenerator(name = "configuration_id_seq", sequenceName = "configuration_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "configuration_id_seq")
    @Column(name = "id", nullable = false, precision = 19)
    private long id;

    @Column(name = "key", nullable = false, unique = true)
    private String key;

    @Column(name = "value", columnDefinition = "TEXT")
    private String value;

    @Column(name = "note", columnDefinition = "TEXT")
    private String note;
}
