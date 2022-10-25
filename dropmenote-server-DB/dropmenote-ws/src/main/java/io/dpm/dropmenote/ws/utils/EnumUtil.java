package io.dpm.dropmenote.ws.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EnumUtil {
	
	
	public static String name(Enum<?> enumType) {
		return enumType.name();
	}

	public static <T extends Enum<T> & CodeBookEnum> T findEnumByContenet(final Class<T> enumType, final String contenet) {

		if (enumType == null) {
			throw new NullPointerException("enumType");
		}

		for (final T enumConstant : enumType.getEnumConstants()) {
			if (((CodeBookEnum) enumConstant).getContenet() == contenet) {
				return enumConstant;
			}
		}

		throw new IllegalArgumentException(
				String.format("Enum %s doesn't contain value with code %d", enumType.getCanonicalName(), contenet));
	}

	public static <T extends Enum<T>> T findEnumByName(final Class<T> enumType, final String name) {

		if (enumType == null) {
			throw new NullPointerException("enumType");
		}

		if (name == null) {
			throw new NullPointerException("name");
		}

		final String normalizedName = name.replace('-', '_');

		for (final T enumConstant : enumType.getEnumConstants()) {
			if (normalizedName.equals(enumConstant.name())) {
				return enumConstant;
			}
		}

		throw new IllegalArgumentException(String.format("Enum %s doesn't contain value with name %s",
				enumType.getCanonicalName(), normalizedName));
	}


	public static <T extends Enum<T>> boolean isIn(final T value, final T... values) {

		if (value == null || values == null || values.length < 1) {
			return false;
		}

		for (final T v : values) {
			if (v == value) {
				return true;
			}
		}

		return false;
	}

	public static <T extends Enum<T> & CodeBookEnum> boolean isIn(final String contenet, final T... values) {

		if (values == null || values.length < 1) {
			return false;
		}

		final T value = EnumUtil.findEnumByContenet((Class<T>) values[0].getClass(), contenet);
		return isIn(value, values);
	}
	
	public static <T extends Enum<T> & CodeBookEnum> List<String> contenet(final T... values) {

		if (values == null) {
			return null;
		}

		final ArrayList<String> result = new ArrayList<>(values.length);

		for (final T value : values) {
			result.add(value.getContenet());
		}

		return Collections.unmodifiableList(result);
	}
}
