package io.dpm.dropmenote.ws.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import io.dpm.dropmenote.ws.controller.rrbean.AppInfoResponse;

/**
 * 
 * @author Martin Jurek (Starbug s.r.o. | https://www.strabug.eu)
 *
 */
@Service
public class AppHandler {

    private static Logger LOG = LoggerFactory.getLogger(AppHandler.class);

    {
        LOG.debug("{} initialisation.", AppHandler.class.getName());
    }

    /**
     * App information. It helps synchonise GUI with the app
     * 
     * @return
     */
    public AppInfoResponse appInfo() {
        AppInfoResponse appInfoResponse = new AppInfoResponse();
        appInfoResponse.setAppVersion("??? TODO z pom.xml ???");
        appInfoResponse.setServerTime(System.currentTimeMillis());
        return appInfoResponse;
    }

}
