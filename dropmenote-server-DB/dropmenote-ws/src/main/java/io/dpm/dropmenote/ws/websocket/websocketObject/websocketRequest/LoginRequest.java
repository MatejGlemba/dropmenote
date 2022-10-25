package io.dpm.dropmenote.ws.websocket.websocketObject.websocketRequest;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
/**
 * Type je WebsocketRequestTypeEnum.LOGIN
 *
 * Token alebo fingerprint je povinny.
 * roomId je povinne pre chat ak som owner qr kodu
 * 
 * @author Peter Husarik
 *
 */
public class LoginRequest {

    private WebsocketRequestTypeEnum type;

    /**
     * token posiela prihlaseny uzivatel
     */
    private String token;
    
    /**
     * fingerprint posiela anonymny uzivatel bez registracie
     */
    private String fingerprint;

    /**
     * QR code UUID
     */
	@JsonProperty("qr")
    private String qrCodeUuid;

	/**
     * chat room ID in matrix table
     */
	@JsonProperty("roomId")
    private Long roomId;

}
