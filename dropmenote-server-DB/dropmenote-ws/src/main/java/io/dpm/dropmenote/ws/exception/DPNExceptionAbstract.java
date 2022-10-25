package io.dpm.dropmenote.ws.exception;

/**
 * 
 * @author martinjurek
 *
 */
public class DPNExceptionAbstract extends Exception {

    private static final long serialVersionUID = -1586711761175412070L;
    
    protected String description;
    protected int errorCode;
    
    /**
     * 
     * @param message
     */
    public DPNExceptionAbstract(String description, Exception e) {
        super(description, e);
        
        this.description = description;
        this.errorCode = 400_1;
    }
    
    /**
     * 
     * @param message
     */
    public DPNExceptionAbstract(String description) {
        this(description, null);
        
        this.description = description;
        this.errorCode = 400_1;
    }
    
    public int getErrorCode() {
		return errorCode;
	}
    
    public String getDescription() {
		return description;
	}
    
    @Override
    public String getMessage() {
    	return super.getMessage();
    }

}
