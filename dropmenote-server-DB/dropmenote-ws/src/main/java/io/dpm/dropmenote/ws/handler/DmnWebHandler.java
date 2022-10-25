package io.dpm.dropmenote.ws.handler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.dpm.dropmenote.ws.bean.QRCodeListBean;
import io.dpm.dropmenote.ws.constants.AppConstant;
import io.dpm.dropmenote.ws.exception.NonValidInputException;
import io.dpm.dropmenote.ws.services.QRCodeListService;

@Service
public class DmnWebHandler extends AbstractHandler {

	private static Logger LOG = LoggerFactory.getLogger(DmnWebHandler.class);

	{
		LOG.debug("{} initialisation.", DmnWebHandler.class.getName());
	}

	@Autowired
	private QRCodeListService qrCodeListService;

	/**
	 * 
	 * @param dmnCount
	 * @param httpResposne
	 * @throws NonValidInputException
	 * @throws IOException
	 */
	public void generateDmnCodeAndCSV(int dmnCount, HttpServletResponse httpResposne) throws NonValidInputException, IOException {
		if (dmnCount <= 0 || dmnCount > 25) {
			throw new NonValidInputException("Allowed value for dmnCount is <1, 25)");
		}

		// Add to QR Code list table
		List<String> qrListBeanList = new ArrayList<>();

		// Generate qrcode into database
		for (int i = 0; i < dmnCount; i++) {
			QRCodeListBean qrListBean = new QRCodeListBean();
			// TODO random number 20 musi ist cez konstaktny a nie takto na tvrdo v kode
			String dmnRandomNumber = RandomStringUtils.random(20, true, true);
			qrListBean.setUuid(dmnRandomNumber);

			// Add to list
			qrListBeanList.add(dmnRandomNumber);

			qrCodeListService.save(qrListBean);
		}

		// Generate CSV file, into request header
		httpResposne.addHeader("content-disposition", "attachment; filename=" + "DMN_generatedCodes_" + dmnCount + ".csv");
		for (String dmnCodeIter : qrListBeanList) {
			httpResposne.getWriter().println(AppConstant.DMN_CODE_URL_PREFIX + "" + dmnCodeIter);
		}
	}
}
