package io.dpm.dropmenote.ws.services;

import static io.dpm.dropmenote.ws.constants.ConfigurationConstant.QRCODE_BG_HEIGHT_LARGE;
import static io.dpm.dropmenote.ws.constants.ConfigurationConstant.QRCODE_BG_HEIGHT_MEDIUM;
import static io.dpm.dropmenote.ws.constants.ConfigurationConstant.QRCODE_BG_HEIGHT_SMALL;
import static io.dpm.dropmenote.ws.constants.ConfigurationConstant.QRCODE_BG_WIDTH_LARGE;
import static io.dpm.dropmenote.ws.constants.ConfigurationConstant.QRCODE_BG_WIDTH_MEDIUM;
import static io.dpm.dropmenote.ws.constants.ConfigurationConstant.QRCODE_BG_WIDTH_SMALL;
import static io.dpm.dropmenote.ws.constants.ConfigurationConstant.QRCODE_HEIGHT_LARGE;
import static io.dpm.dropmenote.ws.constants.ConfigurationConstant.QRCODE_HEIGHT_MEDIUM;
import static io.dpm.dropmenote.ws.constants.ConfigurationConstant.QRCODE_HEIGHT_SMALL;
import static io.dpm.dropmenote.ws.constants.ConfigurationConstant.QRCODE_POS_X_LARGE;
import static io.dpm.dropmenote.ws.constants.ConfigurationConstant.QRCODE_POS_X_MEDIUM;
import static io.dpm.dropmenote.ws.constants.ConfigurationConstant.QRCODE_POS_X_SMALL;
import static io.dpm.dropmenote.ws.constants.ConfigurationConstant.QRCODE_POS_Y_LARGE;
import static io.dpm.dropmenote.ws.constants.ConfigurationConstant.QRCODE_POS_Y_MEDIUM;
import static io.dpm.dropmenote.ws.constants.ConfigurationConstant.QRCODE_POS_Y_SMALL;
import static io.dpm.dropmenote.ws.constants.ConfigurationConstant.QRCODE_WIDTH_LARGE;
import static io.dpm.dropmenote.ws.constants.ConfigurationConstant.QRCODE_WIDTH_MEDIUM;
import static io.dpm.dropmenote.ws.constants.ConfigurationConstant.QRCODE_WIDTH_SMALL;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.dpm.dropmenote.ws.bean.QRCodeBean;
import io.dpm.dropmenote.ws.bean.UserBean;
import io.dpm.dropmenote.ws.exception.EmailException;
import io.dpm.dropmenote.ws.utils.email.EmailData;
import io.dpm.dropmenote.ws.utils.email.EmailData.Attachement;
import io.dpm.dropmenote.ws.utils.email.EmailMessageBuilderHelper;
import io.dpm.dropmenote.ws.utils.email.EmailUtil;

/**
 * 
 * @author Martin Jurek (Starbug s.r.o. | https://www.strabug.eu)
 *
 */
@Service
public class EmailService {

	private static Logger LOG = LoggerFactory.getLogger(EmailService.class);

	{
		LOG.debug("{} initialisation.", EmailService.class.getName());
	}

	@Autowired
	private EmailUtil emailUtil;

	@Autowired
	private QRCodeService qrCodeService;

	@Value("${web.app.url}")
	private String webAppUrl;

	/**
	 * 
	 * @param userBean
	 * @throws EmailException
	 */
	public void sendForgotPassword(UserBean userBean) throws EmailException {
		// Create email object
		EmailData emailData = new EmailData();
		emailData.setSendTo(userBean.getLogin());
//		emailData.setBcc("saktafil@gmail.com");

		emailData.setBody(EmailMessageBuilderHelper.buildForgotPassword(userBean, webAppUrl));
		emailData.setSubject("Password reset instructions for DropMeNote");

		emailUtil.sendEmail(emailData);
	}

	/**
	 * 
	 * @param userBean
	 * @throws EmailException
	 */
	public void sendRegistration(UserBean userBean) throws EmailException {
		// Create email object
		EmailData emailData = new EmailData();
		emailData.setSendTo(userBean.getLogin());
//		emailData.setBcc("saktafil@gmail.com");

		emailData.setBody(EmailMessageBuilderHelper.buildRegistration(userBean));
		emailData.setSubject("Welcome to DropMeNote");

		emailUtil.sendEmail(emailData);
	}

	/**
	 * 
	 * @param userBean
	 * @param qrCodebean
	 * @throws EmailException
	 */
	public void sendQRCode(UserBean userBean, QRCodeBean qrCodebean) throws EmailException {
		// byte[] qrCodeImageSmall = qrCodeService.generate(qrCodebean,
		// ConfigurationConstant.QRCODE_WIDTH_SMALL,
		// ConfigurationConstant.QRCODE_HEIGHT_SMALL);
		// byte[] qrCodeImageMedium = qrCodeService.generate(qrCodebean,
		// ConfigurationConstant.QRCODE_WIDTH_MEDIUM,
		// ConfigurationConstant.QRCODE_HEIGHT_MEDIUM);
		byte[] qrCodeImageLarge = qrCodeService.generate(qrCodebean, QRCODE_BG_WIDTH_LARGE, QRCODE_BG_WIDTH_LARGE);

		// Create email object
		EmailData emailData = new EmailData();
		emailData.setSendTo(userBean.getLogin());
//		emailData.setBcc(null);
//		emailData.setBcc("saktafil@gmail.com");
		emailData.setBody(EmailMessageBuilderHelper.sendQRCode(userBean, qrCodebean));
		emailData.setSubject("DropMeNote generated DMN Code - " + qrCodebean.getName());

		// Generate DropMeNote QRCode
		try {
			emailData.getAttachements().add(new Attachement(qrCodebean.getName() + "_lightblue_small.png", generateDPNQRCode(QRCodeGeneratorSizeEnum.SMALL, QRCodeGeneratorColorEnum.LIGHTBLUE, qrCodeImageLarge)));
			emailData.getAttachements().add(new Attachement(qrCodebean.getName() + "_lightblue_normal.png", generateDPNQRCode(QRCodeGeneratorSizeEnum.NORMAL, QRCodeGeneratorColorEnum.LIGHTBLUE, qrCodeImageLarge)));
			emailData.getAttachements().add(new Attachement(qrCodebean.getName() + "_lightblue_large.png", generateDPNQRCode(QRCodeGeneratorSizeEnum.LARGE, QRCodeGeneratorColorEnum.LIGHTBLUE, qrCodeImageLarge)));
			
			emailData.getAttachements().add(new Attachement(qrCodebean.getName() + "_blue_small.png", generateDPNQRCode(QRCodeGeneratorSizeEnum.SMALL, QRCodeGeneratorColorEnum.BLUE, qrCodeImageLarge)));
			emailData.getAttachements().add(new Attachement(qrCodebean.getName() + "_blue_normal.png", generateDPNQRCode(QRCodeGeneratorSizeEnum.NORMAL, QRCodeGeneratorColorEnum.BLUE, qrCodeImageLarge)));
			emailData.getAttachements().add(new Attachement(qrCodebean.getName() + "_blue_large.png", generateDPNQRCode(QRCodeGeneratorSizeEnum.LARGE, QRCodeGeneratorColorEnum.BLUE, qrCodeImageLarge)));

			emailData.getAttachements().add(new Attachement(qrCodebean.getName() + "_red_small.png", generateDPNQRCode(QRCodeGeneratorSizeEnum.SMALL, QRCodeGeneratorColorEnum.RED, qrCodeImageLarge)));
			emailData.getAttachements().add(new Attachement(qrCodebean.getName() + "_red_normal.png", generateDPNQRCode(QRCodeGeneratorSizeEnum.NORMAL, QRCodeGeneratorColorEnum.RED, qrCodeImageLarge)));
			emailData.getAttachements().add(new Attachement(qrCodebean.getName() + "_red_large.png", generateDPNQRCode(QRCodeGeneratorSizeEnum.LARGE, QRCodeGeneratorColorEnum.RED, qrCodeImageLarge)));

			emailData.getAttachements().add(new Attachement(qrCodebean.getName() + "_yellow_small.png", generateDPNQRCode(QRCodeGeneratorSizeEnum.SMALL, QRCodeGeneratorColorEnum.YELLOW, qrCodeImageLarge)));
			emailData.getAttachements().add(new Attachement(qrCodebean.getName() + "_yellow_normal.png", generateDPNQRCode(QRCodeGeneratorSizeEnum.NORMAL, QRCodeGeneratorColorEnum.YELLOW, qrCodeImageLarge)));
			emailData.getAttachements().add(new Attachement(qrCodebean.getName() + "_yellow_large.png", generateDPNQRCode(QRCodeGeneratorSizeEnum.LARGE, QRCodeGeneratorColorEnum.YELLOW, qrCodeImageLarge)));

			emailData.getAttachements().add(new Attachement(qrCodebean.getName() + "_green_small.png", generateDPNQRCode(QRCodeGeneratorSizeEnum.SMALL, QRCodeGeneratorColorEnum.GREEN, qrCodeImageLarge)));
			emailData.getAttachements().add(new Attachement(qrCodebean.getName() + "_green_normal.png", generateDPNQRCode(QRCodeGeneratorSizeEnum.NORMAL, QRCodeGeneratorColorEnum.GREEN, qrCodeImageLarge)));
			emailData.getAttachements().add(new Attachement(qrCodebean.getName() + "_green_large.png", generateDPNQRCode(QRCodeGeneratorSizeEnum.LARGE, QRCodeGeneratorColorEnum.GREEN, qrCodeImageLarge)));
			
			emailData.getAttachements().add(new Attachement(qrCodebean.getName() + "_black_small.png", generateDPNQRCode(QRCodeGeneratorSizeEnum.SMALL, QRCodeGeneratorColorEnum.BLACK, qrCodeImageLarge)));
			emailData.getAttachements().add(new Attachement(qrCodebean.getName() + "_black_normal.png", generateDPNQRCode(QRCodeGeneratorSizeEnum.NORMAL, QRCodeGeneratorColorEnum.BLACK, qrCodeImageLarge)));
			emailData.getAttachements().add(new Attachement(qrCodebean.getName() + "_black_large.png", generateDPNQRCode(QRCodeGeneratorSizeEnum.LARGE, QRCodeGeneratorColorEnum.BLACK, qrCodeImageLarge)));
			
			emailData.getAttachements().add(new Attachement(qrCodebean.getName() + "_gray_small.png", generateDPNQRCode(QRCodeGeneratorSizeEnum.SMALL, QRCodeGeneratorColorEnum.GRAY, qrCodeImageLarge)));
			emailData.getAttachements().add(new Attachement(qrCodebean.getName() + "_gray_normal.png", generateDPNQRCode(QRCodeGeneratorSizeEnum.NORMAL, QRCodeGeneratorColorEnum.GRAY, qrCodeImageLarge)));
			emailData.getAttachements().add(new Attachement(qrCodebean.getName() + "_gray_large.png", generateDPNQRCode(QRCodeGeneratorSizeEnum.LARGE, QRCodeGeneratorColorEnum.GRAY, qrCodeImageLarge)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Clean QR code. No tempalte
		EmailData.Attachement attachementQRCodeLarge = new Attachement(qrCodebean.getName() + "_pureQRcode.png", qrCodeImageLarge);
		emailData.getAttachements().add(attachementQRCodeLarge);

		emailUtil.sendEmail(emailData);
	}

	/**
	 * 
	 * @param emails
	 * @param senderName
	 * @param qrName
	 * @param message
	 * @throws EmailException
	 */
	public void sendNotification(List<String> emails, String senderName, String qrName, String message) throws EmailException {
		// Create email object
		if (emails == null || emails.isEmpty()) {
			return;
		}
		EmailData emailData = new EmailData();
		String commaSeparatedEmails = new String();
		for (String email : emails) {
			commaSeparatedEmails += email + ",";
		}
		commaSeparatedEmails = commaSeparatedEmails.substring(0, commaSeparatedEmails.length() - 1);
		emailData.setSendTo(commaSeparatedEmails);
//		emailData.setBcc("saktafil@gmail.com");		
		emailData.setBody(EmailMessageBuilderHelper.buildNotification(senderName, qrName, message));
		emailData.setSubject("New DropMeNote message is waiting");

		emailUtil.sendEmail(emailData);
	}

	// public static void main(String[] args) throws URISyntaxException {
	// try {
	// EmailService.generateDPNQRCode(QRCodeGeneratorSizeEnum.SMALL,
	// QRCodeGeneratorColorEnum.PINK, null);
	// } catch (IOException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }

	public enum QRCodeGeneratorSizeEnum {
		SMALL, NORMAL, LARGE
	};

	public enum QRCodeGeneratorColorEnum {
		YELLOW, BLUE, RED, GREEN, BLACK, GRAY, LIGHTBLUE
	};

	/**
	 * 
	 * @param qRCodeGeneratorSizeEnum
	 * @param qRCodeGeneratorColorEnum
	 * @param qrCode
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public byte[] generateDPNQRCode(QRCodeGeneratorSizeEnum qRCodeGeneratorSizeEnum, QRCodeGeneratorColorEnum qRCodeGeneratorColorEnum, byte[] qrCode) throws IOException, URISyntaxException {
		// load source images
		BufferedImage dpnBackground = ImageIO.read(loadURLTempalteBackground(qRCodeGeneratorColorEnum, qRCodeGeneratorSizeEnum)); 
		LOG.debug(loadURLTempalteBackground(qRCodeGeneratorColorEnum, qRCodeGeneratorSizeEnum).toString());
		LOG.debug("dpnBackground:" + dpnBackground);

		ByteArrayInputStream bais = new ByteArrayInputStream(qrCode);
		BufferedImage qrCodeImage = ImageIO.read(bais);

		// create the new image, canvas size is the max. of both image sizes
		BufferedImage combined;
		switch (qRCodeGeneratorSizeEnum) {
		case SMALL: combined = new BufferedImage(QRCODE_BG_WIDTH_SMALL, QRCODE_BG_HEIGHT_SMALL, BufferedImage.TYPE_INT_RGB); break;
		case LARGE: combined = new BufferedImage(QRCODE_BG_WIDTH_LARGE, QRCODE_BG_HEIGHT_LARGE, BufferedImage.TYPE_INT_RGB); break;
		case NORMAL: 
		default: combined = new BufferedImage(QRCODE_BG_WIDTH_MEDIUM, QRCODE_BG_HEIGHT_MEDIUM, BufferedImage.TYPE_INT_RGB); break;
		}	

		// paint both images, preserving the alpha channels
		Graphics g = combined.getGraphics();
		// BCG color white
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 4000, 4000);

		switch (qRCodeGeneratorSizeEnum) {
		case SMALL:
			g.drawImage(qrCodeImage, QRCODE_POS_X_SMALL, QRCODE_POS_Y_SMALL, QRCODE_WIDTH_SMALL, QRCODE_HEIGHT_SMALL, null); 
			g.drawImage(dpnBackground, 0, 0, QRCODE_BG_WIDTH_SMALL, QRCODE_BG_HEIGHT_SMALL, null);
			break;
		case LARGE: 
			g.drawImage(qrCodeImage, QRCODE_POS_X_LARGE, QRCODE_POS_Y_LARGE, QRCODE_WIDTH_LARGE, QRCODE_HEIGHT_LARGE, null); 
			g.drawImage(dpnBackground, 0, 0, QRCODE_BG_WIDTH_LARGE, QRCODE_BG_HEIGHT_LARGE, null);
			break;
		case NORMAL:
		default: 
			g.drawImage(qrCodeImage, QRCODE_POS_X_MEDIUM, QRCODE_POS_Y_MEDIUM, QRCODE_WIDTH_MEDIUM, QRCODE_HEIGHT_MEDIUM, null); 
			g.drawImage(dpnBackground, 0, 0, QRCODE_BG_WIDTH_MEDIUM, QRCODE_BG_HEIGHT_MEDIUM, null);
			break;
		}

		// // Save as new image
//		File exportedFile = new File("DropMeNote.jpg");
//		// exportedFile.createNewFile();
//		ImageIO.write(combined, "jpg", exportedFile);

		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ImageIO.write(combined, "png", bos);
		return bos.toByteArray();
	}

	/**
	 * 
	 * @param qRCodeGeneratorColorEnum
	 * @param qRCodeGeneratorSizeEnum 
	 * @return
	 * @throws URISyntaxException
	 * @throws IOException
	 */
	public URL loadURLTempalteBackground(QRCodeGeneratorColorEnum qRCodeGeneratorColorEnum, QRCodeGeneratorSizeEnum qRCodeGeneratorSizeEnum) throws URISyntaxException, IOException {
		String pathToFile = null;

		switch (qRCodeGeneratorColorEnum) {
		case LIGHTBLUE:
			switch (qRCodeGeneratorSizeEnum) {
			case SMALL: pathToFile = "/img/dpnQRCodeTemplate/dpn_qrcodetemplate_lightblue_small.png"; break;
			case NORMAL: pathToFile = "/img/dpnQRCodeTemplate/dpn_qrcodetemplate_lightblue_normal.png"; break;
			case LARGE: pathToFile = "/img/dpnQRCodeTemplate/dpn_qrcodetemplate_lightblue_large.png"; break;
			default: pathToFile = "/img/dpnQRCodeTemplate/dpn_qrcodetemplate_lightblue_large.png"; break;
			}
			break;
		case BLUE:
			switch (qRCodeGeneratorSizeEnum) {
			case SMALL: pathToFile = "/img/dpnQRCodeTemplate/dpn_qrcodetemplate_blue_small.png"; break;
			case NORMAL: pathToFile = "/img/dpnQRCodeTemplate/dpn_qrcodetemplate_blue_normal.png"; break;
			case LARGE: pathToFile = "/img/dpnQRCodeTemplate/dpn_qrcodetemplate_blue_large.png"; break;
			default: pathToFile = "/img/dpnQRCodeTemplate/dpn_qrcodetemplate_blue_large.png"; break;
			}
			break;
		case GREEN:
			switch (qRCodeGeneratorSizeEnum) {
			case SMALL: pathToFile = "/img/dpnQRCodeTemplate/dpn_qrcodetemplate_green_small.png"; break;
			case NORMAL: pathToFile = "/img/dpnQRCodeTemplate/dpn_qrcodetemplate_green_normal.png"; break;
			case LARGE: pathToFile = "/img/dpnQRCodeTemplate/dpn_qrcodetemplate_green_large.png"; break;
			default: pathToFile = "/img/dpnQRCodeTemplate/dpn_qrcodetemplate_green_large.png"; break;
			}
			break;
		case YELLOW:
			switch (qRCodeGeneratorSizeEnum) {
			case SMALL: pathToFile = "/img/dpnQRCodeTemplate/dpn_qrcodetemplate_yellow_small.png"; break;
			case NORMAL: pathToFile = "/img/dpnQRCodeTemplate/dpn_qrcodetemplate_yellow_normal.png"; break;
			case LARGE: pathToFile = "/img/dpnQRCodeTemplate/dpn_qrcodetemplate_yellow_large.png"; break;
			default: pathToFile = "/img/dpnQRCodeTemplate/dpn_qrcodetemplate_yellow_large.png"; break;
			}
			break;
		case RED:
			switch (qRCodeGeneratorSizeEnum) {
			case SMALL: pathToFile = "/img/dpnQRCodeTemplate/dpn_qrcodetemplate_red_small.png"; break;
			case NORMAL: pathToFile = "/img/dpnQRCodeTemplate/dpn_qrcodetemplate_red_normal.png"; break;
			case LARGE: pathToFile = "/img/dpnQRCodeTemplate/dpn_qrcodetemplate_red_large.png"; break;
			default: pathToFile = "/img/dpnQRCodeTemplate/dpn_qrcodetemplate_red_large.png"; break;
			}
			break;
		case BLACK:
			switch (qRCodeGeneratorSizeEnum) {
			case SMALL: pathToFile = "/img/dpnQRCodeTemplate/dpn_qrcodetemplate_black_small.png"; break;
			case NORMAL: pathToFile = "/img/dpnQRCodeTemplate/dpn_qrcodetemplate_black_normal.png"; break;
			case LARGE: pathToFile = "/img/dpnQRCodeTemplate/dpn_qrcodetemplate_black_large.png"; break;
			default: pathToFile = "/img/dpnQRCodeTemplate/dpn_qrcodetemplate_black_large.png"; break;
			}
			break;
		case GRAY:
			switch (qRCodeGeneratorSizeEnum) {
			case SMALL: pathToFile = "/img/dpnQRCodeTemplate/dpn_qrcodetemplate_gray_small.png"; break;
			case NORMAL: pathToFile = "/img/dpnQRCodeTemplate/dpn_qrcodetemplate_gray_normal.png"; break;
			case LARGE: pathToFile = "/img/dpnQRCodeTemplate/dpn_qrcodetemplate_gray_large.png"; break;
			default: pathToFile = "/img/dpnQRCodeTemplate/dpn_qrcodetemplate_gray_large.png"; break;
			}
			break;
		}
		
		// TODO preco nejde SVG?
		
		return getClass().getClassLoader().getResource(pathToFile);
		
	}

}
