
package io.dpm.dropmenote.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import io.dpm.dropmenote.db.entity.BlacklistEntity;

/**
 * @author Peter Diskanec
 *
 */
public interface BlacklistRepository extends JpaRepository<BlacklistEntity, Long> {

	// @Query("SELECT u FROM User u WHERE u.status = 1")
	// public List<BlacklistEntity> findAllByOwnerId(Long ownerId);

	List<BlacklistEntity> findByOwnerId(Long userId);

	@Transactional
	void deleteByUuid(String uuid);

	public BlacklistEntity findByUuid(String uuid);
	
	Long countByUuidAndOwnerId(String uuid, long ownerId);

	@Query("SELECT b FROM BlacklistEntity b WHERE "
			+ " b.uuid = (SELECT m.userUuid FROM MatrixEntity m WHERE m.matrixRoomId = :matrixRoomId)"
			+ " AND "
			+ " b.owner.id = (SELECT q.owner.id FROM QRCodeEntity q WHERE q.uuid = "
			+ "		(SELECT ma.qrCodeUuid FROM MatrixEntity ma WHERE ma.matrixRoomId = :matrixRoomId)) ")
	BlacklistEntity findByMatrixRoomId(@Param("matrixRoomId") String matrixRoomId);
}
