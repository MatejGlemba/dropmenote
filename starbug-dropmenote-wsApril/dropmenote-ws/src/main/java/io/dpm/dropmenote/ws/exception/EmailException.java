package io.dpm.dropmenote.ws.exception;

/**
 * 
 * @author martinjurek
 *
 */
public class EmailException extends DPNExceptionAbstract {

    private static final long serialVersionUID = -1586711761175412070L;

    /**
     * 
     * @param message
     */
    public EmailException(String description, Exception e) {
        super("Email not send", e);
        
        this.description = description;
        this.errorCode = 400_2;
    }

}
