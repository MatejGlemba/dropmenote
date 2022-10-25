package io.dpm.dropmenote.db.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import io.dpm.dropmenote.db.constant.Schema;
import lombok.Data;
import lombok.ToString;

/**
 * @author Peter Diskanec
 *
 */
@Data
@ToString(includeFieldNames = true)
@Entity
@Table(schema = Schema.SCHEMA, name = "BLACKLIST")
@NamedQuery(name = "BlacklistEntity.findAll", query = "SELECT a FROM BlacklistEntity a")
public class BlacklistEntity extends AbstractEntity implements Serializable {
	/**
	 * Serializable
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor
	 */
	public BlacklistEntity() {

	}

	@Id
	@SequenceGenerator(name = "blacklist_id_seq", sequenceName = "blacklist_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "blacklist_id_seq")
	@Column(name = "id", nullable = false, precision = 19)
	private long id;

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "owner_user_id", nullable = false)
	private UserEntity owner;

	/**
	 * Bud sa tu da uuid z prehliadaca pre neregistrovaneho usera. 
	 * Tam pouzivame prefix dpnnr_uuid, alebo sa pouziva nami generovanz uuid pri registracii. je to nemenne
	 */
	@Column(name = "uuid", nullable = false)
	private String uuid;
	
	@Column(name = "note", nullable = false)
	private String note;
	
	@Column(name = "alias", nullable = false)
	private String alias;

	// @ManyToOne(cascade = CascadeType.MERGE)
	// @JoinColumn(name = "qrcode_id", nullable = false)
	// private QRCodeEntity qrCode;
}
