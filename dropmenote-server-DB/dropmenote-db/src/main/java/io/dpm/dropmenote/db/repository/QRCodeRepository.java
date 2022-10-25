
package io.dpm.dropmenote.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import io.dpm.dropmenote.db.entity.QRCodeEntity;

/**
 * @author Peter Diskanec
 *
 */
public interface QRCodeRepository extends JpaRepository<QRCodeEntity, Long> {

	public List<QRCodeEntity> findByOwnerId(long userId);

	public QRCodeEntity findByUuid(String token);

	public List<QRCodeEntity> findByUuidIn(List<String> qrcodeUuidList);

	@Query("SELECT q FROM QRCodeEntity q WHERE q.uuid IN "
			+ " (SELECT m.qrCodeUuid FROM MatrixEntity m WHERE "
			+ " 	(m.userUuid=:userUuid OR m.qrCodeUuid IN "
			+ "			(SELECT x.uuid FROM QRCodeEntity x WHERE x.owner.uuid = :userUuid)"
			+ " 	) "
			+ " 	AND m.empty = false"
			+ ")")
	public List<QRCodeEntity> findByUserUuidFromMatrixNotEmpty(@Param("userUuid") String userUuid);
	
	@Query("SELECT q FROM QRCodeEntity q WHERE q.uuid IN "
			+ "(SELECT m.qrCodeUuid FROM MatrixEntity m WHERE m.qrCodeUuid IN "
			+ "		(SELECT s.qrCode.uuid FROM SharedUserEntity s WHERE s.shareUser.uuid = :userUuid)"
			+ "AND m.empty = false"
			+ ")")
	public List<QRCodeEntity> findBySharedUserUuidFromMatrixNotEmpty(@Param("userUuid") String userUuid);

	@Query("SELECT q.photo FROM QRCodeEntity q WHERE q.uuid = :qrCodeUuid")
	public String getPhotoByUuid(@Param("qrCodeUuid") String qrCodeUuid);

	// @Query("DELETE FROM #{#entityName} e WHERE e.id = :qrCodeId AND
	// e.sharedUsers.login = :userLogin")
	// public void deleteShareByLogin(@Param("qrCodeId") long qrCodeId,
	// @Param("userLogin") String userLogin);

//	public void deleteBySharedUsersLoginAndId(String userLogin, long qrCodeId);
	
	@Query("SELECT q.ownerAlias FROM QRCodeEntity q WHERE q.uuid = (SELECT m.qrCodeUuid FROM MatrixEntity m WHERE m.matrixRoomId = :matrixRoomId)")
	public String findAdminAliasByMatrixRoomId(@Param("matrixRoomId") String matrixRoomId);

	@Query("SELECT q.name FROM QRCodeEntity q WHERE q.uuid = :qrcodeId")
	public String getNameById(@Param("qrcodeId") String qrcodeId);

}
