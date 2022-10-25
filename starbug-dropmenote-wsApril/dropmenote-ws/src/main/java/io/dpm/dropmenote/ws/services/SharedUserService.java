package io.dpm.dropmenote.ws.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.dpm.dropmenote.db.entity.SharedUserEntity;
import io.dpm.dropmenote.db.repository.SharedUserRepository;
import io.dpm.dropmenote.ws.bean.QRCodeBean;
import io.dpm.dropmenote.ws.bean.UserBean;
import io.dpm.dropmenote.ws.enums.UserTypeEnum;

@Service
public class SharedUserService {

	private static Logger LOG = LoggerFactory.getLogger(UserService.class);

	{
		LOG.debug("{} initialisation.", UserService.class.getName());
	}
	
	@Autowired
	private SharedUserRepository sharedUserRepository;
	
	/**
	 * get shared user type or guest user type
	 * @param qrcode
	 * @param user
	 * @return
	 */
	public UserTypeEnum getSharedOrGuestUserType(QRCodeBean qrcode, UserBean user) {
		if (qrcode == null) {
			return UserTypeEnum.GUEST;
		}
		SharedUserEntity sharedEntity = sharedUserRepository.findByQrCodeIdAndShareUserId(qrcode.getId(), user.getId());
		if (sharedEntity != null) {
			return UserTypeEnum.SHARED;
		} else {
			return UserTypeEnum.GUEST;
		}
	}
}
