package io.dpm.dropmenote.ws.dto;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapperSingletonWrapper;

import io.dpm.dropmenote.db.entity.SharedUserEntity;
import io.dpm.dropmenote.ws.bean.SharedUser;

public class SharedUserDto {

	/**
	 * convert entity to bean
	 * @param source
	 * @return
	 */
	public static SharedUser convertToBean(SharedUserEntity source) {
		if (source == null) {
			return null;
		}
		SharedUser destination = new SharedUser();
		DozerBeanMapperSingletonWrapper.getInstance().map(source, destination);
		return destination;
	}
	
	/**
	 * convert bean to entity
	 * @param source
	 * @return
	 */
	public static SharedUserEntity convertToEntity(SharedUser source) {
		if (source == null) {
			return null;
		}
		SharedUserEntity destination = new SharedUserEntity();
		DozerBeanMapperSingletonWrapper.getInstance().map(source, destination);
		return destination;
	}
	
	/**
	 * convert List<Entity> to List<Bean>
	 * @param source
	 * @return
	 */
	public static List<SharedUser> convertToBean(List<SharedUserEntity> source) {
		if (source == null) {
			return null;
		}
		List<SharedUser> destination = new ArrayList<>();
		source.stream().forEach(entity -> destination.add(convertToBean(entity)));
		return destination;
	}
}
