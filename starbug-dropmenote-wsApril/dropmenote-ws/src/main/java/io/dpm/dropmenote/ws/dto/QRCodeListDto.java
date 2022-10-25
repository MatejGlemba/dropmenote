/**
 * 
 */
package io.dpm.dropmenote.ws.dto;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapperSingletonWrapper;

import io.dpm.dropmenote.db.entity.QRCodeEntity;
import io.dpm.dropmenote.db.entity.QRCodeListEntity;
import io.dpm.dropmenote.ws.bean.QRCodeBean;
import io.dpm.dropmenote.ws.bean.QRCodeListBean;

/**
 * @author Martin Jurek (Starbug s.r.o. | https://www.strabug.eu)
 *
 */
public class QRCodeListDto {

	/**
	 * 
	 * @param source
	 * @return
	 */
	public static QRCodeListBean convertToBean(QRCodeListEntity source) {
		if (source == null) {
			return null;
		}
		QRCodeListBean bean = new QRCodeListBean();
		DozerBeanMapperSingletonWrapper.getInstance().map(source, bean);
		return bean;
	}

	/**
	 * 
	 * @param source
	 * @return
	 */
	public static List<QRCodeListBean> convertToBean(List<QRCodeListEntity> source) {
		if (source == null) {
			return null;
		}
		List<QRCodeListBean> destinationList = new ArrayList<QRCodeListBean>();
		for (QRCodeListEntity entity : source) {
			destinationList.add(convertToBean(entity));
		}
		return destinationList;
	}

	/**
	 * 
	 * @param source
	 * @return
	 */
	public static QRCodeListEntity convertToEntity(QRCodeListBean source) {
		if (source == null) {
			return null;
		}
		QRCodeListEntity destination = new QRCodeListEntity();
		DozerBeanMapperSingletonWrapper.getInstance().map(source, destination);
		return destination;
	}

	/**
	 * 
	 * @param source
	 * @return
	 */
	public static List<QRCodeListEntity> convertToEntity(List<QRCodeListBean> source) {
		if (source == null) {
			return null;
		}
		List<QRCodeListEntity> destinationList = new ArrayList<QRCodeListEntity>();
		for (QRCodeListBean bean : source) {
			destinationList.add(convertToEntity(bean));
		}
		return destinationList;
	}

	/**
	 * 
	 * @param qrCodeBean
	 * @return
	 */
	public static QRCodeListBean mapInto(QRCodeBean qrCodeBean) {
		QRCodeListBean bean = new QRCodeListBean();
		DozerBeanMapperSingletonWrapper.getInstance().map(qrCodeBean, bean);
		return bean;
	}

	/**
	 * 
	 * @param qrCodeEntity
	 * @return
	 */
	public static QRCodeListBean mapInto(QRCodeEntity qrCodeEntity) {
		QRCodeListBean bean = new QRCodeListBean();
		DozerBeanMapperSingletonWrapper.getInstance().map(qrCodeEntity, bean);
		return bean;
	}
}
