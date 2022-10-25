package io.dpm.dropmenote.ws.websocket.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketSession;

import io.dpm.dropmenote.ws.bean.SessionBean;
import io.dpm.dropmenote.ws.bean.UserBean;
import io.dpm.dropmenote.ws.constants.ConfigurationConstant;
import io.dpm.dropmenote.ws.services.MatrixService;
import io.dpm.dropmenote.ws.services.SessionService;
import io.dpm.dropmenote.ws.websocket.websocketObject.websocketRequest.LoginRequest;

@Service
public class WebSocketNotificationHandlerService {
	private static Logger LOG = LoggerFactory.getLogger(WebSocketNotificationHandlerService.class);

	{
		LOG.debug("{} initialisation.", WebSocketNotificationHandlerService.class.getName());
	}
	
	@Autowired
	SessionService sessionService;

    @Autowired
    private MatrixService matrixService;
    
    public void handleUserLogin(WebSocketSession session, final LoginRequest request) throws Exception {
    	if(!session.isOpen()) {
    		throw new Exception("Session closed");
    	}
    	
    	// Session validation
		SessionBean sessionBean = sessionService.validate(request.getToken());
		UserBean userBean = sessionBean.getUser();
		
		matrixService.createClientAndSendNotificationsToWS(userBean.getMatrixUsername(), userBean.getMatrixPassword(), ConfigurationConstant.MATRIX_SERVER, session);
        
    }
}
