
package io.dpm.dropmenote.db.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import io.dpm.dropmenote.db.entity.DeviceEntity;

/**
 * @author Peter Diskanec
 *
 */
public interface DeviceRepository extends JpaRepository<DeviceEntity, Long> {

	@Query("SELECT d.deviceId FROM DeviceEntity d WHERE d.user.login IN :userEmails AND d.user.pushNotification = true")
	List<String> findAllDeviceIdsByEmails(@Param("userEmails") List<String> userEmails);

	
	DeviceEntity findByDeviceIdAndUserId(String deviceId, long id);
	
	@Transactional
	void deleteByUserIdAndDeviceId(long userId, String deviceId);

}
