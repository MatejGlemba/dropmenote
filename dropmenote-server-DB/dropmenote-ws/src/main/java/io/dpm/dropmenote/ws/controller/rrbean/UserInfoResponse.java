package io.dpm.dropmenote.ws.controller.rrbean;
	
import lombok.Data;
import lombok.ToString;

@Data
@ToString(includeFieldNames = true)
public class UserInfoResponse {

	public UserInfoResponse() {};
	
	public UserInfoResponse(String userLogin, String userAlias, String userIcon) {
		this.userLogin = userLogin;
		this.userAlias = userAlias;
		this.userIcon = userIcon;
	}
	
	private String userIcon;
	private String userLogin;
	private String userAlias;
	
}
