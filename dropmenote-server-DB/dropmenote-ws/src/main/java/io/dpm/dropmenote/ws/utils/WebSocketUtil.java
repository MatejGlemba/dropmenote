package io.dpm.dropmenote.ws.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.TextMessage;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author phu (Starbug s.r.o. | https://www.starbug.eu)
 */
public class WebSocketUtil {
    private static Logger LOG = LoggerFactory.getLogger(WebSocketUtil.class);

    private static ObjectMapper jsonMapper = new ObjectMapper();

    /**
     * Create websocket text message from bean
     * @param o json object bean
     * @return TextMessage or null if problem occurs
     */
    public static TextMessage createWebSocketTextMessage(Object o){
        try {
            return new TextMessage(jsonMapper.writeValueAsString(o));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
