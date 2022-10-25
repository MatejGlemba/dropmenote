/**
 * 
 */
package io.dpm.dropmenote.ws.utils.email;

import io.dpm.dropmenote.ws.bean.QRCodeBean;
import io.dpm.dropmenote.ws.bean.UserBean;

/**
 * @author Martin Jurek (Starbug s.r.o. | https://www.strabug.eu)
 *
 */
public class EmailMessageBuilderHelper {

	/**
	 * Link na obnovenie hesla v emaily
	 * @param serverUrl 
	 * @param serverUrl 
	 * 
	 * @param totemBean
	 * @return
	 */
	public static String buildForgotPassword(UserBean userBean, String serverUrl) {
		String username = (userBean == null || userBean.getAlias() == null) ? "Anonymous" : " " + userBean.getAlias();
		final StringBuilder emailSb = new StringBuilder();
		emailSb.append(EmailTemplate.createTopPart());
		String link = serverUrl + "/#/forgotpassword?recoveryEmailToken=" + userBean.getRecoveryToken();
		emailSb.append(EmailTemplate.createMiddlePartResetPassword(username, link, link));
		emailSb.append(EmailTemplate.createBottomPart());
		return emailSb.toString();
	}
	
	/**
	 * not used
	 * @param userBean
	 * @param serverUrl
	 * @return
	 */
	public static String buildChangePassword(UserBean userBean, String serverUrl) {
		String username = (userBean == null || userBean.getAlias() == null) ? "Anonymous" : " " + userBean.getAlias();
		final StringBuilder emailSb = new StringBuilder();
		emailSb.append(EmailTemplate.createTopPart());
		emailSb.append(EmailTemplate.createMiddlePartChangePassword(username));
		emailSb.append(EmailTemplate.createBottomPart());
		return emailSb.toString();
	}

	/**
	 * Pozdrav uzivtela cez email.
	 * 
	 * @param totemBean
	 * @return
	 */
	public static String buildLogin(UserBean userBean) {
		String username = (userBean == null || userBean.getAlias() == null) ? "Anonymous" : " " + userBean.getAlias();
		final StringBuilder emailSb = new StringBuilder();
		emailSb.append(EmailTemplate.createTopPart());
		emailSb.append(EmailTemplate.createMiddlePartLogin(username, userBean.getLogin()));
		emailSb.append(EmailTemplate.createBottomPart());
		return emailSb.toString();
	}

	/**
	 * Pozdrav uzivtela cez email.
	 * 
	 * @param totemBean
	 * @return
	 */
	public static String buildRegistration(UserBean userBean) {
		String username = (userBean == null || userBean.getAlias() == null) ? "Anonymous" : " " + userBean.getAlias();
		final StringBuilder emailSb = new StringBuilder();
		emailSb.append(EmailTemplate.createTopPart());
		emailSb.append(EmailTemplate.createMiddlePartRegistration(username, userBean.getLogin()));
		emailSb.append(EmailTemplate.createBottomPart());
		return emailSb.toString();
	}

	/**
	 * Posiela email s pozdravom a sadou vygenerovanych qrKodov
	 * 
	 * @param userBean
	 * @param qrCodeImages
	 * @return
	 */
	public static String sendQRCode(UserBean userBean, QRCodeBean qrcodeBean) {
		String username = (userBean == null || userBean.getAlias() == null) ? "Anonymous" : " " + userBean.getAlias();
		final StringBuilder emailSb = new StringBuilder();
		emailSb.append(EmailTemplate.createTopPart());
		emailSb.append(EmailTemplate.createMiddlePartSendQR(username, qrcodeBean.getName(), qrcodeBean.getDescription()));
		emailSb.append(EmailTemplate.createBottomPart());
		return emailSb.toString();
	}

	/**
	 * Posiela natifikaciu, ze niekto poslal spravu. Vytvara link na otvorenie
	 * konverzacie.
	 * 
	 * @param totemBean
	 * @return
	 */
	public static String buildNotification(String senderName, String qrName, String message) {
		final StringBuilder emailSb = new StringBuilder();
		emailSb.append(EmailTemplate.createTopPart());
		emailSb.append(EmailTemplate.createMiddlePartNotification(senderName, qrName, message));
		emailSb.append(EmailTemplate.createBottomPart());
		return emailSb.toString();
	}
}
