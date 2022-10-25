package io.dpm.dropmenote.ws.exception;

/**
 * 
 * @author martinjurek
 *
 */
public class EntityDoesntExistException extends DPNExceptionAbstract {

	private static final long serialVersionUID = -1586711761175412070L;

	/**
	 * 
	 * @param description
	 * @param e
	 */
	public EntityDoesntExistException(String description) {
		super("Entity doesn't exist");

		this.description = description;
		this.errorCode = 400_3;
	}
}
