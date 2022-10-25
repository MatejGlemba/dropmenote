/**
 * Starbug, s.r.o.
 */
package io.dpm.dropmenote.ws.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.dpm.dropmenote.db.repository.ConfigurationRepository;

/**
 * @author Peter Diskanec
 *
 */
@Service
public class ConfigurationService {

    private static Logger LOG = LoggerFactory.getLogger(ConfigurationService.class);

    {
        LOG.debug("Configuration initialisation.");
    }

    @Autowired
    private ConfigurationRepository configurationRepository;

//    /**
//     * Load CONFIGURATIO_EMAIL_ADMINREPORT_EMAILCC
//     * 
//     * @return
//     */
//    public String load_CONFIGURATIO_EMAIL_ADMINREPORT_EMAILCC() {
//        return String.valueOf(loadValueByKey(ConfigurationConstant.CONFIGURATIO_EMAIL_ADMINREPORT_EMAILCC));
//    }

    /**
     * load config value by key. Attention, this method return only String value.
     * Safer is use the custom method for every key configuration.
     * 
     * @param key
     * @return
     */
    private String loadValueByKey(String key) {
        return configurationRepository.findByKey(key).getValue();
    }
}
