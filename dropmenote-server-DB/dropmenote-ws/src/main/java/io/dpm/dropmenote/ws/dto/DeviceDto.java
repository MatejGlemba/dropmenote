/**
 * 
 */
package io.dpm.dropmenote.ws.dto;

import org.dozer.DozerBeanMapperSingletonWrapper;

import io.dpm.dropmenote.db.entity.DeviceEntity;
import io.dpm.dropmenote.ws.bean.DeviceBean;

/**
 * @author Martin Jurek (Starbug s.r.o. | https://www.strabug.eu)
 *
 */
public class DeviceDto {

    /**
     * 
     * @param source
     * @return
     */
    public static DeviceBean convertToBean(DeviceEntity source) {
		if (source == null) {
	     	return null;
	    }
        DeviceBean deviceBean = new DeviceBean();
        DozerBeanMapperSingletonWrapper.getInstance().map(source, deviceBean);
        return deviceBean;
    }

    /**
     * !! it doesnt support DB update. Missing ID!
     * 
     * @param source
     * @return
     */
    public static DeviceEntity convertToEntity(DeviceBean source) {
        if (source == null) {
        	return null;
        }
        DeviceEntity destination = new DeviceEntity();
        DozerBeanMapperSingletonWrapper.getInstance().map(source, destination);
        return destination;
    }

}
