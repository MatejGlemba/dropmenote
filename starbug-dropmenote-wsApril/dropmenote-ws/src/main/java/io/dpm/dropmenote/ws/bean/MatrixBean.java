package io.dpm.dropmenote.ws.bean;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(includeFieldNames = true)
public class MatrixBean extends AbstractBean {

	/**
	 * Default constructor
	 */
	public MatrixBean() {

	}

	private long id;
	
	private String userUuid;
	private String qrCodeUuid;
	private String matrixRoomId;
	private String matrixUsername;
	private String matrixPassword;
	private String alias;
	private boolean active;
	private boolean empty = true;
}
