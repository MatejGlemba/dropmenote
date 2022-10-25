package io.dpm.dropmenote.ws.websocket.websocketObject.websocketResponse;

/**
 * @author phu (Starbug s.r.o. | https://www.starbug.eu)
 */
public class ErrorResponse extends AbstractResponse{
    private String data;

    public ErrorResponse(String data) {
        super(WebsocketResponseTypeEnum.ERROR);
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
