package io.dpm.dropmenote.ws.bean;

import lombok.Data;
import lombok.ToString;

/**
 * @author Peterko
 *
 */
@Data
@ToString(includeFieldNames = true)
public class BlacklistBean extends AbstractBean {

	/**
	 * Default constructor
	 */
	public BlacklistBean() {

	}

	private long id;
	private UserBean owner;
	private String uuid;
	private String note;
	private String alias;

}
