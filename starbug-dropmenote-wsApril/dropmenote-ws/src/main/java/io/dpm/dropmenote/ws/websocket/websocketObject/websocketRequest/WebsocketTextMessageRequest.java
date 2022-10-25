package io.dpm.dropmenote.ws.websocket.websocketObject.websocketRequest;

import lombok.Data;

/**
 * @author phu (Starbug s.r.o. | https://www.starbug.eu)
 */
@Data
public class WebsocketTextMessageRequest{

	private WebsocketRequestTypeEnum type;
	private String token;
//	private String from;
	private String message;
//	private UserTypeEnum userType; 
//	private ChatIconPositionEnum position;

}
