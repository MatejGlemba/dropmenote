package io.dpm.dropmenote.ws.constants;

/**
 * @author Martin Jurek (Starbug s.r.o. | https://www.strabug.eu)
 *
 */
public class ConfigurationConstant {

	public static final boolean IS_PRODUCTION = false;

	////////////////////////////////////////////////////
	// QRCODE image size for email ////////////////////////
	// staci zmenit sirku a vysku QRCODE_BG_WIDTH_.... QRCODE_BG_HEIGHT_..... ostatok je scalovane, 
	// treba zachovat pomer 1084:2002, cize 1:1,846863
	public static final int QRCODE_BG_WIDTH_LARGE = 1084/2; 
	public static final int QRCODE_BG_HEIGHT_LARGE = 2002/2;  
	
	public static final int QRCODE_BG_WIDTH_MEDIUM = QRCODE_BG_WIDTH_LARGE * 2/3; 
	public static final int QRCODE_BG_HEIGHT_MEDIUM = QRCODE_BG_HEIGHT_LARGE * 2/3; 
	public static final int QRCODE_BG_WIDTH_SMALL = QRCODE_BG_WIDTH_LARGE * 1/3;
	public static final int QRCODE_BG_HEIGHT_SMALL = QRCODE_BG_HEIGHT_LARGE * 1/3; 

	public static final int QRCODE_WIDTH_LARGE = (int) (QRCODE_BG_WIDTH_LARGE * 0.6398);
	public static final int QRCODE_HEIGHT_LARGE = QRCODE_WIDTH_LARGE;
	public static final int QRCODE_WIDTH_MEDIUM = (int) (QRCODE_BG_WIDTH_MEDIUM * 0.6398);
	public static final int QRCODE_HEIGHT_MEDIUM = QRCODE_WIDTH_MEDIUM;
	public static final int QRCODE_WIDTH_SMALL = (int) (QRCODE_BG_WIDTH_SMALL * 0.6398);
	public static final int QRCODE_HEIGHT_SMALL = QRCODE_WIDTH_SMALL;

	public static final int QRCODE_POS_X_LARGE = (int) (QRCODE_BG_WIDTH_LARGE * 0.1820);
	public static final int QRCODE_POS_Y_LARGE = (int) (QRCODE_BG_HEIGHT_LARGE * 0.3493);
	public static final int QRCODE_POS_X_MEDIUM = (int) (QRCODE_BG_WIDTH_MEDIUM * 0.1820);
	public static final int QRCODE_POS_Y_MEDIUM = (int) (QRCODE_BG_HEIGHT_MEDIUM * 0.3493);
	public static final int QRCODE_POS_X_SMALL = (int) (QRCODE_BG_WIDTH_SMALL * 0.1820);
	public static final int QRCODE_POS_Y_SMALL = (int) (QRCODE_BG_HEIGHT_SMALL * 0.3493);

	////////////////////////////////////////////////////
	//junta.pl
	public static final String MATRIX_SERVER = "matrix.dropmenote.com"; //https://matrix.dropmenote.com/
	public static final String WEBSOCKET_DATE_FORMAT = "dd. MMM yyyy HH:mm:ss";
	public static final String WEBSOCKET_DATE_TIMEZONE = "Europe/Bratislava";

}
