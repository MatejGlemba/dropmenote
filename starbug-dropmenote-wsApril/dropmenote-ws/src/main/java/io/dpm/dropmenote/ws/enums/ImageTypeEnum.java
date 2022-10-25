package io.dpm.dropmenote.ws.enums;

import io.dpm.dropmenote.ws.utils.CodeBookEnum;

public enum ImageTypeEnum implements CodeBookEnum {
	
	BASE64_JPEG_PREFIX("data:image/jpeg;base64,"),
	BASE64_PNG_PREFIX("data:image/png;base64,"),
	BASE64_BMP_PREFIX("data:image/bmp;base64,"),
	BASE64_JPG_PREFIX("data:image/jpg;base64,");
	
	
	private String contenet;


	ImageTypeEnum(String prefix) {
		this.contenet = prefix;
	}

	@Override
	public String getContenet() {
		return contenet;
	}


	
}
