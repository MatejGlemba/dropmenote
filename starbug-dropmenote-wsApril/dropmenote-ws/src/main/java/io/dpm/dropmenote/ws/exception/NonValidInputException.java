package io.dpm.dropmenote.ws.exception;

/**
 * 
 * @author martinjurek
 *
 */
public class NonValidInputException extends DPNExceptionAbstract {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3344404831757387122L;
	
	/**
	 * 
	 * @param description
	 * @param e
	 */
	public NonValidInputException(String description) {
		super("Non valid ipnut value");

		this.description = description;
		this.errorCode = 400_4;
	}
}
