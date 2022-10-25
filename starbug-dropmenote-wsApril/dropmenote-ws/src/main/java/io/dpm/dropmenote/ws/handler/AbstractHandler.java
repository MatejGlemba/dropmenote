package io.dpm.dropmenote.ws.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.dpm.dropmenote.ws.services.PermissionValidatorService;
import io.dpm.dropmenote.ws.services.SessionService;

@Service
public class AbstractHandler {

	private static Logger LOG = LoggerFactory.getLogger(AbstractHandler.class);

	{
		LOG.debug("{} initialisation.", AbstractHandler.class.getName());
	}
	
	@Autowired
	protected SessionService sessionService;
	
	@Autowired
	protected PermissionValidatorService permissionValidatorService;

}
