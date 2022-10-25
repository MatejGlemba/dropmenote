/**
 * 
 */
package io.dpm.dropmenote.ws.dto;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapperSingletonWrapper;

import io.dpm.dropmenote.db.entity.UserEntity;
import io.dpm.dropmenote.ws.bean.UserBean;
import io.dpm.dropmenote.ws.controller.rrbean.AuthInfoRequest;
import io.dpm.dropmenote.ws.controller.rrbean.UserBeanRequest;
import io.dpm.dropmenote.ws.controller.rrbean.UserBeanResponse;

/**
 * @author Martin Jurek (Starbug s.r.o. | https://www.strabug.eu)
 *
 */
public class UserDto {

	/**
	 * Map value into destination object
	 * 
	 * @param destination
	 * @param source
	 * @return
	 */
	public static UserBean mapInto(UserBean destination, UserBeanRequest source) {
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
	public static List<String> mapInto(List<String> destination, List<UserBean> source) {
		// TODO je to robre?
		if (source == null) {
			return null;
		}

		for (UserBean userBean : source) {
			destination.add(userBean.getLogin());
		}
		return destination;
	}

	/**
	 * Map value into destination object
	 * 
	 * @param destination
	 * @param source
	 * @return
	 */
	public static UserBeanResponse mapInto(UserBeanResponse destination, UserBean source) {
		// TODO je to robre?
		if (source == null) {
			return null;
		}
		DozerBeanMapperSingletonWrapper.getInstance().map(source, destination);
		return destination;
	}

	/**
	 * 
	 * @param source
	 * @return
	 */
	public static UserBean convertToBean(UserEntity source) {
		if (source == null) {
			return null;
		}
		UserBean userBean = new UserBean();
		DozerBeanMapperSingletonWrapper.getInstance().map(source, userBean);
		return userBean;
	}

	/**
	 * 
	 * @param source
	 * @return
	 */
	public static List<UserBean> convertToBean(List<UserEntity> source) {
		List<UserBean> destinationList = new ArrayList<UserBean>();

		for (UserEntity userEntity : source) {
			destinationList.add(convertToBean(userEntity));
		}

		return destinationList;
	}

	/**
	 * 
	 * @param authInfoRequest
	 * @return
	 */
	public static UserBean convertToBean(AuthInfoRequest authInfoRequest) {
		if (authInfoRequest == null) {
			return null;
		}
		UserBean userBean = new UserBean();
		userBean.setLogin(authInfoRequest.getLogin());
		userBean.setPassword(authInfoRequest.getPassword());
		return userBean;
	}

	/**
	 * !! it doesnt support DB update. Missing ID!
	 * 
	 * @param source
	 * @return
	 */
	public static UserEntity convertToEntity(UserBean source) {
		if (source == null) {
			return null;
		}
		UserEntity destination = new UserEntity();
		DozerBeanMapperSingletonWrapper.getInstance().map(source, destination);
		return destination;
	}

}
