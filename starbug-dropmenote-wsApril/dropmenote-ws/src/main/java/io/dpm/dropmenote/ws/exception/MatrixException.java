package io.dpm.dropmenote.ws.exception;

/**
 * 
 * @author martinjurek
 *
 */
public class MatrixException extends DPNExceptionAbstract {

    private static final long serialVersionUID = -1586711761175412070L;

    /**
     * 
     * @param message
     */
    public MatrixException(String description, Exception e) {
        super("Problem with communication server", e);
        
        this.description = description;
        this.errorCode = 666400_2;
    }

}
