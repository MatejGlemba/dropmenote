package io.dpm.dropmenote.ws.exception;

/**
 * 
 * @author martinjurek
 *
 */
public class NotValidRecoverPswdTokenException extends DPNExceptionAbstract {

	private static final long serialVersionUID = -1586711761175412070L;

	/**
	 * 
	 * @param description
	 * @param e
	 */
	public NotValidRecoverPswdTokenException(String description) {
		super("Non valid email token");

		this.description = description;
		this.errorCode = 400_5;
	}
}
