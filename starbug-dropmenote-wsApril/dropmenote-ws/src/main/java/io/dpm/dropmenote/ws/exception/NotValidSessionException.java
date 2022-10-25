package io.dpm.dropmenote.ws.exception;

/**
 * 
 * @author martinjurek
 *
 */
public class NotValidSessionException extends DPNExceptionAbstract {

	private static final long serialVersionUID = -1586711761175412070L;

	/**
	 * 
	 * @param description
	 * @param e
	 */
	public NotValidSessionException(String description) {
		super("Not valid session");

		this.description = description;
		this.errorCode = 400_6;
	}
}
