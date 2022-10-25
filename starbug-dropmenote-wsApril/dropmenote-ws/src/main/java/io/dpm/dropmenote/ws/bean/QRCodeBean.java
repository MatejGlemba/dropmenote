package io.dpm.dropmenote.ws.bean;

import java.util.HashSet;
import java.util.Set;

import io.dpm.dropmenote.ws.enums.IconEnum;
import io.dpm.dropmenote.ws.enums.QRCodeTypeEnum;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(includeFieldNames = true)
public class QRCodeBean extends AbstractBean {

	/**
	 * Default constructor
	 */
	public QRCodeBean() {

	}

	private long id;

	private QRCodeTypeEnum type;
	private Set<UserBean> sharedUsers = new HashSet<>();
	private String uuid;
	private String ownerAlias;
	private UserBean owner;
	private String name;
	private String description;
	private String photo;
	private String link;
	private IconEnum icon;
	private boolean active;
	private boolean pushNotification;
	private boolean emailNotification;

}
