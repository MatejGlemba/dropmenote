package io.dpm.dropmenote.ws.handler.interfaces;

import io.dpm.dropmenote.ws.bean.SessionBean;
import io.dpm.dropmenote.ws.exception.NotValidSessionException;
import io.dpm.dropmenote.ws.exception.PermissionDeniedException;

/**
 * 
 * @author martinjurek
 *
 */
public interface SessionPermissionValidatorInterface {

	/**
	 * 
	 * @param token
	 * @param idToValid
	 * @throws NotValidSessionException
	 * @throws PermissionDeniedException
	 */
	public SessionBean validateSessionAndPermission(String token, Long idToValid) throws NotValidSessionException, PermissionDeniedException;
}
