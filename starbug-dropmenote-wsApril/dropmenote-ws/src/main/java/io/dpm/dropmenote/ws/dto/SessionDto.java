package io.dpm.dropmenote.ws.dto;

import org.dozer.DozerBeanMapperSingletonWrapper;

import io.dpm.dropmenote.db.entity.SessionEntity;
import io.dpm.dropmenote.ws.bean.SessionBean;

public class SessionDto {

	public static SessionBean convertToBean(SessionEntity source) {
		if (source == null) {
			return null;
		}
		SessionBean configurationBean = new SessionBean();
		DozerBeanMapperSingletonWrapper.getInstance().map(source, configurationBean);
		return configurationBean;
	}
	
	public static SessionEntity convertToEntity(SessionBean source) {
		if (source == null) {
			return null;
		}
		SessionEntity configurationBean = new SessionEntity();
		DozerBeanMapperSingletonWrapper.getInstance().map(source, configurationBean);
		return configurationBean;
	}
	
	
	
	
}
