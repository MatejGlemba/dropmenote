package io.dpm.dropmenote.ws.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.dpm.dropmenote.db.entity.DeviceEntity;
import io.dpm.dropmenote.db.repository.DeviceRepository;
import io.dpm.dropmenote.ws.bean.DeviceBean;
import io.dpm.dropmenote.ws.bean.UserBean;
import io.dpm.dropmenote.ws.dto.DeviceDto;

/**
 * 
 * @author Peter Diskanec
 *
 */
@Service
public class DeviceService {

	private static Logger LOG = LoggerFactory.getLogger(DeviceService.class);

	{
		LOG.debug("{} initialisation.", DeviceService.class.getName());
	}

	@Autowired
	private DeviceRepository deviceRepository;

	/**
	 * load list of deviceIds by emails;
	 * @param userEmails
	 */
	public List<String> loadDeviceIds(List<String> userEmails) {
		if (userEmails == null || userEmails.isEmpty()) {
			return new ArrayList<String>();
		}
		for (int i = 0; i < userEmails.size(); i++) {
			if (userEmails.get(i) == null || userEmails.get(i).equals("null") || userEmails.get(i).equals("")) {
				userEmails.remove(userEmails.get(i));
			}
		}
		if (userEmails == null || userEmails.isEmpty()) {
			return new ArrayList<String>();
		}
		return deviceRepository.findAllDeviceIdsByEmails(userEmails);
	}

	/**
	 * save deviceId for user
	 * @param userBean
	 * @param deviceId
	 */
	@Transactional
	public synchronized void save(UserBean userBean, String deviceId) {
		if (userBean != null && userBean.getId() != 0) {
			DeviceEntity deviceInDb = deviceRepository.findByDeviceIdAndUserId(deviceId, userBean.getId());
			if (deviceInDb != null) {
				return;
			}
			
			DeviceBean deviceBean = new DeviceBean();
			deviceBean.setDeviceId(deviceId);
			deviceBean.setUser(userBean);
			deviceBean.setRegistrationTime(new Date());
			DeviceEntity deviceEntity = DeviceDto.convertToEntity(deviceBean);
			if (deviceEntity != null) {
				deviceRepository.save(deviceEntity);
			}
		}
	}
	
	/**
	 * delete rows by userId, deviceId
	 * @param userBean
	 * @param deviceId
	 */
	public void delete(UserBean userBean, String deviceId) {
		deviceRepository.deleteByUserIdAndDeviceId(userBean.getId(), deviceId);
	}
}
