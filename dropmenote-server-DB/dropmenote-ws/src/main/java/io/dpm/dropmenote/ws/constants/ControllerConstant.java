package io.dpm.dropmenote.ws.constants;

import org.springframework.http.MediaType;

public class ControllerConstant {

    public static final String MIME_JSON = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8";
    public static final String TEXT_HTML = MediaType.TEXT_HTML_VALUE;
    public static final String TEXT_PLAIN = MediaType.TEXT_PLAIN_VALUE;
    public static final String ALL = MediaType.ALL_VALUE;
    
    public static final String TOKEN_HEADER = "token";
    public static final String TOKEN_RECOVERY_PSWD_TOKEN = "recovery-pswd-token";
}
