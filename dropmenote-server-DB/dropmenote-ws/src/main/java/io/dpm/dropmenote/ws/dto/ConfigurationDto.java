/**
 * 
 */
package io.dpm.dropmenote.ws.dto;

import org.dozer.DozerBeanMapperSingletonWrapper;

import io.dpm.dropmenote.db.entity.ConfigurationEntity;
import io.dpm.dropmenote.ws.bean.ConfigurationBean;

/**
 * @author Martin Jurek (Starbug s.r.o. | https://www.strabug.eu)
 *
 */
public class ConfigurationDto {

    /**
     * 
     * @param source
     * @return
     */
    public static ConfigurationBean convertToBean(ConfigurationEntity source) {
        ConfigurationBean configurationBean = new ConfigurationBean();
        DozerBeanMapperSingletonWrapper.getInstance().map(source, configurationBean);
        return configurationBean;
    }

    /**
     * !! it doesnt support DB update. Missing ID!
     * 
     * @param source
     * @return
     */
    public static ConfigurationEntity convertToEntity(ConfigurationBean source) {
        ConfigurationEntity destination = new ConfigurationEntity();
        DozerBeanMapperSingletonWrapper.getInstance().map(source, destination);
        return destination;
    }

}
