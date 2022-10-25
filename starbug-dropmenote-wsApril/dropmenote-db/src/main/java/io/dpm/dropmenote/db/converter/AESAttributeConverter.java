package io.dpm.dropmenote.db.converter;

import javax.persistence.AttributeConverter;

import io.dpm.dropmenote.db.util.AESUtil;

/**
 * 
 * @author martinjurek
 *
 */
public class AESAttributeConverter implements AttributeConverter<String, String> {

	@Override
	public String convertToDatabaseColumn(String attribute) {
		return AESUtil.encrypt(attribute);
	}

	@Override
	public String convertToEntityAttribute(String dbData) {
		return AESUtil.decrypt(dbData);
	}

}
