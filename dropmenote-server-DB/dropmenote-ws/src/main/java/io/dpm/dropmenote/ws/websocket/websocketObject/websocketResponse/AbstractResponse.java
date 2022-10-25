package io.dpm.dropmenote.ws.websocket.websocketObject.websocketResponse;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.dpm.dropmenote.ws.constants.ConfigurationConstant;

/**
 * @author phu (Starbug s.r.o. | https://www.starbug.eu)
 */
public class AbstractResponse {

    @JsonProperty("serverTime")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = ConfigurationConstant.WEBSOCKET_DATE_FORMAT, timezone = ConfigurationConstant.WEBSOCKET_DATE_TIMEZONE)
	private Date serverTime = new Date();

    @JsonProperty("type")
    private WebsocketResponseTypeEnum type;

    AbstractResponse(WebsocketResponseTypeEnum type) {
        this.type = type;
    }

    public Date getServerTime() {
        return serverTime;
    }

    public void setServerTime(Date serverTime) {
        this.serverTime = serverTime;
    }

    public WebsocketResponseTypeEnum getType() {
        return type;
    }

    public void setType(WebsocketResponseTypeEnum type) {
        this.type = type;
    }
}
