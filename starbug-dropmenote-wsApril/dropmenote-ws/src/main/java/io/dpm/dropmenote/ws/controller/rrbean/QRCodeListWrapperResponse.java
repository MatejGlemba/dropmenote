package io.dpm.dropmenote.ws.controller.rrbean;

import java.util.List;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(includeFieldNames = true)
public class QRCodeListWrapperResponse {
	
	public QRCodeListWrapperResponse() {};
	
	public QRCodeListWrapperResponse(UserInfoResponse userInfo, List<QRCodeBeanResponse> qrList) {
		this.userInfo = userInfo;
		this.qrList = qrList;
	}

	private UserInfoResponse userInfo;
	private List<QRCodeBeanResponse> qrList;
	
}
