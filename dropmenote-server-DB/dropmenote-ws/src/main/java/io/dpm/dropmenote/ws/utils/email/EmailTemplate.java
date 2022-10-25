package io.dpm.dropmenote.ws.utils.email;

public class EmailTemplate {
	
	/**
	 * creates top part of email template
	 * @return
	 */
	public static String createTopPart() {
		return "<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\" xmlns:v=\"urn:schemas-microsoft-com:vml\">\r\n" + 
				"<head>\r\n" + 
				"\r\n" + 
				"<meta content=\"text/html; charset=utf-8\" http-equiv=\"Content-Type\"/>\r\n" + 
				"<meta content=\"width=device-width\" name=\"viewport\"/>\r\n" + 
				"\r\n" + 
				"<meta content=\"IE=edge\" http-equiv=\"X-UA-Compatible\"/>\r\n" + 
				"\r\n" + 
				"<title></title>\r\n" + 
				"\r\n" + 
				"<link href=\"https://fonts.googleapis.com/css?family=Montserrat\" rel=\"stylesheet\" type=\"text/css\"/>\r\n" + 
				"\r\n" + 
				"<style type=\"text/css\">\r\n" + 
				"		body {\r\n" + 
				"			margin: 0;\r\n" + 
				"			padding: 0;\r\n" + 
				"		}\r\n" + 
				"\r\n" + 
				"		table,\r\n" + 
				"		td,\r\n" + 
				"		tr {\r\n" + 
				"			vertical-align: top;\r\n" + 
				"			border-collapse: collapse;\r\n" + 
				"		}\r\n" + 
				"\r\n" + 
				"		* {\r\n" + 
				"			line-height: inherit;\r\n" + 
				"		}\r\n" + 
				"        a { text-decoration: none; }\r\n" + 
				"        /* unvisited link */\r\n" + 
				"        a:link {\r\n" + 
				"          color: white;\r\n" + 
				"        }\r\n" + 
				"\r\n" + 
				"        /* visited link */\r\n" + 
				"        a:visited {\r\n" + 
				"          color: white;\r\n" + 
				"        }\r\n" + 
				"\r\n" + 
				"        /* mouse over link */\r\n" + 
				"        a:hover {\r\n" + 
				"          color: lightgray;\r\n" + 
				"        }\r\n" + 
				"\r\n" + 
				"        /* selected link */\r\n" + 
				"        a:active {\r\n" + 
				"          color: white;\r\n" + 
				"        }\r\n" + 
				"\r\n" +
				"	</style>\r\n" + 
				"<style id=\"media-query\" type=\"text/css\">\r\n" + 
				"		@media (max-width: 620px) {\r\n" + 
				"\r\n" + 
				"			.block-grid,\r\n" + 
				"			.col {\r\n" + 
				"				min-width: 320px !important;\r\n" + 
				"				max-width: 100% !important;\r\n" + 
				"				display: block !important;\r\n" + 
				"			}\r\n" + 
				"\r\n" + 
				"			.block-grid {\r\n" + 
				"				width: 100% !important;\r\n" + 
				"			}\r\n" + 
				"\r\n" + 
				"			.col {\r\n" + 
				"				width: 100% !important;\r\n" + 
				"			}\r\n" + 
				"\r\n" + 
				"			.col>div {\r\n" + 
				"				margin: 0 auto;\r\n" + 
				"			}\r\n" + 
				"\r\n" + 
				"			img.fullwidth,\r\n" + 
				"			img.fullwidthOnMobile {\r\n" + 
				"				max-width: 100% !important;\r\n" + 
				"			}\r\n" + 
				"\r\n" + 
				"			.no-stack .col {\r\n" + 
				"				min-width: 0 !important;\r\n" + 
				"				display: table-cell !important;\r\n" + 
				"			}\r\n" + 
				"\r\n" + 
				"			.no-stack.two-up .col {\r\n" + 
				"				width: 50% !important;\r\n" + 
				"			}\r\n" + 
				"\r\n" + 
				"			.no-stack .col.num4 {\r\n" + 
				"				width: 33% !important;\r\n" + 
				"			}\r\n" + 
				"\r\n" + 
				"			.no-stack .col.num8 {\r\n" + 
				"				width: 66% !important;\r\n" + 
				"			}\r\n" + 
				"\r\n" + 
				"			.no-stack .col.num4 {\r\n" + 
				"				width: 33% !important;\r\n" + 
				"			}\r\n" + 
				"\r\n" + 
				"			.no-stack .col.num3 {\r\n" + 
				"				width: 25% !important;\r\n" + 
				"			}\r\n" + 
				"\r\n" + 
				"			.no-stack .col.num6 {\r\n" + 
				"				width: 50% !important;\r\n" + 
				"			}\r\n" + 
				"\r\n" + 
				"			.no-stack .col.num9 {\r\n" + 
				"				width: 75% !important;\r\n" + 
				"			}\r\n" + 
				"\r\n" + 
				"			.video-block {\r\n" + 
				"				max-width: none !important;\r\n" + 
				"			}\r\n" + 
				"\r\n" + 
				"			.mobile_hide {\r\n" + 
				"				min-height: 0px;\r\n" + 
				"				max-height: 0px;\r\n" + 
				"				max-width: 0px;\r\n" + 
				"				display: none;\r\n" + 
				"				overflow: hidden;\r\n" + 
				"				font-size: 0px;\r\n" + 
				"			}\r\n" + 
				"\r\n" + 
				"			.desktop_hide {\r\n" + 
				"				display: block !important;\r\n" + 
				"				max-height: none !important;\r\n" + 
				"			}\r\n" + 
				"		}\r\n" + 
				"	</style>\r\n" + 
				"</head>\r\n" + 
				"<body class=\"clean-body\" style=\"margin: 0; padding: 0; -webkit-text-size-adjust: 100%; background-color: #45a7f6;\">\r\n" + 
				"\r\n" + 
				"<table cellpadding=\"0\" cellspacing=\"0\" class=\"nl-container\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; min-width: 320px; Margin: 0 auto; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #45a7f6; width: 100%;\" valign=\"top\" width=\"100%\">\r\n" + 
				"<tbody>\r\n" + 
				"<tr style=\"vertical-align: top;\" valign=\"top\">\r\n" + 
				"<td style=\"word-break: break-word; vertical-align: top;\" valign=\"top\">\r\n" + 
				"\r\n" + 
				"<div style=\"background-color:transparent;\">\r\n" + 
				"<div class=\"block-grid\" style=\"Margin: 0 auto; min-width: 320px; max-width: 600px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: transparent;\">\r\n" + 
				"<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:transparent;\">\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"<div class=\"col num12\" style=\"min-width: 320px; max-width: 600px; display: table-cell; vertical-align: top; width: 600px;\">\r\n" + 
				"<div style=\"width:100% !important;\">\r\n" + 
				"\r\n" + 
				"<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:5px; padding-bottom:0px; padding-right: 0px; padding-left: 0px;\">\r\n" + 
				"\r\n" + 
				"<div align=\"center\" class=\"img-container center fullwidth\" style=\"padding-right: 0px;padding-left: 0px;\">\r\n" + 
				"<div style=\"font-size:1px;line-height:50px\"> </div>\r\n" + 
				"    \r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"</div>\r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"</div>\r\n" + 
				"</div>\r\n" + 
				"</div>\r\n" + 
				"<div style=\"background-color:transparent; border-radius: 10px 10px 0px 0px;\">\r\n" + 
				"<div class=\"block-grid\" style=\"Margin: 0 auto; min-width: 320px; max-width: 600px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: #FFFFFF; border-radius: 10px 10px 0px 0px;\">\r\n" + 
				"<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:#FFFFFF; border-radius: 10px 10px 0px 0px;\">\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"<div class=\"col num12\" style=\"min-width: 320px; max-width: 600px; display: table-cell; vertical-align: top; width: 600px;\">\r\n" + 
				"<div style=\"width:100% !important;\">\r\n" + 
				"\r\n" + 
				"<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:5px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;\">\r\n" + 
				"\r\n" + 
				"<div align=\"center\" class=\"img-container center\" style=\"padding-right: 0px;padding-left: 0px;\">\r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"<div style=\"color:#555555;font-family:Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;line-height:1.5;padding:30px; height: 25px;\">\r\n" + 
				"<div style=\"font-size: 12px; line-height: 1.5; color: #01a8fc; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; mso-line-height-alt: 18px;\">\r\n" + 
				"<p style=\"font-size: 28px; line-height: 1.2; text-align: center; word-break: break-word; mso-line-height-alt: 34px; margin: 0;\"><span style=\"font-size: 28px;\"><strong><span style=\"font-size: 28px;\">DropMeNote</span></strong></span></p>\r\n" + 
				"</div>\r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"</div>\r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"</div>\r\n" + 
				"</div>\r\n" + 
				"</div>";
	}
	
	/**
	 * create bottom part of email. homepage, email support, appstore, googleplay links
	 * @return
	 */
	public static String createBottomPart() {
		return "<div style=\"background-color:transparent;\">\r\n" + 
				"<div class=\"block-grid three-up\" style=\"Margin: 0 auto; min-width: 320px; max-width: 600px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: #414141;  border-radius: 0px 0px 10px 10px;\">\r\n" + 
				"<div style=\"border-collapse: collapse;display: table;width: 100%; height: 100px; background-color:#414141; border-radius: 0px 0px 10px 10px;\">\r\n" + 
				"\r\n" + 
				"<div class=\"col num4\" style=\"max-width: 320px; min-width: 200px; display: table-cell; vertical-align: top; width: 300px;\">\r\n" + 
				"<div style=\"width:100% !important;\">\r\n" + 
				"\r\n" + 
				"<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:0px; padding-bottom:0px; padding-right: 0px; padding-left: 0px;\">\r\n" + 
				"\r\n" + 
				"<div style=\"color:#555555;font-family:Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;line-height:2;padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\r\n" + 
				"<div style=\"font-size: undefined; line-height: 2; color: #555555; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; mso-line-height-alt: NaNpx; padding: 10px 0px 5px 30px;\">\r\n" + 
				"    <p style=\"font-size: 12px; line-height: 1; mso-line-height-alt: 14px; margin: 0; font-weight: bold; color: #01A8FC;\"><span style=\"text-decoration: none; font-size: 14px;\">Contact us at</span><br><a style=\"font-weight: normal; \"href=\"mailto:support@dropmenote.com\">support@dropmenote.com</a></p>\r\n" + 
				"<p style=\"font-size: 12px; line-height: 1; mso-line-height-alt: 14px; margin: 10px 0px; font-weight: bold; color: #01A8FC;\"><span style=\"text-decoration: none; font-size: 14px;\">Homepage</span><br><a style=\"font-weight: normal;\" href=\"https://www.dropmenote.com\">https://www.dropmenote.com</a></p>   \r\n" + 
				"</div>\r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"</div>\r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"<div class=\"col num4\" style=\"max-width: 320px; min-width: 200px; display: table-cell; vertical-align: top; width: 300px;\">\r\n" + 
				"<div style=\"width:100% !important;\">\r\n" + 
				"\r\n" + 
				"<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding: 0px;\">\r\n" + 
				"\r\n" + 
				"<div style=\"color:#01a8fc;font-family:Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;line-height:1.2;padding: 10px;\">\r\n" + 
				"<div style=\"font-size: 12px; line-height: 1.2; color: #01a8fc; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; mso-line-height-alt: 14px;  padding: 10px 0px 5px 30px;\">\r\n" + 
				"    <span style=\"font-weight: bold; color: #01A8FC; text-decoration: none; font-size: 14px;\">Download Mobile App</span>\r\n" + 
				"    <BR>\r\n" + 
				"    <a href='https://apps.apple.com/sk/app/appname/id917571776?l=sk' style=\"font-size: 12px; line-height: 1.2; text-align: center; word-break: break-word; mso-line-height-alt: 14px; margin: 0;\">\r\n" + 
				"        <span style=\"color: #ffffff; font-size: 12px; font-weight: normal;\">\r\n" + 
				"            AppStore\r\n" + //TODO link na app store so spravnym ID zadat
				"        </span>\r\n" + 
				"    </a>\r\n" + 
				"    <BR>\r\n" + 
				"    <a href='http://play.google.com/store/apps/details?id=io.dpm.dropmenote' style=\"font-size: 12px; line-height: 1.2; text-align: center; word-break: break-word; mso-line-height-alt: 14px; margin: 0;\">\r\n" + 
				"        <span style=\"color: #ffffff; font-size: 12px; font-weight: normal;\">\r\n" + 
				"            Google Play\r\n" + 
				"        </span>\r\n" + 
				"    </a>\r\n" + 
				"</div>\r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"</div>\r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"</div>\r\n" + 
				"</div>\r\n" + 
				"</div>\r\n" + 
				"<div style=\"background-color:transparent;\">\r\n" + 
				"<div class=\"block-grid\" style=\"Margin: 0 auto; min-width: 320px; max-width: 600px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: transparent;\">\r\n" + 
				"<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:transparent;\">\r\n" + 
				"\r\n" + 
				"<div class=\"col num12\" style=\"min-width: 320px; max-width: 600px; display: table-cell; vertical-align: top; width: 600px;\">\r\n" + 
				"<div style=\"width:100% !important;\">\r\n" + 
				"\r\n" + 
				"<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:0px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;\">\r\n" + 
				"\r\n" + 
				"<div align=\"center\" class=\"img-container center fullwidth\" style=\"padding-right: 0px;padding-left: 0px;\">\r\n" + 
				"</div>\r\n" + 
				"<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"divider\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" valign=\"top\" width=\"100%\">\r\n" + 
				"<tbody>\r\n" + 
				"<tr style=\"vertical-align: top;\" valign=\"top\">\r\n" + 
				"<td class=\"divider_inner\" style=\"word-break: break-word; vertical-align: top; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; padding-top: 30px; padding-right: 30px; padding-bottom: 30px; padding-left: 30px;\" valign=\"top\">\r\n" + 
				"<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"divider_content\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-top: 0px solid transparent; width: 100%;\" valign=\"top\" width=\"100%\">\r\n" + 
				"<tbody>\r\n" + 
				"<tr style=\"vertical-align: top;\" valign=\"top\">\r\n" + 
				"<td style=\"word-break: break-word; vertical-align: top; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" valign=\"top\"><span></span></td>\r\n" + 
				"</tr>\r\n" + 
				"</tbody>\r\n" + 
				"</table>\r\n" + 
				"</td>\r\n" + 
				"</tr>\r\n" + 
				"</tbody>\r\n" + 
				"</table>\r\n" + 
				"\r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"</div>\r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"</div>\r\n" + 
				"</div>\r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"</td>\r\n" + 
				"</tr>\r\n" + 
				"</tbody>\r\n" + 
				"</table>\r\n" + 
				"\r\n" + 
				"</body>\r\n" + 
				"</html>";
	}
	
	/**
	 * create middle content for login email. With alias and login
	 * @param alias
	 * @param login
	 * @return
	 */
	public static String createMiddlePartLogin(String alias, String login) {
		return "<div style=\"background-color:transparent;\">\r\n" + 
				"<div class=\"block-grid\" style=\"Margin: 0 auto; min-width: 320px; max-width: 600px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: #FFFFFF;\">\r\n" + 
				"<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:#FFFFFF;\">\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"<div class=\"col num12\" style=\"min-width: 320px; max-width: 600px; display: table-cell; vertical-align: top; width: 600px;\">\r\n" + 
				"<div style=\"width:100% !important;\">\r\n" + 
				"\r\n" + 
				"<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:0px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;\">\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"<div style=\"color:#0D0D0D;font-family:Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;line-height:1.2;padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\r\n" + 
				"<div style=\"font-size: 12px; line-height: 1.2; color: #0D0D0D; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; mso-line-height-alt: 14px;\">\r\n" + 
				"<p style=\"font-size: 28px; line-height: 1.2; text-align: center; word-break: break-word; mso-line-height-alt: 34px; margin: 0;\"><span style=\"font-size: 28px;\"><strong><span style=\"font-size: 24px;\">Hello " + alias + ",</span></strong></span><br/></p>\r\n" + 
				"</div>\r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"<div align=\"center\" class=\"img-container center\" style=\"padding-top: 20px;\">\r\n" + 
				"<svg height=\"15\" width=\"100%\">\r\n" + 
				"<line x1=\"10%\" y1=\"0\" x2=\"90%\" y2=\"0\" style=\"stroke:rgb(55,55,55);stroke-width:2\" />\r\n" + 
				"</svg>\r\n" + 
				"<!--<img align=\"center\" alt=\"Image\" border=\"0\" class=\"center\" src=\"images/divider.png\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; border: 0; height: auto; width: 100%; max-width: 316px; display: block;\" title=\"Image\" width=\"316\"/>-->\r\n" + 
				"\r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"<div style=\"color:#555555;font-family:Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;line-height:1.5;padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\r\n" + 
				"<div style=\"font-size: 12px; line-height: 1.5; color: #555555; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; mso-line-height-alt: 18px;\">\r\n" + 
				"<p style=\"font-size: 14px; line-height: 1.5; text-align: center; word-break: break-word; mso-line-height-alt: 21px; margin: 0;\">You have logged in to DropMeNote application<span style=\"color: #01a8fc; font-size: 14px;\"><strong><br/></strong></span></p>\r\n" + 
				"</div>\r\n" + 
				"</div>\r\n" + 
				"    \r\n" + 
				"<div style=\"color:#555555;font-family:Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;line-height:1.5;padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\r\n" + 
				"<div style=\"font-size: 12px; line-height: 1.5; color: #555555; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; mso-line-height-alt: 18px;\">\r\n" + 
				"<p style=\"font-size: 14px; line-height: 1.5; text-align: center; word-break: break-word; mso-line-height-alt: 21px; margin: 0;\">Your login is: <span style=\"color: #01a8fc\">" + login + "</span><span style=\"color: #01a8fc; font-size: 14px;\"><strong><br/></strong></span></p>\r\n" + 
				"</div>\r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"<div style=\"color:#0D0D0D;font-family:Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;line-height:1.5;padding: 20px 50px 10px 50px;\">\r\n" + 
				"<div style=\"font-size: 12px; line-height: 1.5; color: #0D0D0D; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; mso-line-height-alt: 18px;\">\r\n" + 
				"<p style=\"font-size: 14px; line-height: 1.5; text-align: center; word-break: break-word; mso-line-height-alt: 21px; margin: 0;\">This email is for information purpose. You can ignore it. </p>\r\n" + 
				"</div>\r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"divider\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" valign=\"top\" width=\"100%\">\r\n" + 
				"<tbody>\r\n" + 
				"<tr style=\"vertical-align: top;\" valign=\"top\">\r\n" + 
				"<td class=\"divider_inner\" style=\"word-break: break-word; vertical-align: top; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; padding-top: 30px; padding-right: 10px; padding-bottom: 10px; padding-left: 10px;\" valign=\"top\">\r\n" + 
				"<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"divider_content\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-top: 0px solid transparent; width: 100%;\" valign=\"top\" width=\"100%\">\r\n" + 
				"<tbody>\r\n" + 
				"<tr style=\"vertical-align: top;\" valign=\"top\">\r\n" + 
				"<td style=\"word-break: break-word; vertical-align: top; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" valign=\"top\"><span></span></td>\r\n" + 
				"</tr>\r\n" + 
				"</tbody>\r\n" + 
				"</table>\r\n" + 
				"</td>\r\n" + 
				"</tr>\r\n" + 
				"</tbody>\r\n" + 
				"</table>\r\n" + 
				"\r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"</div>\r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"</div>\r\n" + 
				"</div>\r\n" + 
				"</div>";
	}

	public static String createMiddlePartRegistration(String alias, String login) {
		return "<div style=\"background-color:transparent;\">\r\n" + 
				"<div class=\"block-grid\" style=\"Margin: 0 auto; min-width: 320px; max-width: 600px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: #FFFFFF;\">\r\n" + 
				"<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:#FFFFFF;\">\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"<div class=\"col num12\" style=\"min-width: 320px; max-width: 600px; display: table-cell; vertical-align: top; width: 600px;\">\r\n" + 
				"<div style=\"width:100% !important;\">\r\n" + 
				"\r\n" + 
				"<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:0px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;\">\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"<div style=\"color:#0D0D0D;font-family:Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;line-height:1.2;padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\r\n" + 
				"<div style=\"font-size: 12px; line-height: 1.2; color: #0D0D0D; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; mso-line-height-alt: 14px;\">\r\n" + 
				"<p style=\"font-size: 28px; line-height: 1.2; text-align: center; word-break: break-word; mso-line-height-alt: 34px; margin: 0;\"><span style=\"font-size: 28px;\"><strong><span style=\"font-size: 24px;\">Hello " + alias + ",</span></strong></span><br/><span style=\"font-size: 24px;\">Registration completed</span></p>\r\n" + 
				"</div>\r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"<div align=\"center\" class=\"img-container center\" style=\"padding-top: 20px;\">\r\n" + 
				"<svg height=\"15\" width=\"100%\">\r\n" + 
				"<line x1=\"10%\" y1=\"0\" x2=\"90%\" y2=\"0\" style=\"stroke:rgb(55,55,55);stroke-width:2\" />\r\n" + 
				"</svg>\r\n" + 
				"<!--<img align=\"center\" alt=\"Image\" border=\"0\" class=\"center\" src=\"images/divider.png\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; border: 0; height: auto; width: 100%; max-width: 316px; display: block;\" title=\"Image\" width=\"316\"/>-->\r\n" + 
				"\r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"<div style=\"color:#555555;font-family:Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;line-height:1.5;padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\r\n" + 
				"<div style=\"font-size: 12px; line-height: 1.5; color: #555555; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; mso-line-height-alt: 18px;\">\r\n" + 
				"<p style=\"font-size: 14px; line-height: 1.5; text-align: center; word-break: break-word; mso-line-height-alt: 21px; margin: 0;\">Thanks for joining our DropMeNote Community!<span style=\"color: #01a8fc; font-size: 14px;\"><strong><br/></strong></span></p>\r\n" + 
				"</div>\r\n" + 
				"</div>\r\n" + 
				"    \r\n" + 
				"<div style=\"color:#555555;font-family:Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;line-height:1.5;padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\r\n" + 
				"<div style=\"font-size: 12px; line-height: 1.5; color: #555555; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; mso-line-height-alt: 18px;\">\r\n" + 
				"<p style=\"font-size: 14px; line-height: 1.5; text-align: center; word-break: break-word; mso-line-height-alt: 21px; margin: 0;\">Your login is: <span style=\"color: #01a8fc !important;\">" + login + "</span><span style=\"color: #01a8fc; font-size: 14px;\"><strong><br/></strong></span></p>\r\n" + 
				"</div>\r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"<div style=\"color:#0D0D0D;font-family:Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;line-height:1.5;padding: 20px 50px 10px 50px;\">\r\n" + 
				"<div style=\"font-size: 12px; line-height: 1.5; color: #0D0D0D; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; mso-line-height-alt: 18px;\">\r\n" + 
				"<p style=\"font-size: 14px; line-height: 1.5; text-align: center; word-break: break-word; mso-line-height-alt: 21px; margin: 0;\">DropMeNote is a unique way to connect and facilitate communication <br/>between individuals and companies using DMN Codes. </p>\r\n" + 
				"</div>\r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"divider\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" valign=\"top\" width=\"100%\">\r\n" + 
				"<tbody>\r\n" + 
				"<tr style=\"vertical-align: top;\" valign=\"top\">\r\n" + 
				"<td class=\"divider_inner\" style=\"word-break: break-word; vertical-align: top; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; padding-top: 30px; padding-right: 10px; padding-bottom: 10px; padding-left: 10px;\" valign=\"top\">\r\n" + 
				"<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"divider_content\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-top: 0px solid transparent; width: 100%;\" valign=\"top\" width=\"100%\">\r\n" + 
				"<tbody>\r\n" + 
				"<tr style=\"vertical-align: top;\" valign=\"top\">\r\n" + 
				"<td style=\"word-break: break-word; vertical-align: top; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" valign=\"top\"><span></span></td>\r\n" + 
				"</tr>\r\n" + 
				"</tbody>\r\n" + 
				"</table>\r\n" + 
				"</td>\r\n" + 
				"</tr>\r\n" + 
				"</tbody>\r\n" + 
				"</table>\r\n" + 
				"\r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"</div>\r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"</div>\r\n" + 
				"</div>\r\n" + 
				"</div>";
	}

	public static Object createMiddlePartChangePassword(String alias) {
		return "<div style=\"background-color:transparent;\">\r\n" + 
				"<div class=\"block-grid\" style=\"Margin: 0 auto; min-width: 320px; max-width: 600px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: #FFFFFF;\">\r\n" + 
				"<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:#FFFFFF;\">\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"<div class=\"col num12\" style=\"min-width: 320px; max-width: 600px; display: table-cell; vertical-align: top; width: 600px;\">\r\n" + 
				"<div style=\"width:100% !important;\">\r\n" + 
				"\r\n" + 
				"<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:0px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;\">\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"<div style=\"color:#0D0D0D;font-family:Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;line-height:1.2;padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\r\n" + 
				"<div style=\"font-size: 12px; line-height: 1.2; color: #0D0D0D; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; mso-line-height-alt: 14px;\">\r\n" + 
				"<p style=\"font-size: 28px; line-height: 1.2; text-align: center; word-break: break-word; mso-line-height-alt: 34px; margin: 0;\"><span style=\"font-size: 28px;\"><strong><span style=\"font-size: 24px;\">Hello " + alias + ",</span></strong></span><br/></p>\r\n" + 
				"</div>\r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"<div align=\"center\" class=\"img-container center\" style=\"padding-top: 20px;\">\r\n" + 
				"<svg height=\"15\" width=\"100%\">\r\n" + 
				"<line x1=\"10%\" y1=\"0\" x2=\"90%\" y2=\"0\" style=\"stroke:rgb(55,55,55);stroke-width:2\" />\r\n" + 
				"</svg>\r\n" + 
				"<!--<img align=\"center\" alt=\"Image\" border=\"0\" class=\"center\" src=\"images/divider.png\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; border: 0; height: auto; width: 100%; max-width: 316px; display: block;\" title=\"Image\" width=\"316\"/>-->\r\n" + 
				"\r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"<div style=\"color:#555555;font-family:Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;line-height:1.5;padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\r\n" + 
				"<div style=\"font-size: 12px; line-height: 1.5; color: #555555; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; mso-line-height-alt: 18px;\">\r\n" + 
				"<p style=\"font-size: 14px; line-height: 1.5; text-align: center; word-break: break-word; mso-line-height-alt: 21px; margin: 0;\">Your DropMeNote password has been successfully changed.<span style=\"color: #01a8fc; font-size: 14px;\"><strong><br/></strong></span></p>\r\n" + 
				"</div>\r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"<div style=\"color:#0D0D0D;font-family:Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;line-height:1.5;padding: 20px 50px 10px 50px;\">\r\n" + 
				"<div style=\"font-size: 12px; line-height: 1.5; color: #0D0D0D; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; mso-line-height-alt: 18px;\">\r\n" + 
				"<p style=\"font-size: 14px; line-height: 1.5; text-align: center; word-break: break-word; mso-line-height-alt: 21px; margin: 0;\">You can now sign in with your new password.</p>\r\n" + 
				"</div>\r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"divider\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" valign=\"top\" width=\"100%\">\r\n" + 
				"<tbody>\r\n" + 
				"<tr style=\"vertical-align: top;\" valign=\"top\">\r\n" + 
				"<td class=\"divider_inner\" style=\"word-break: break-word; vertical-align: top; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; padding-top: 30px; padding-right: 10px; padding-bottom: 10px; padding-left: 10px;\" valign=\"top\">\r\n" + 
				"<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"divider_content\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-top: 0px solid transparent; width: 100%;\" valign=\"top\" width=\"100%\">\r\n" + 
				"<tbody>\r\n" + 
				"<tr style=\"vertical-align: top;\" valign=\"top\">\r\n" + 
				"<td style=\"word-break: break-word; vertical-align: top; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" valign=\"top\"><span></span></td>\r\n" + 
				"</tr>\r\n" + 
				"</tbody>\r\n" + 
				"</table>\r\n" + 
				"</td>\r\n" + 
				"</tr>\r\n" + 
				"</tbody>\r\n" + 
				"</table>\r\n" + 
				"\r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"</div>\r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"</div>\r\n" + 
				"</div>\r\n" + 
				"</div>";
	}
	
	public static String createMiddlePartResetPassword(String alias, String link, String url) {
		return "<div style=\"background-color:transparent;\">\r\n" + 
				"<div class=\"block-grid\" style=\"Margin: 0 auto; min-width: 320px; max-width: 600px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: #FFFFFF;\">\r\n" + 
				"<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:#FFFFFF;\">\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"<div class=\"col num12\" style=\"min-width: 320px; max-width: 600px; display: table-cell; vertical-align: top; width: 600px;\">\r\n" + 
				"<div style=\"width:100% !important;\">\r\n" + 
				"\r\n" + 
				"<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:0px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;\">\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"<div style=\"color:#0D0D0D;font-family:Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;line-height:1.2;padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\r\n" + 
				"<div style=\"font-size: 12px; line-height: 1.2; color: #0D0D0D; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; mso-line-height-alt: 14px;\">\r\n" + 
				"<p style=\"font-size: 28px; line-height: 1.2; text-align: center; word-break: break-word; mso-line-height-alt: 34px; margin: 0;\"><span style=\"font-size: 28px;\"><strong><span style=\"font-size: 24px;\">Hello " + alias + ",</span></strong></span><br/></p>\r\n" + 
				"</div>\r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"<div align=\"center\" class=\"img-container center\" style=\"padding-top: 20px;\">\r\n" + 
				"<svg height=\"15\" width=\"100%\">\r\n" + 
				"<line x1=\"10%\" y1=\"0\" x2=\"90%\" y2=\"0\" style=\"stroke:rgb(55,55,55);stroke-width:2\" />\r\n" + 
				"</svg>\r\n" + 
				"<!--<img align=\"center\" alt=\"Image\" border=\"0\" class=\"center\" src=\"images/divider.png\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; border: 0; height: auto; width: 100%; max-width: 316px; display: block;\" title=\"Image\" width=\"316\"/>-->\r\n" + 
				"\r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"<div style=\"color:#555555;font-family:Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;line-height:1.5;padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\r\n" + 
				"<div style=\"font-size: 12px; line-height: 1.5; color: #555555; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; mso-line-height-alt: 18px;\">\r\n" + 
				"<p style=\"font-size: 14px; line-height: 1.5; text-align: center; word-break: break-word; mso-line-height-alt: 21px; margin: 0;\">Your DropMeNote password can be reset by clicking the link below. <br>In case you did not request a new password, please ignore this email.<span style=\"color: #01a8fc; font-size: 14px;\"><strong><br/></strong></span></p>\r\n" + 
				"</div>\r\n" + 
				"</div>\r\n" + 
				"    \r\n" + 
				"<div style=\"color:#555555;font-family:Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;line-height:1.5;padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\r\n" + 
				"<div style=\"font-size: 12px; line-height: 1.5; color: #555555; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; mso-line-height-alt: 18px;\">\r\n" + 
				"<p style=\"font-size: 14px; line-height: 1.5; text-align: center; word-break: break-word; mso-line-height-alt: 21px; margin: 0;\">Reset Password: <a style=\"color: #01a8fc;\" href=\"" + link + "\">link to reset password</a><span style=\"color: #01a8fc; font-size: 14px;\"><strong><br/></strong></span></p>\r\n" + 
				"</div>\r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"<div style=\"color:#0D0D0D;font-family:Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;line-height:1.5;padding: 20px 50px 10px 50px;\">\r\n" + 
				"<div style=\"font-size: 12px; line-height: 1.5; color: #0D0D0D; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; mso-line-height-alt: 18px;\">\r\n" + 
				"<p style=\"font-size: 14px; line-height: 1.5; text-align: center; word-break: break-word; mso-line-height-alt: 21px; margin: 0;\">If mentioned link doesn't work, copy and paste this address to your browser:\r\n" + 
				"<br><span style=\"color:#01a8fc;\">" + url + "</span></p>\r\n" + 
				"</div>\r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"divider\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" valign=\"top\" width=\"100%\">\r\n" + 
				"<tbody>\r\n" + 
				"<tr style=\"vertical-align: top;\" valign=\"top\">\r\n" + 
				"<td class=\"divider_inner\" style=\"word-break: break-word; vertical-align: top; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; padding-top: 30px; padding-right: 10px; padding-bottom: 10px; padding-left: 10px;\" valign=\"top\">\r\n" + 
				"<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"divider_content\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-top: 0px solid transparent; width: 100%;\" valign=\"top\" width=\"100%\">\r\n" + 
				"<tbody>\r\n" + 
				"<tr style=\"vertical-align: top;\" valign=\"top\">\r\n" + 
				"<td style=\"word-break: break-word; vertical-align: top; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" valign=\"top\"><span></span></td>\r\n" + 
				"</tr>\r\n" + 
				"</tbody>\r\n" + 
				"</table>\r\n" + 
				"</td>\r\n" + 
				"</tr>\r\n" + 
				"</tbody>\r\n" + 
				"</table>\r\n" + 
				"\r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"</div>\r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"</div>\r\n" + 
				"</div>\r\n" + 
				"</div>";
	}

	public static String createMiddlePartNotification(String senderName, String qrName, String message) {
		return "<div style=\"background-color:transparent;\">\r\n" + 
				"<div class=\"block-grid\" style=\"Margin: 0 auto; min-width: 320px; max-width: 600px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: #FFFFFF;\">\r\n" + 
				"<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:#FFFFFF;\">\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"<div class=\"col num12\" style=\"min-width: 320px; max-width: 600px; display: table-cell; vertical-align: top; width: 600px;\">\r\n" + 
				"<div style=\"width:100% !important;\">\r\n" + 
				"\r\n" + 
				"<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:0px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;\">\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"<div style=\"color:#0D0D0D;font-family:Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;line-height:1.2;padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\r\n" + 
				"<div style=\"font-size: 12px; line-height: 1.2; color: #0D0D0D; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; mso-line-height-alt: 14px;\">\r\n" + 
				"<p style=\"font-size: 28px; line-height: 1.2; text-align: center; word-break: break-word; mso-line-height-alt: 34px; margin: 0;\"><span style=\"font-size: 28px;\"><strong><span style=\"font-size: 24px;\">Hello</span></strong></span><br/></p>\r\n" + 
				"</div>\r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"<div align=\"center\" class=\"img-container center\" style=\"padding-top: 20px;\">\r\n" + 
				"<svg height=\"15\" width=\"100%\">\r\n" + 
				"<line x1=\"10%\" y1=\"0\" x2=\"90%\" y2=\"0\" style=\"stroke:rgb(55,55,55);stroke-width:2\" />\r\n" + 
				"</svg>\r\n" + 
				"<!--<img align=\"center\" alt=\"Image\" border=\"0\" class=\"center\" src=\"images/divider.png\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; border: 0; height: auto; width: 100%; max-width: 316px; display: block;\" title=\"Image\" width=\"316\"/>-->\r\n" + 
				"\r\n" + 
				"</div>\r\n" + 
				"    \r\n" + 
				"<div style=\"color:#555555;font-family:Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;line-height:1.5;padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\r\n" + 
				"<div style=\"font-size: 12px; line-height: 1.5; color: #555555; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; mso-line-height-alt: 18px;\">\r\n" + 
				"<p style=\"font-size: 14px; line-height: 1.5; text-align: center; word-break: break-word; mso-line-height-alt: 21px; margin: 0;\">You have received a new message for DMN code: <span style=\"color: #01a8fc\">" + qrName + "</span><span style=\"color: #01a8fc; font-size: 14px;\"><strong><br/></strong></span></p>\r\n" + 
				"</div>\r\n" + 
				"</div>\r\n" + 
				"    \r\n" + 
				"<div style=\"color:#555555;font-family:Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;line-height:1.5;padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\r\n" + 
				"<div style=\"font-size: 12px; line-height: 1.5; color: #555555; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; mso-line-height-alt: 18px;\">\r\n" + 
				"<p style=\"font-size: 14px; line-height: 1.5; text-align: center; word-break: break-word; mso-line-height-alt: 21px; margin: 0;\">" + message + "<span style=\"color: #01a8fc; font-size: 14px;\"><strong><br/></strong></span></p>\r\n" + 
				"</div>\r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"<div style=\"color:#0D0D0D;font-family:Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;line-height:1.5;padding: 20px 50px 10px 50px;\">\r\n" + 
				"<div style=\"font-size: 12px; line-height: 1.5; color: #0D0D0D; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; mso-line-height-alt: 18px;\">\r\n" + 
				"<p style=\"font-size: 14px; line-height: 1.5; text-align: center; word-break: break-word; mso-line-height-alt: 21px; margin: 0;\">Sign in to DropMeNote to reply and start talking.</p>\r\n" + 
				"</div>\r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"divider\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" valign=\"top\" width=\"100%\">\r\n" + 
				"<tbody>\r\n" + 
				"<tr style=\"vertical-align: top;\" valign=\"top\">\r\n" + 
				"<td class=\"divider_inner\" style=\"word-break: break-word; vertical-align: top; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; padding-top: 30px; padding-right: 10px; padding-bottom: 10px; padding-left: 10px;\" valign=\"top\">\r\n" + 
				"<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"divider_content\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-top: 0px solid transparent; width: 100%;\" valign=\"top\" width=\"100%\">\r\n" + 
				"<tbody>\r\n" + 
				"<tr style=\"vertical-align: top;\" valign=\"top\">\r\n" + 
				"<td style=\"word-break: break-word; vertical-align: top; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" valign=\"top\"><span></span></td>\r\n" + 
				"</tr>\r\n" + 
				"</tbody>\r\n" + 
				"</table>\r\n" + 
				"</td>\r\n" + 
				"</tr>\r\n" + 
				"</tbody>\r\n" + 
				"</table>\r\n" + 
				"\r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"</div>\r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"</div>\r\n" + 
				"</div>\r\n" + 
				"</div>";
	}

	public static String createMiddlePartSendQR(String alias, String qrName, String qrDescription) {
		return "<div style=\"background-color:transparent;\">\r\n" + 
				"<div class=\"block-grid\" style=\"Margin: 0 auto; min-width: 320px; max-width: 600px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: #FFFFFF;\">\r\n" + 
				"<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:#FFFFFF;\">\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"<div class=\"col num12\" style=\"min-width: 320px; max-width: 600px; display: table-cell; vertical-align: top; width: 600px;\">\r\n" + 
				"<div style=\"width:100% !important;\">\r\n" + 
				"\r\n" + 
				"<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:0px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;\">\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"<div style=\"color:#0D0D0D;font-family:Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;line-height:1.2;padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\r\n" + 
				"<div style=\"font-size: 12px; line-height: 1.2; color: #0D0D0D; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; mso-line-height-alt: 14px;\">\r\n" + 
				"<p style=\"font-size: 28px; line-height: 1.2; text-align: center; word-break: break-word; mso-line-height-alt: 34px; margin: 0;\"><span style=\"font-size: 28px;\"><strong><span style=\"font-size: 24px;\">Hello " + alias + ",</span><br><span style=\"font-size: 24px;\">DMN code created</span></strong></span><br/></p>\r\n" + 
				"</div>\r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"<div align=\"center\" class=\"img-container center\" style=\"padding-top: 20px;\">\r\n" + 
				"<svg height=\"15\" width=\"100%\">\r\n" + 
				"<line x1=\"10%\" y1=\"0\" x2=\"90%\" y2=\"0\" style=\"stroke:rgb(55,55,55);stroke-width:2\" />\r\n" + 
				"</svg>\r\n" + 
				"<!--<img align=\"center\" alt=\"Image\" border=\"0\" class=\"center\" src=\"images/divider.png\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; border: 0; height: auto; width: 100%; max-width: 316px; display: block;\" title=\"Image\" width=\"316\"/>-->\r\n" + 
				"\r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"<div style=\"color:#0D0D0D;font-family:Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;line-height:1.5;padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\r\n" + 
				"<div style=\"font-size: 12px; line-height: 1.5; color: #0D0D0D; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; mso-line-height-alt: 18px;\">\r\n" + 
				"<div style=\"font-size: 14px; line-height: 1.5; text-align: center; word-break: break-word; mso-line-height-alt: 21px; margin: 0;\">You've created a DMN code via DropMeNote application. <br>We've sent you your generated DMN code in attachment. <br>It is the same code but in different visual variants and sizes :)<span style=\"color: #01a8fc; font-size: 14px;\"><strong><br/></strong></span></div>\r\n" + 
				"</div>\r\n" + 
				"</div>\r\n" + 
				"    \r\n" + 
				"<div style=\"color:#0D0D0D;font-family:Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;line-height:1.5;padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\r\n" + 
				"<div style=\"font-size: 12px; line-height: 1.5; color: #0D0D0D; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; mso-line-height-alt: 18px;\">\r\n" + 
				"<p style=\"font-size: 14px; line-height: 1.5; text-align: center; word-break: break-word; mso-line-height-alt: 21px; margin: 0;\">DMN code name: <br><span style=\"color: #01a8fc\">" + qrName + "</span><span style=\"color: #01a8fc; font-size: 14px;\"><strong><br/></strong></span></p>\r\n" + 
				"<p style=\"font-size: 14px; line-height: 1.5; text-align: center; word-break: break-word; mso-line-height-alt: 21px; margin: 0;\">DMN code description: <br><span style=\"color: #01a8fc\">" + qrDescription + "</span><span style=\"color: #01a8fc; font-size: 14px;\"><br><br><span style=\"color: black; font-weight: bold;\">YOUR DMN CODE IS NOW READY</span><strong><br/></strong></span></p>\r\n" + 
				"</div>\r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"<div style=\"color:#0D0D0D;font-family:Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;line-height:1.5;padding: 20px 50px 10px 50px;\">\r\n" + 
				"<div style=\"font-size: 12px; line-height: 1.5; color: #0D0D0D; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; mso-line-height-alt: 18px;\">\r\n" + 
				"<p style=\"font-size: 14px; line-height: 1.5; text-align: center; word-break: break-word; mso-line-height-alt: 21px; margin: 0;\">You can print the DMN code, then cut it out and stick it where you want to be in contact with others. After scanning the DMN code, people will receive information about your DMN code, or they can chat with you. "
				+ "<br><br>Read more about creating labels at: <br><a style=\"color:#01a8fc;\" href=\"https://www.dropmenote.com/labels/\">https://www.dropmenote.com/labels/</a></p>\r\n" + 
				"</div>\r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"divider\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" valign=\"top\" width=\"100%\">\r\n" + 
				"<tbody>\r\n" + 
				"<tr style=\"vertical-align: top;\" valign=\"top\">\r\n" + 
				"<td class=\"divider_inner\" style=\"word-break: break-word; vertical-align: top; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; padding-top: 30px; padding-right: 10px; padding-bottom: 10px; padding-left: 10px;\" valign=\"top\">\r\n" + 
				"<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"divider_content\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-top: 0px solid transparent; width: 100%;\" valign=\"top\" width=\"100%\">\r\n" + 
				"<tbody>\r\n" + 
				"<tr style=\"vertical-align: top;\" valign=\"top\">\r\n" + 
				"<td style=\"word-break: break-word; vertical-align: top; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" valign=\"top\"><span></span></td>\r\n" + 
				"</tr>\r\n" + 
				"</tbody>\r\n" + 
				"</table>\r\n" + 
				"</td>\r\n" + 
				"</tr>\r\n" + 
				"</tbody>\r\n" + 
				"</table>\r\n" + 
				"\r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"</div>\r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"</div>\r\n" + 
				"</div>\r\n" + 
				"</div>";
	}
}
