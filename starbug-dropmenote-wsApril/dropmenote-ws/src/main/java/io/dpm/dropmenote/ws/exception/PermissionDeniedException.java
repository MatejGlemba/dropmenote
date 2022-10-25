package io.dpm.dropmenote.ws.exception;

/**
 * 
 * @author martinjurek
 *
 */
public class PermissionDeniedException extends DPNExceptionAbstract {

	private static final long serialVersionUID = -1586711761175412070L;

	/**
	 * 
	 * @param description
	 * @param e
	 */
	public PermissionDeniedException(String description) {
		super("Permission denied");

		this.description = description;
		this.errorCode = 400_7;
	}
}
