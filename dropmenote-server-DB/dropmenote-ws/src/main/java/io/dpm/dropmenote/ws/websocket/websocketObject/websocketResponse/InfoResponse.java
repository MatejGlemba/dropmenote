package io.dpm.dropmenote.ws.websocket.websocketObject.websocketResponse;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author phu (Starbug s.r.o. | https://www.starbug.eu)
 */
public class InfoResponse extends AbstractResponse{
    @JsonProperty("receivedData")
    private String data;

    public InfoResponse(String data) {
        super(WebsocketResponseTypeEnum.INFO);
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
