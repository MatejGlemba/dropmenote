package io.dpm.dropmenote.db.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import io.dpm.dropmenote.db.entity.QRCodeEntity;
import io.dpm.dropmenote.db.entity.SharedUserEntity;

public interface SharedUserRepository extends JpaRepository<SharedUserEntity, Long> {
	
	public SharedUserEntity findByOwnerIdAndQrCodeIdAndShareUserLogin(long ownerId, long qrCodeId, String userLogin);
	
	public List<SharedUserEntity> findByQrCodeId(long qrCodeId);
	
	//TODO neviem preco Transactional, ale neslo bez neho
	//hadzalo exception: No EntityManager with actual transaction available for current thread - cannot reliably process 'remove'
	@Transactional
	public void deleteByQrCodeIdAndShareUserLogin(long qrCodeId, String userLogin);
	
	public List<SharedUserEntity> findByShareUserId(long sharedUserId); 

	public SharedUserEntity findByQrCodeIdAndShareUserId(long qrCodeId, long shareUserId);

	@Query("SELECT s.qrCode FROM SharedUserEntity s WHERE s.shareUser.id = :userId")
	public List<QRCodeEntity> findQrCodesBySharedUserId(@Param("userId") long userId);

	public SharedUserEntity findByQrCodeIdAndShareUserLogin(long qrCodeId, String shareUserLogin);
}
