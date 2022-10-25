package io.dpm.dropmenote.ws.bean;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(includeFieldNames = true)
public class SessionBean {
	
	private long id;
	private UserBean user;
	private String token;
	private String deviceId;
	private boolean active;
	
	
}
