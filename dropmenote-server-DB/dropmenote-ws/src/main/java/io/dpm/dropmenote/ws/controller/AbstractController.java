package io.dpm.dropmenote.ws.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import io.dpm.dropmenote.ws.controller.rrbean.DPNExceptionResponse;
import io.dpm.dropmenote.ws.exception.DPNExceptionAbstract;
import io.dpm.dropmenote.ws.utils.LogMessageUtil;

/**
 * 
 * @author abo (Starbug s.r.o. | https://www.starbug.eu)
 *
 */
public class AbstractController {

	private static Logger LOG = LoggerFactory.getLogger(AbstractController.class);

	{
		LOG.debug("AbstractController initialisation.");
	}

	@ResponseBody
	@ExceptionHandler()
	public ResponseEntity<DPNExceptionResponse> handleException(DPNExceptionAbstract dpnExceptionAbstract) {
		LOG.error(dpnExceptionAbstract.getMessage() + " || " + LogMessageUtil.getExceptionMessage(dpnExceptionAbstract.getCause()));

		DPNExceptionResponse dpnExceptionResponse = new DPNExceptionResponse(dpnExceptionAbstract.getMessage(), dpnExceptionAbstract.getDescription(), dpnExceptionAbstract.getErrorCode(), HttpStatus.BAD_REQUEST, null);
		return new ResponseEntity<DPNExceptionResponse>(dpnExceptionResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST);
	}
}
