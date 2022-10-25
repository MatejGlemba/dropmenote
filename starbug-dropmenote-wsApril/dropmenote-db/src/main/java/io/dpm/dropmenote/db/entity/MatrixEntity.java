package io.dpm.dropmenote.db.entity;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import io.dpm.dropmenote.db.constant.Schema;
import io.dpm.dropmenote.db.converter.AESAttributeConverter;
import lombok.Data;
import lombok.ToString;

/**
 * @author Peterko
 *
 */
@Data
@ToString(includeFieldNames = true)
@Entity
@Table(schema = Schema.SCHEMA, name = "MATRIX")
@NamedQuery(name = "MatrixEntity.findAll", query = "SELECT a FROM MatrixEntity a")
public class MatrixEntity {
	/**
	 * Serializable
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "matrix_seq", sequenceName = "matrix_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "matrix_seq")
	@Column(name = "id", nullable = false, precision = 19)
	private long id;
	
	@Column(name = "user_uuid", nullable = false)
	private String userUuid;

	@Column(name = "qr_code_uuid", nullable = false)
	private String qrCodeUuid;

	@Column(name = "matrix_room_id", nullable = false, unique = true)
	@Convert(converter = AESAttributeConverter.class)
	private String matrixRoomId;
	
	@Column(name = "matrix_username", nullable = true)
	@Convert(converter = AESAttributeConverter.class)
	private String matrixUsername;
	
	@Column(name = "matrix_password", nullable = true)
	@Convert(converter = AESAttributeConverter.class)
	private String matrixPassword;
	
	@Column(name = "alias", nullable = true)
	private String alias;
	
	@Column(name = "active", nullable = false)
	private boolean active = false;
	
	@Column(name = "empty", nullable = false)
	private boolean empty = true;	
}
