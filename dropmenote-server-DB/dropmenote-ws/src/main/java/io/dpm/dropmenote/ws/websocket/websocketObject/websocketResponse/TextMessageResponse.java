package io.dpm.dropmenote.ws.websocket.websocketObject.websocketResponse;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.dpm.dropmenote.ws.constants.ConfigurationConstant;
import io.dpm.dropmenote.ws.enums.ChatIconPositionEnum;
import io.dpm.dropmenote.ws.enums.UserTypeEnum;
import lombok.Data;

/**
 * @author phu (Starbug s.r.o. | https://www.starbug.eu)
 */
@Data
public class TextMessageResponse extends AbstractResponse {

	private String alias;
	/**
	 *  user uuid or fingerprint
	 */
	private String from;
	private String message;
	private UserTypeEnum userType; 
	private ChatIconPositionEnum position;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = ConfigurationConstant.WEBSOCKET_DATE_FORMAT, timezone = ConfigurationConstant.WEBSOCKET_DATE_TIMEZONE)
	private Date date;
	private String image;
	private String qrName;
	
    public TextMessageResponse() {
        super(WebsocketResponseTypeEnum.TEXT_MESSAGE);
    }
}
