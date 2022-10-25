package io.dpm.dropmenote.ws.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import io.dpm.dropmenote.ws.bean.BlacklistBean;
import io.dpm.dropmenote.ws.bean.QRCodeBean;
import io.dpm.dropmenote.ws.bean.UserBean;
import io.dpm.dropmenote.ws.exception.PermissionDeniedException;

/**
 * 
 * @author Martin Jurek (Starbug s.r.o. | https://www.strabug.eu)
 *
 */
@Service
public class PermissionValidatorService {

	private static Logger LOG = LoggerFactory.getLogger(PermissionValidatorService.class);

	{
		LOG.debug("{} initialisation.", PermissionValidatorService.class.getName());
	}

	/**
	 * 
	 * @param userBean
	 * @param object
	 * @throws PermissionDeniedException
	 */
	public void validate(UserBean userBean, Object object) throws PermissionDeniedException {
		if (object instanceof QRCodeBean) {
			QRCodeBean qrCodeBean = (QRCodeBean) object;
			if (qrCodeBean.getOwner().getId() != userBean.getId()) {
				LOG.warn("User: {} doesn't have permission to modify QRCode: {}.", userBean.getId(), qrCodeBean.getId());
				throw new PermissionDeniedException("You don't have permission to modify QRCode.");
			}
		} else if (object instanceof BlacklistBean) {
			BlacklistBean blacklistBean = (BlacklistBean) object;
			if (blacklistBean.getOwner().getId() != userBean.getId()) {
				LOG.warn("User: {} doesn't have permission to modify Blacklist: {}.", userBean.getId(), blacklistBean.getId());
				throw new PermissionDeniedException("You don't have permission to modify BlackList.");
			}
		}
	}

}
