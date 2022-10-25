package io.dpm.dropmenote.ws.bean;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(includeFieldNames = true)
public class QRCodeListBean extends AbstractBean {

	/**
	 * Default constructor
	 */
	public QRCodeListBean() {

	}

	private long id;
	private String uuid;

}
