package io.dpm.dropmenote.ws.controller.rrbean;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString(includeFieldNames = true)
public class DPNExceptionResponse {

	@JsonProperty
	private String message;

	@JsonProperty
	private String description;

	@JsonProperty
	private Integer errorCode;

	@JsonProperty
	private HttpStatus statusCode;

	// Do not show stack trace in production
	// @JsonIgnore(SettingConstant.IS_PRODUCTION)
	@JsonProperty
	private String stackTrace;

}
