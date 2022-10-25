package io.dpm.dropmenote.ws.exception;

/**
 * 
 * @author martinjurek
 *
 */
public class UserAlreadyExistsException extends DPNExceptionAbstract {
	
	private static final long serialVersionUID = -1586711761175412070L;
	
	/**
	 * 
	 * @param description
	 * @param e
	 */
	public UserAlreadyExistsException(String description) {
		super("User already exists");

		this.description = description;
		this.errorCode = 400_8;
	}
}
