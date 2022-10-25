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
@Table(schema = Schema.SCHEMA, name = "QR_CODE_LIST")
@NamedQuery(name = "QRCodeListEntity.findAll", query = "SELECT a FROM QRCodeListEntity a")
public class QRCodeListEntity extends AbstractEntity implements Serializable {
	/**
	 * Serializable
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor
	 */
	public QRCodeListEntity() {

	}

	@Id
	@SequenceGenerator(name = "qr_code_list_id_seq", sequenceName = "qr_code_list_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "qr_code_list_id_seq")
	@Column(name = "id", nullable = false, precision = 19)
	private long id;

	@Column(name = "uuid", nullable = false, unique = true)
	private String uuid;
}
