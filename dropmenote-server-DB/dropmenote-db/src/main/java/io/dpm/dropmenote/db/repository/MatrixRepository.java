package io.dpm.dropmenote.db.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import io.dpm.dropmenote.db.entity.MatrixEntity;
import io.dpm.dropmenote.db.objects.QrUuidRoomCountPair;

public interface MatrixRepository extends JpaRepository<MatrixEntity, Long> {

	@Query(nativeQuery = true, value = 
			"SELECT m.matrix_room_id "
			+ "FROM MATRIX m "
			+ "WHERE :userUuid = m.user_uuid AND :qrUuid = m.qr_code_uuid")
	public String findMatrixRoomIdByUserUuidAndQrCodeUuid(@Param("userUuid") String userUuid, @Param("qrUuid") String qrUuid);

	public MatrixEntity findOneByUserUuidAndQrCodeUuid(String userUuidOrFingerprint, String qrCodeUuid);

	public List<MatrixEntity> findByUserUuid(String userUuid);
	
	public List<MatrixEntity> findByQrCodeUuid(String qrCodeUuid);

	public List<MatrixEntity> findByQrCodeUuidInOrUserUuid(List<String> qrcodeUuidList, String userUuid);

	public MatrixEntity findOneByMatrixUsername(String matrixUsername);

	public MatrixEntity findOneByMatrixRoomId(String matrixRoomId);

	@Query("SELECT new io.dpm.dropmenote.db.objects.QrUuidRoomCountPair(m.qrCodeUuid, count(m.id)) "
			+ "FROM MatrixEntity m "
			+ "WHERE m.empty = false AND m.qrCodeUuid IN :qrUuidList "
			+ "GROUP BY m.qrCodeUuid")
	public List<QrUuidRoomCountPair> countRoomsByQrCodeUuidIn(@Param("qrUuidList") List<String> qrUuidList);

	
	///////////////////////////////////////////////////////////
	// email notifications
	/*
	 * zatial mi tento hromadny select nevrati co chcem, tak je to rozdelene na 3 selecty
	 * */
//	@Query("SELECT u.login AS email FROM UserEntity u WHERE (u.uuid IN "
//			+ "		SELECT m.userUuid FROM MatrixEntity m WHERE m.qrCodeUuid = "
//			+ "			(SELECT m.qrCodeUuid FROM MatrixEntity m WHERE m.matrixRoomId = :matrixRoomId)) "
//			+ " UNION "
//			+ " SELECT s.shareUser.uuid AS email FROM SharedUserEntity s WHERE s.qrCode.uuid = "
//			+ "		(SELECT m.qrCodeUuid FROM MatrixEntity m WHERE m.matrixRoomId = :matrixRoomId) "
//			+ " UNION "
//			+ " SELECT q.owner.uuid AS email FROM QRCodeEntity q WHERE q.uuid = "
//			+ " 	(SELECT m.qrCodeUuid FROM MatrixEntity m WHERE m.matrixRoomId = :matrixRoomId)")
	
	@Query("SELECT u.login FROM UserEntity u WHERE u.uuid IN "
			+ "		(SELECT m.userUuid FROM MatrixEntity m WHERE "
			+ "			m.matrixRoomId = :matrixRoomId"
			+ "			AND "
			+ "			(SELECT q.active FROM QRCodeEntity q WHERE (q.uuid = m.qrCodeUuid AND q.emailNotification = true)) = true "
			+ "		) "
			+ "		AND u.emailNotification = true AND u.login <> :userEmail ")
	public List<String> getEmailsForEmailNotifications3(@Param("matrixRoomId") String matrixRoomId, @Param("userEmail") String userEmail);
	
	@Query("SELECT s.shareUser.login FROM SharedUserEntity s WHERE s.qrCode.uuid = "
			+ "		(SELECT m.qrCodeUuid FROM MatrixEntity m WHERE m.matrixRoomId = :matrixRoomId)"
			+ "			AND s.shareUser.emailNotification = true AND s.shareUser.login <> :userEmail AND s.qrCode.active = true  AND s.qrCode.emailNotification = true")
	public List<String> getEmailsForEmailNotifications1(@Param("matrixRoomId") String matrixRoomId, @Param("userEmail") String userEmail);
	
	@Query("SELECT q.owner.login FROM QRCodeEntity q WHERE q.uuid = "
			+ " 	(SELECT m.qrCodeUuid FROM MatrixEntity m WHERE m.matrixRoomId = :matrixRoomId)"
			+ "		AND q.owner.emailNotification = true AND q.owner.login <> :userEmail AND q.active = true AND q.emailNotification = true")
	public List<String> getEmailsForEmailNotifications2(@Param("matrixRoomId") String matrixRoomId, @Param("userEmail") String userEmail);
	//
	//////////////////////////////////////////////////////////////

	///////////////////////////////////////////////////////////
	// push notifications
	//
	@Query("SELECT u.login FROM UserEntity u WHERE u.uuid IN "
			+ "		(SELECT m.userUuid FROM MatrixEntity m WHERE "
			+ "			m.matrixRoomId = :matrixRoomId "
			+ "			AND "
			+ "			(SELECT q.active FROM QRCodeEntity q WHERE q.uuid = m.qrCodeUuid AND q.pushNotification = true) = true "
			+ "		) "  
			+ "		AND u.pushNotification = true AND u.login <> :userEmail ")
	public List<String> getEmailsForPushNotifications1(@Param("matrixRoomId") String matrixRoomId, @Param("userEmail") String userEmail);
	
	@Query("SELECT s.shareUser.login FROM SharedUserEntity s WHERE s.qrCode.uuid = "
			+ "		(SELECT m.qrCodeUuid FROM MatrixEntity m WHERE m.matrixRoomId = :matrixRoomId)"
			+ "			AND s.shareUser.pushNotification = true AND s.shareUser.login <> :userEmail AND s.qrCode.active = true AND s.qrCode.pushNotification = true ")
	public List<String> getEmailsForPushNotifications2(@Param("matrixRoomId") String matrixRoomId, @Param("userEmail") String userEmail);
	
	@Query("SELECT q.owner.login FROM QRCodeEntity q WHERE q.uuid = "
			+ " 	(SELECT m.qrCodeUuid FROM MatrixEntity m WHERE m.matrixRoomId = :matrixRoomId)"
			+ "		AND q.owner.pushNotification = true AND q.owner.login <> :userEmail AND q.active = true AND q.pushNotification = true ")
	public List<String> getEmailsForPushNotifications3(@Param("matrixRoomId") String matrixRoomId, @Param("userEmail") String userEmail);
	//
	/////////////////////////////////////////////////////////////////

	@Query("SELECT m.id FROM MatrixEntity m WHERE m.matrixRoomId = :matrixRoomId")
	public Long findIdByMatrixRoomId(@Param("matrixRoomId") String matrixRoomId);

	@Query("SELECT m.qrCodeUuid FROM MatrixEntity m WHERE m.matrixRoomId = :matrixRoomId")
	public String findQrCodeUuidByMatrixRoomId(@Param("matrixRoomId") String matrixRoomId);

	@Query("SELECT m.alias FROM MatrixEntity m WHERE m.matrixRoomId = :matrixRoomId")
	public String findAliasByMatrixRoomId(@Param("matrixRoomId") String matrixRoomId);

	@Query("SELECT u.alias FROM UserEntity u WHERE u.matrixUsername = :matrixName AND u.alias IS NOT NULL")
//			+ " UNION "
//			+ " SELECT m.alias FROM MatrixEntity m WHERE m.matrixUsername = :fromMatrixId AND m.alias IS NOT NULL")
	public String findUserAliasByMatrixName(@Param("matrixName") String matrixName);

	@Query("SELECT m.alias FROM MatrixEntity m WHERE m.matrixUsername = :matrixName AND m.alias IS NOT NULL")
	public String findMatrixAliasByMatrixName(@Param("matrixName") String matrixName);

	@Query("SELECT m.userUuid FROM MatrixEntity m WHERE m.matrixUsername = :matrixName")
	public String findUuidByMatrixName(@Param("matrixName") String matrixName);

	@Query("SELECT u.uuid FROM UserEntity u WHERE u.matrixUsername = :matrixName")
	public String findUserUuidByMatrixName(@Param("matrixName") String matrixName);

	@Modifying
	@Transactional
	@Query("UPDATE MatrixEntity m SET m.empty = false WHERE m.matrixRoomId = :matrixRoomId AND m.empty = true")
	public void setNotEmpty(@Param("matrixRoomId") String matrixRoomId);

	@Query("SELECT m FROM MatrixEntity m WHERE m.qrCodeUuid = :qrCodeUuid AND m.userUuid IN :uuidList")
	public MatrixEntity findOneByListOfUserUuid(@Param("qrCodeUuid")String qrCodeUuid, @Param("uuidList") List<String> sharedUserUuids);

	@Query("SELECT q.name FROM QRCodeEntity q WHERE q.uuid = (SELECT m.qrCodeUuid FROM MatrixEntity m WHERE m.matrixRoomId = :matrixRoomId)")
	public String findQrNameByMatrixRoomId(@Param("matrixRoomId") String matrixRoomId);
}
