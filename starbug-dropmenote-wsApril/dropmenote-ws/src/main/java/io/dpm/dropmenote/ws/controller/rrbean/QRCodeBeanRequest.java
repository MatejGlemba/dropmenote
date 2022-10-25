package io.dpm.dropmenote.ws.controller.rrbean;

import io.dpm.dropmenote.ws.enums.IconEnum;
import io.dpm.dropmenote.ws.enums.QRCodeTypeEnum;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(includeFieldNames = true)
public class QRCodeBeanRequest {

	/**
	 * Default constructor
	 */
	public QRCodeBeanRequest() {

	}

	private long id;

	private QRCodeTypeEnum type;
	private String ownerAlias;
	private String name;
	private String description;
	private String link;
	private String photo;
	private IconEnum icon;
	private boolean active;
	private boolean pushNotification;
	private boolean emailNotification;

}
