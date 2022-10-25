/**
 * 
 */
package io.dpm.dropmenote.ws.dto;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapperSingletonWrapper;

import io.dpm.dropmenote.db.entity.BlacklistEntity;
import io.dpm.dropmenote.ws.bean.BlacklistBean;
import io.dpm.dropmenote.ws.controller.rrbean.BlackListRequest;
import io.dpm.dropmenote.ws.controller.rrbean.BlackListResponse;

/**
 * @author Martin Jurek (Starbug s.r.o. | https://www.strabug.eu)
 *
 */
public class BlackListDto {

	/**
	 * Map value into destination object
	 * 
	 * @param destination
	 * @param source
	 * @return
	 */
	public static BlacklistBean mapInto(BlacklistBean destination, BlackListRequest source) {
		// TODO je to robre?
		if (source == null) {
			return null;
		}
		DozerBeanMapperSingletonWrapper.getInstance().map(source, destination);
		return destination;
	}

	/**
	 * Map value into destination object
	 * 
	 * @param destination
	 * @param source
	 * @return
	 */
	public static BlackListRequest mapInto(BlackListRequest destination, BlacklistBean source) {
		// TODO je to robre?
		if (source == null) {
			return null;
		}
		DozerBeanMapperSingletonWrapper.getInstance().map(source, destination);
		return destination;
	}
	
	/**
	 * Map value into destination object
	 * 
	 * @param destination
	 * @param source
	 * @return
	 */
	public static BlackListResponse mapInto(BlackListResponse destination, BlacklistBean source) {
		// TODO je to robre?
		if (source == null) {
			return null;
		}
		DozerBeanMapperSingletonWrapper.getInstance().map(source, destination);
		return destination;
	}
	
	/**
	 * Map value into destination object
	 * 
	 * @param destination
	 * @param source
	 * @return
	 */
	public static List<BlackListResponse> mapInto(List<BlackListResponse> destination, List<BlacklistBean> source) {
		// TODO je to robre?
		if (source == null) {
			return null;
		}
		
		for (BlacklistBean blacklistBeanIter : source) {
			destination.add(mapInto(new BlackListResponse(), blacklistBeanIter));
		}
		
		return destination;
	}

	/**
	 * 
	 * @param source
	 * @return
	 */
	public static BlacklistBean convertToBean(BlacklistEntity source) {
		if (source == null) {
			return null;
		}
		BlacklistBean configurationBean = new BlacklistBean();
		DozerBeanMapperSingletonWrapper.getInstance().map(source, configurationBean);
		return configurationBean;
	}

	/**
	 * 
	 * @param source
	 * @return
	 */
	public static List<BlacklistBean> convertToBean(List<BlacklistEntity> source) {
		List<BlacklistBean> destinationList = new ArrayList<BlacklistBean>();

		for (BlacklistEntity blackListEntity : source) {
			destinationList.add(convertToBean(blackListEntity));
		}

		return destinationList;
	}

	/**
	 * !! it doesnt support DB update. Missing ID!
	 * 
	 * @param source
	 * @return
	 */
	public static BlacklistEntity convertToEntity(BlacklistBean source) {
		if (source == null) {
			return null;
		}
		BlacklistEntity destination = new BlacklistEntity();
		DozerBeanMapperSingletonWrapper.getInstance().map(source, destination);
		return destination;
	}

}
