package io.dpm.dropmenote.ws.bean;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(includeFieldNames = true)
public class SharedUser {
	
	private long id;
	private UserBean owner;
	private QRCodeBean qrCode;
	private UserBean shareUser;
	
}
