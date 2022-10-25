package io.dpm.dropmenote.ws.exception;

/**
 * 
 * @author martinjurek
 *
 */
public class NonValidLoginInformationException extends DPNExceptionAbstract {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3344404831757387122L;
	
	/**
	 * 
	 * @param description
	 * @param e
	 */
	public NonValidLoginInformationException(String description) {
		super("Non valid login or password");

		this.description = description;
		this.errorCode = 400_4;
	}
}
