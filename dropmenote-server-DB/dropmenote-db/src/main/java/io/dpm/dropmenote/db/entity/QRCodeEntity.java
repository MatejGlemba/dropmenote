package io.dpm.dropmenote.db.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import io.dpm.dropmenote.db.constant.Schema;
import io.dpm.dropmenote.db.enums.IconEnum;
import io.dpm.dropmenote.db.enums.QRCodeTypeEnum;
import lombok.Data;
import lombok.ToString;

/**
 * @author Peterko
 *
 */
@Data
@ToString(includeFieldNames = true)
@Entity
@Table(schema = Schema.SCHEMA, name = "QR_CODE")
@NamedQuery(name = "QRCodeEntity.findAll", query = "SELECT a FROM QRCodeEntity a")
public class QRCodeEntity extends AbstractEntity implements Serializable {
	/**
	 * Serializable
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor
	 */
	public QRCodeEntity() {

	}

	@Id
	@SequenceGenerator(name = "qr_code_id_seq", sequenceName = "qr_code_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "qr_code_id_seq")
	@Column(name = "id", nullable = false, precision = 19)
	private long id;

	@Column(name = "type", nullable = false)
	@Enumerated(EnumType.STRING)
	private QRCodeTypeEnum type;

//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	@JoinTable(name = "QR_CODE_USER_SHARE", schema = Schema.SCHEMA)
//	private List<UserEntity> sharedUsers = new ArrayList<>();
	
	// id
	// qrCodeId
	// ownerId
	// shareUserId

	@Column(name = "uuid", nullable = false, unique = true)
	private String uuid;

	@Column(name = "owner_alias", nullable = false)
	private String ownerAlias;

	@OneToOne
	@JoinColumn(name = "owner_id", nullable = false)
	private UserEntity owner;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "description", nullable = false, columnDefinition = "TEXT")
	private String description;

	@Column(name = "link", nullable = true)
	private String link;
	
	@Column(name = "photo", nullable = true)
	private String photo;

	@Column(name = "icon", nullable = false)
	@Enumerated(EnumType.STRING)
	private IconEnum icon;

	@Column(name = "active", nullable = false)
	private boolean active;

	@Column(name = "push_notification", nullable = false)
	private boolean pushNotification;

	@Column(name = "email_notification", nullable = false)
	private boolean emailNotification;
}
