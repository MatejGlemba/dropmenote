/**
 * 
 */
package io.dpm.dropmenote.ws.dto;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapperSingletonWrapper;

import io.dpm.dropmenote.db.entity.QRCodeEntity;
import io.dpm.dropmenote.ws.bean.QRCodeBean;
import io.dpm.dropmenote.ws.controller.rrbean.QRCodeBeanRequest;
import io.dpm.dropmenote.ws.controller.rrbean.QRCodeBeanResponse;
import io.dpm.dropmenote.ws.controller.rrbean.QRCodeBeanScanResponse;

/**
 * @author Martin Jurek (Starbug s.r.o. | https://www.strabug.eu)
 *
 */
public class QRCodeDto {

	/**
	 * Map value into destination object
	 * 
	 * @param destination
	 * @param source
	 * @return
	 */
	public static QRCodeBean mapInto(QRCodeBean destination, QRCodeBeanRequest source) {
		// TODO je to robre?
		if (source == null) {
			return null;
		}
		DozerBeanMapperSingletonWrapper.getInstance().map(source, destination);
		return destination;
	}
	
	/**
	 * pre scanovanie pripad
	 * @param destination
	 * @param source
	 * @return
	 */
	public static QRCodeBean mapInto(QRCodeBean destination, QRCodeBeanResponse source) {
		// TODO je to robre?
		if (source == null) {
			return null;
		}
		DozerBeanMapperSingletonWrapper.getInstance().map(source, destination);
		return destination;
	}

	/**
	 * Map value into destination object
	 * 
	 * @param destination
	 * @param source
	 * @return
	 */
	public static QRCodeBeanResponse mapInto(QRCodeBeanResponse destination, QRCodeBean source) {
		// TODO je to robre?
		if (source == null) {
			return null;
		}
		DozerBeanMapperSingletonWrapper.getInstance().map(source, destination);
		return destination;
	}

	/**
	 * Map value into destination object
	 * 
	 * @param destination
	 * @param source
	 * @return
	 */
	public static List<QRCodeBeanResponse> mapInto(List<QRCodeBeanResponse> destination, List<QRCodeBean> source) {
		// TODO je to robre?
		if (source == null) {
			return null;
		}

		for (QRCodeBean qrCodeBeanIter : source) {
			destination.add(mapInto(new QRCodeBeanResponse(), qrCodeBeanIter));
		}

		// Nepouzivat bug, vracia to source!
		// DozerBeanMapperSingletonWrapper.getInstance().map(source, destination);
		return destination;
	}

	/**
	 * 
	 * @param source
	 * @return
	 */
	public static QRCodeBean convertToBean(QRCodeEntity source) {
		if (source == null) {
			return null;
		}
		QRCodeBean configurationBean = new QRCodeBean();
		DozerBeanMapperSingletonWrapper.getInstance().map(source, configurationBean);
		return configurationBean;
	}

	/**
	 * 
	 * @param source
	 * @return
	 */
	public static List<QRCodeBean> convertToBean(List<QRCodeEntity> source) {
		List<QRCodeBean> destinationList = new ArrayList<QRCodeBean>();

		for (QRCodeEntity qrCodeEntity : source) {
			destinationList.add(convertToBean(qrCodeEntity));
		}

		return destinationList;
	}

	/**
	 * !! it doesnt support DB update. Missing ID!
	 * 
	 * @param source
	 * @return
	 */
	public static QRCodeEntity convertToEntity(QRCodeBean source) {
		if (source == null) {
			return null;
		}
		QRCodeEntity destination = new QRCodeEntity();
		DozerBeanMapperSingletonWrapper.getInstance().map(source, destination);
		return destination;
	}

	public static QRCodeBeanScanResponse mapInto(QRCodeBeanScanResponse destination, QRCodeBeanResponse source) {
		// TODO je to robre?
		if (source == null) {
			return null;
		}
		DozerBeanMapperSingletonWrapper.getInstance().map(source, destination);
		return destination;
	}

}
