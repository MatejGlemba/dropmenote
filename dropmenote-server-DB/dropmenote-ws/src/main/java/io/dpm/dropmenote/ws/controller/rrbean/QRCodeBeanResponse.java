package io.dpm.dropmenote.ws.controller.rrbean;

import java.util.Date;

import io.dpm.dropmenote.ws.enums.UserTypeEnum;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(includeFieldNames = true)
public class QRCodeBeanResponse extends QRCodeBeanRequest {

	private String uuid;
	private int unreadMsgs;
	private int roomsCount;
	private Date created;
	private UserTypeEnum userType = UserTypeEnum.GUEST;

}
