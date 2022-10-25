package io.dpm.dropmenote.ws.controller.rrbean;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(includeFieldNames = true)
public class BlackListRequest {

	private String uuid;
	private String note;
	private String alias;

}
