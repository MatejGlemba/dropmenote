package io.dpm.dropmenote.ws.controller.rrbean;

import java.util.Date;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(includeFieldNames = true)
public class MatrixResponseObject {

	/**
	 * Default constructor
	 */
	public MatrixResponseObject() {
	}
	
	private String roomId;
	private QRCodeBeanResponse qrCodeBean;
	private int newMsgCount;
	private String lastMsg;
	private Date lastMsgDate;
	private boolean isBlocked;
	private String senderAlias;
	private String senderUuid;
	private String counterpartName;

}
