package io.dpm.dropmenote.ws.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import io.dpm.dropmenote.db.entity.QRCodeListEntity;
import io.dpm.dropmenote.db.repository.QRCodeListRepository;
import io.dpm.dropmenote.ws.bean.QRCodeListBean;
import io.dpm.dropmenote.ws.dto.QRCodeListDto;
import io.dpm.dropmenote.ws.services.helpers.CSVHelper;

@Service
public class QRCodeListService {

	private static Logger LOG = LoggerFactory.getLogger(QRCodeListService.class);

	{
		LOG.debug("{} initialisation.", QRCodeListService.class.getName());
	}
	
	@Autowired
	private QRCodeListRepository qrCodeListRepository;

	/**
	 * 
	 * @param qrCodeListBean
	 * @return
	 */
	public void save(QRCodeListBean qrCodeListBean) {
		QRCodeListEntity entity = QRCodeListDto.convertToEntity(qrCodeListBean);
		if (entity != null) {
			qrCodeListRepository.save(entity);
		}
	}
	
	/**
	 * return list of QRcodes read from CSV file
	 * @param filepath
	 * @return
	 */
	public List<QRCodeListBean> importFromCSV(MultipartFile file) {
		List<QRCodeListEntity> qrListFromDB = qrCodeListRepository.findAll();		
		List<QRCodeListEntity> qrList = QRCodeListDto.convertToEntity(CSVHelper.readCSVFile(file));
		
		// check if imported qrcode are equal with DB qrcode
		List<QRCodeListEntity> qrListToSave = qrListFromDB;
		for (QRCodeListEntity ent : qrList) {
			boolean isEqual = false;
			for (QRCodeListEntity entFromDB : qrListFromDB) {
				if (entFromDB.getUuid().equals(ent.getUuid())) {
					isEqual = true;
					break;
				}
			}
			if (!isEqual) {
				ent.setId(0);
				qrListToSave.add(ent);
			}
		}

		return QRCodeListDto.convertToBean(qrCodeListRepository.save(qrListToSave)); 
	}

	/**
	 * 
	 * @param uuid
	 * @return
	 */
	public QRCodeListBean loadByUuid(String uuid) {
		return QRCodeListDto.convertToBean(qrCodeListRepository.findByUuid(uuid));
	}

	/**
	 * 
	 * @return
	 */
	public List<QRCodeListBean> loadAll() {
		return QRCodeListDto.convertToBean(qrCodeListRepository.findAll());
	}
}
