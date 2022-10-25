package io.dpm.dropmenote.ws.websocket.websocketObject.websocketResponse;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author phu (Starbug s.r.o. | https://www.starbug.eu)
 */
public class ServerTimeResponse extends AbstractResponse{
    public ServerTimeResponse() {
        super(WebsocketResponseTypeEnum.SERVER_TIME);
    }

    @JsonProperty("timestamp")
    public long getTimestamp() {
        return getServerTime().getTime();
    }
}
