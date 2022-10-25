package io.dpm.dropmenote.ws.utils;

import java.io.ByteArrayOutputStream;

import net.glxn.qrgen.javase.QRCode;

/**
 * 
 * @author martinjurek
 *
 */
public class QRCodeUtil {

	/**
	 * Generate QR code for the eventUuid and postUuid
	 * 
	 * @param eventUuid
	 * @param postUuid
	 * @param webpage
	 * @return
	 */

	public static byte[] generate(String message, int widthPX, int heidhtPx) {
		// Convert object to JSON string
		ByteArrayOutputStream stream = QRCode.from(message).withSize(widthPX, heidhtPx).stream();
		return stream.toByteArray();
	}

}
