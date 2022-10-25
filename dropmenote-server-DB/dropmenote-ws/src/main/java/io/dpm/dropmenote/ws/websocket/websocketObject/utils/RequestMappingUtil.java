package io.dpm.dropmenote.ws.websocket.websocketObject.utils;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class RequestMappingUtil {

    public <T> T _mapObjectFromString(Class<T> responseClassType, String data) throws IOException, JsonParseException, JsonMappingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return (T) objectMapper.readValue(data, responseClassType);
    }
}
