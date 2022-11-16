package io.dpm.dropmenote.ws.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.dpm.dropmenote.ws.controller.rrbean.AppInfoResponse;
import io.dpm.dropmenote.ws.handler.AppHandler;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author Martin Jurek (Starbug s.r.o. | https://www.strabug.eu)
 *
 */
@Api(value = "AppController", description = "AppController")
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RequestMapping("/ws/app")
public class AppController {

    private static Logger LOG = LoggerFactory.getLogger(AppController.class);

    {
        LOG.debug("{} initialisation.", AppController.class.getName());
    }

    @Autowired
    private AppHandler appHandler;

    /**
     * App information. It helps synchonise GUI with the app
     * 
     * @return
     */
    @ApiOperation(value = "Get application info", notes = "Get application info", responseContainer = "Object")
    @RequestMapping(value = "/appInfo", method = RequestMethod.GET)
    @ResponseBody
    public AppInfoResponse appInfo() {
        LOG.info("AppController - appInfo");
        return appHandler.appInfo();
    }

}
