package io.dpm.dropmenote.ws.websocket.websocketObject.websocketResponse;

/**
 * @author phu (Starbug s.r.o. | https://www.starbug.eu)
 */
public class SuccessResponse extends AbstractResponse{
    private String data;

    public SuccessResponse(String data) {
        super(WebsocketResponseTypeEnum.SUCCESS);
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
