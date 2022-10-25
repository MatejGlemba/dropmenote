package io.dpm.dropmenote.db.entity;

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
 * @author Peterko
 *
 */
@Data
@ToString(includeFieldNames = true)
@Entity
@Table(schema = Schema.SCHEMA, name = "QR_CODE_USER_SHARE")
@NamedQuery(name = "SharedUserEntity.findAll", query = "SELECT a FROM SharedUserEntity a")
public class SharedUserEntity {
	/**
	 * Serializable
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@SequenceGenerator(name = "qr_code_user_share_id_seq", sequenceName = "qr_code_user_share_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "qr_code_user_share_id_seq")
	@Column(name = "id", nullable = false, precision = 19)
	private long id;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "owner_user_id", nullable = false)
	private UserEntity owner;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "qr_code_id", nullable = false)
	private QRCodeEntity qrCode;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "shared_user_id", nullable = false)
	private UserEntity shareUser;
	

}
