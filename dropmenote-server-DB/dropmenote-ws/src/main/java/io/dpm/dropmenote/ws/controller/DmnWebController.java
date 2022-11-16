package io.dpm.dropmenote.ws.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.dpm.dropmenote.ws.exception.NonValidInputException;
import io.dpm.dropmenote.ws.exception.PermissionDeniedException;
import io.dpm.dropmenote.ws.handler.DmnWebHandler;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author Martin Jurek (Starbug s.r.o. | https://www.strabug.eu)
 *
 */
@Api(value = "DmnWebController", description = "DmnWebController")
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RequestMapping("/ws/dmnweb")
public class DmnWebController extends AbstractController {

	private static Logger LOG = LoggerFactory.getLogger(DmnWebController.class);

	{
		LOG.debug("{} initialisation.", DmnWebController.class.getName());
	}

//	private Set<String> whitelist = new HashSet<String>();

	@Autowired
	private DmnWebHandler dmnWebHandler;

//	/**
//	 * 
//	 */
//	public DmnWebController() {
//		whitelist.add("188.123.98.141");
//		whitelist.add("dropmenote.com");
//	}

	/**
	 * Generate dmn codes into qrcodelist and return csv file with the list
	 * 
	 * @param dmnCount
	 * @return
	 * @throws NonValidInputException
	 * @throws IOException
	 */
	@ApiOperation(value = "Generate DMN code into CSV file", notes = "Generate DMN code into CSV file", responseContainer = "Object")
	@RequestMapping(value = "/generateDmnCodeAndCSV", method = RequestMethod.GET)
	@ResponseBody
	public void generateDmnCodeAndCSV(int dmnCount, HttpServletRequest httpServletRequest, HttpServletResponse httpResposne) throws PermissionDeniedException, IOException, NonValidInputException {
//		String ipAddress = httpServletRequest.getHeader("X-FORWARDED-FOR");  
//		if (ipAddress == null) {  
//		    ipAddress = httpServletRequest.getRemoteAddr();  
//		}
//		
//		System.out.println("ipAddress:"+ipAddress);
//		
//		if (whitelist.contains(ipAddress)) {
			// Append file into response header
		LOG.info("DmnWebController - generateDmnCodeAndCSV - dmnCount {}", dmnCount);
			dmnWebHandler.generateDmnCodeAndCSV(dmnCount, httpResposne);
//		} else {
//			throw new PermissionDeniedException("Not allowed to call this method!");
//		}

	}

}
