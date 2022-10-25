package io.dpm.dropmenote.ws.controller.rrbean;

import lombok.Data;
import lombok.ToString;

/**
 * @author Peterko
 *
 */
@Data
@ToString(includeFieldNames = true)
public class UserBeanRequest extends UserBeanResponse{

	public UserBeanRequest() {
		
	}
	
	private String password;

}
