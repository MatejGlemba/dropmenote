/**
 * 
 */
package io.dpm.dropmenote.ws.dto;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapperSingletonWrapper;

import io.dpm.dropmenote.db.entity.MatrixEntity;
import io.dpm.dropmenote.ws.bean.MatrixBean;

/**
 * @author Peterko
 *
 */
public class MatrixDto {

	/**
	 * convert Entity to Bean
	 * @param authInfoRequest
	 * @return
	 */
	public static MatrixBean convertToBean(MatrixEntity source) {
		if (source == null) {
			return null;
		}
		MatrixBean destination = new MatrixBean();
		DozerBeanMapperSingletonWrapper.getInstance().map(source, destination);
		return destination;
	}

	/**
	 * convert Bean to Entity
	 * @param source
	 * @return
	 */
	public static MatrixEntity convertToEntity(MatrixBean source) {
		if (source == null) {
			return null;
		}
		MatrixEntity destination = new MatrixEntity();
		DozerBeanMapperSingletonWrapper.getInstance().map(source, destination);
		return destination;
	}

	/**
	 * convert List<Entity> to List<Bean>
	 * @param source
	 * @return
	 */
	public static List<MatrixBean> convertToBean(List<MatrixEntity> source) {
		if (source == null) {
			return null;
		}
		List<MatrixBean> destination = new ArrayList<>();
		source.stream().forEach(entity -> destination.add(convertToBean(entity)));
		return destination;
	}
	
	/**
	 * convert List<Bean> to List<Entity>
	 * @param source
	 * @return
	 */
	public static List<MatrixEntity> convertToEntity(List<MatrixBean> source) {
		if (source == null) {
			return null;
		}
		List<MatrixEntity> destination = new ArrayList<>();
		source.stream().forEach(bean -> destination.add(convertToEntity(bean)));
		return destination;
	}
}
