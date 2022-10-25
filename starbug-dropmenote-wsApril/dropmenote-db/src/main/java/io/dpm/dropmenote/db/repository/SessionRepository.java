package io.dpm.dropmenote.db.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import io.dpm.dropmenote.db.entity.SessionEntity;
import io.dpm.dropmenote.db.entity.UserEntity;

public interface SessionRepository extends JpaRepository<SessionEntity, Long> {
	
	public SessionEntity findByUserIdAndDeviceId(long userId, String deviceId);
	
	public SessionEntity findByToken(String token);
	
	@Query("SELECT s.user FROM SessionEntity s WHERE s.token = :token")
	public UserEntity findUserByToken(@Param("token") String token);

	@Transactional
	public void deleteByToken(String token);

}
