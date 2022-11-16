package io.dpm.dropmenote.ws.websocket.session;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import io.dpm.dropmenote.ws.constants.ConfigurationConstant;
import io.dpm.matrix.client.api.MatrixClient;
import lombok.Data;


/**
 * @author Peter Husarik
 */
@Component
public class ChatSessionInfo {
    private static Logger LOG = LoggerFactory.getLogger(ChatSessionInfo.class);

    {
        LOG.debug("WsSessionMatrixClientPairs initialisation.");
    }

    private static HashMap<String, Info> map;


    public ChatSessionInfo() {
        map = new HashMap<String, Info>();
    }

    /**
     * @param sessionId
     * @return true if this map contains a data for the specified session
     */
    public boolean contains(String sessionId) {
        return map.containsKey(sessionId);
    }

    /**
     * @param sessionId
     * @return the data for specified session, or null if no data for session exists
     */
    public Info get(String sessionId) {
    	return map.get(sessionId);
    }

    /**
     * Set matrix client associated with chat session
     * 
     * @param sessionId
     * @param client
     */
    public void set(String sessionId, MatrixClient client) {
    	Info prev = map.get(sessionId);
    	if(prev == null) {
    		Info n = new Info();
    		n.setMatrixClient(client);
    		map.put(sessionId, n);
    	}else {
    		prev.setMatrixClient(client);
    	}
    }
    
    /**
     * Set matrix room ID associated with chat session
     * 
     * @param sessionId
     * @param matrixRoomId
     */
    public void set(String sessionId, String matrixRoomId) {
    	Info prev = map.get(sessionId);
    	if(prev == null) {
    		Info n = new Info();
    		n.setMatrixRoomId(matrixRoomId);
    		map.put(sessionId, n);
    	}else {
    		prev.setMatrixRoomId(matrixRoomId);
    	}
    }

    /**
     * 
     * @param sessionId
     * @return the previous data associated with session, or null if there was no mapping for session
     */
    public Info remove(String sessionId) {
        return map.remove(sessionId);
    }

    /**
     * FOR TESTING ONLY
     * 
     * @return sessions hashmap
     * @throws UnsupportedOperationException in IS_PRODUCTION
     */
    public HashMap<String, Info> getAll() throws UnsupportedOperationException {
        if (ConfigurationConstant.IS_PRODUCTION) {
            throw new UnsupportedOperationException("Unavailable");
        }
        return map;
    }
    
    @Data
    public static class Info{
    	MatrixClient matrixClient;
    	String matrixRoomId;
    }

}