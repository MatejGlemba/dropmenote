package io.dpm.dropmenote.ws.websocket.websocketObject.websocketResponse;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.dpm.dropmenote.ws.constants.ConfigurationConstant;
import io.dpm.dropmenote.ws.enums.ChatIconPositionEnum;
import io.dpm.dropmenote.ws.enums.UserTypeEnum;
import lombok.Data;

/**
 * @author phu (Starbug s.r.o. | https://www.starbug.eu)
 */
@Data
public class NotificationTextMessageResponse extends AbstractResponse {

	private String msg;
	private String from;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = ConfigurationConstant.WEBSOCKET_DATE_FORMAT, timezone = ConfigurationConstant.WEBSOCKET_DATE_TIMEZONE)
	private Date date;
	private UserTypeEnum userType; 
	private ChatIconPositionEnum position;
	private String image;
	private Long roomId;
	@JsonProperty("qr")
	private String qrCodeUuid;

	public NotificationTextMessageResponse() {
        super(WebsocketResponseTypeEnum.NOTIFICATION_TEXT_MESSAGGE);
    }
	
    public NotificationTextMessageResponse(String msg, String from, Date date, UserTypeEnum userType, ChatIconPositionEnum position, String image, long roomId, String qrCodeUuid) {
        super(WebsocketResponseTypeEnum.NOTIFICATION_TEXT_MESSAGGE);
        this.from = from;
        this.msg = msg;
        this.date = date;
        this.userType = userType;
        this.position = position;
        this.image = image;
        this.roomId = roomId;
        this.qrCodeUuid = qrCodeUuid;
    }

}
