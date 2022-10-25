package io.dpm.dropmenote.ws.controller.rrbean;

import java.util.List;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(includeFieldNames = true)
public class LoadSharesResponse {
	
	private List<String> sharesResponse;
	
}
