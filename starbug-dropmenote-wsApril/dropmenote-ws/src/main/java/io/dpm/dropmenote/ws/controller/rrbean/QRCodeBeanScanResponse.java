package io.dpm.dropmenote.ws.controller.rrbean;

import io.dpm.dropmenote.ws.enums.UserTypeEnum;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(includeFieldNames = true)
public class QRCodeBeanScanResponse extends QRCodeBeanResponse {

	private UserTypeEnum userType;
	private boolean isBlocked;

}
