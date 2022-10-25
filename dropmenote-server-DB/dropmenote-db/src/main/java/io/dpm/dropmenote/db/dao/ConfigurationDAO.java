package io.dpm.dropmenote.db.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.dpm.dropmenote.db.repository.ConfigurationRepository;

/**
 * @author Peter Diskanec
 *
 */
@Service
public class ConfigurationDAO {

    @Autowired
    private ConfigurationRepository configRepository;

    public String findByKey(String key) {
        return configRepository.findByKey(key).getValue();
    }
}
