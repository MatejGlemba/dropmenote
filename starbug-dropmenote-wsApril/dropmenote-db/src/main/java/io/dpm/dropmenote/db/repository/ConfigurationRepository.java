
package io.dpm.dropmenote.db.repository;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import io.dpm.dropmenote.db.constant.CacheConstants;
import io.dpm.dropmenote.db.entity.ConfigurationEntity;

/**
 * @author Peter Diskanec
 *
 */
public interface ConfigurationRepository extends JpaRepository<ConfigurationEntity, Long> {

    @Cacheable(value = CacheConstants.CONFIGURATIONREPOSITORY_FINDBYKEY)
    public ConfigurationEntity findByKey(String key);

}
