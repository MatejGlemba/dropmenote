package io.dpm.dropmenote.ws.controller.rrbean;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.ToString;

/**
 * @author Martin Jurek (Starbug s.r.o. | https://www.strabug.eu)
 *
 */
@Data
@ToString(includeFieldNames = true)
public class AuthInfoRequest {

    @JsonProperty("login")
    private String login;

    @JsonProperty("password")
    private String password;

    @JsonProperty("deviceId")
    private String deviceId;

}
