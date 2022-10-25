
package io.dpm.dropmenote.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.dpm.dropmenote.db.entity.QRCodeListEntity;

/**
 * @author Peter Diskanec
 *
 */
public interface QRCodeListRepository extends JpaRepository<QRCodeListEntity, Long> {

	public QRCodeListEntity findByUuid(String uuid);

}
