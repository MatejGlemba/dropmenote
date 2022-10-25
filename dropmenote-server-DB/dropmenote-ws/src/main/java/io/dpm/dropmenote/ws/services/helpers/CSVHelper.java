package io.dpm.dropmenote.ws.services.helpers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import io.dpm.dropmenote.ws.bean.QRCodeListBean;

public class CSVHelper {

	/**
	 * 
	 * @param file
	 * @return
	 */
    public static List<QRCodeListBean> readCSVFile(MultipartFile file) {
    	List<QRCodeListBean> qrList = new ArrayList<>();
        String line = "";
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
        	while ((line = br.readLine()) != null) {

                QRCodeListBean qrcode = new QRCodeListBean();
                qrcode.setId(0);
                qrcode.setUuid(line.trim());
                qrcode.setCreated(new Date());
                qrcode.setUpdated(new Date());
                qrList.add(qrcode);
            }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        return qrList;
    }
}
