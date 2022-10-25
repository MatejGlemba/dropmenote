package io.dpm.dropmenote.ws.controller.rrbean;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(includeFieldNames = true)
public class BlackListResponse extends BlackListRequest{
	
	private long id;
}
