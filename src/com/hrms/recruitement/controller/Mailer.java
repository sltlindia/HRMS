package com.hrms.recruitement.controller;

import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.PasswordAuthentication;

public class Mailer {
	public static void send(String to, String subject, String msg, String msg1, String position, String desc1,
			String desc2, String desc3, String desc4, String desc5, String desc6) {

		String from = "hrms@sltl.com";
		String pass = "hrms#123";
		// Recipient's email ID needs to be mentioned.
		String host = "smtp.gmail.com";

		// 1st step) Get the session object
		Properties props = new Properties();
		// props.put("mail.smtp.starttls.enable", "true");
		
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");

		props.put("mail.smtp.socketFactory.port", "587");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.class", "javax.net.SocketFactory");
		props.put("mail.smtp.ssl.enable", "false");
		props.put("mail.smtp.ssl.trust", host);
		
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, pass);
			}
		});
		// 2nd step)compose message
		String body = "Sahajanand Laser Technology Ltd.";
		String body1 = "E-30, Electronics Estate, G.I.D.C., Sector-26,";
		String body2 = "GANDHINAGAR - 382028, Gujarat, INDIA.";
		String body3 = "Contact:(O): 079-2328 7461-68 Fax No.: 079-2328 7470.";
		String body4 = "www.sahajanandlaser.com";

		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));// From Address
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));// To
																					// Address
			message.setSubject(subject);// MSG Subject
			// This mail has 2 part, the BODY and the embedded image
			MimeMultipart multipart = new MimeMultipart("related");

			// first part (the html)
			BodyPart messageBodyPart = new MimeBodyPart();
			BodyPart messageBodyPart1 = new MimeBodyPart();

			/**/

			String htmlText = "<html>";

			htmlText += "<head>";
			htmlText += "<link href=\"https://fonts.googleapis.com/icon?family=Material+Icons\"\r\n rel=\"stylesheet\">";
			htmlText += "</head>";

			htmlText += "<body>";
			htmlText += "<br>";
			htmlText += "<table cellpadding=\"0\" cellspacing=\"15\" border=\"0\" bgcolor=\"#f0f4f5\" width=\"100%\"	style=\"margin: 0 auto; max-width: 550px; font-family: arial\">";
			htmlText += "<tbody>";
			htmlText += "<tr bgcolor=\"#ffffff\">";
			htmlText += "<td>";
			htmlText += "<table cellpadding=\"15\" cellspacing=\"0\" border=\"0\" width=\"100%\">";
			htmlText += "<tbody>";
			htmlText += "<tr>";
			htmlText += "<td valign=\"middle\"><a href=\"http://www.sahajanandlaser.com\"><img src=\"http://www.sltl.com/images/sltllogo.png\" alt=\"sltllogo\" width=\"106\" style=\"vertical-align: middle\" class=\"CToWUd\"></a></td>";
			htmlText += "<td align=\"right\"><img src=\"https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcQjJkNWrO_pXGhZoAvyStzhRr70iS-ZdCO7JUoQivdyMWqbV0HtLQ\"\r\n"
					+ "								height=\"40px\" width=\"40px\"\r\n"
					+ "								class=\"CToWUd\"></td>";
			htmlText += "</tr>";
			htmlText += "</tbody>";
			htmlText += "</table>";
			htmlText += "</td>";
			htmlText += "</tr>";
			htmlText += "<tr bgcolor=\"#ffffff\">";
			htmlText += "<td>";
			htmlText += "<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\">";
			htmlText += "<tbody>";
			htmlText += "<tr>";
			htmlText += "<td><div class=\"a6S\" dir=\"ltr\" style=\"opacity: 0.01; left: 521.5px; top: 236px;\"> <div id=\":13q\" class=\"T-I J-J5-Ji aQv T-I-ax7 L3 a5q\""
					+ "role=\"button\" tabindex=\"0\" aria-label=\"Download attachment \" data-tooltip-class=\"a1V\" data-tooltip=\"Download\"> <div class=\"aSK J-J5-Ji aYr\"></div>"
					+ "</div> </div></td>";
			htmlText += "</tr>";
			htmlText += "<tr>";
			htmlText += "<td>";
			htmlText += "<table cellpadding=\"15\" cellspacing=\"0\" border=\"0\" width=\"100%\">";
			htmlText += "<tbody>";
			htmlText += "<tr>";
			htmlText += "<td> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 13px; color: #121212; line-height: 18px; padding-bottom: 10px\">"
					+ "" + msg + ",</p> "
					+ "<p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 13px; color: #121212; line-height: 18px\">"
					+ " &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; " + msg1
					+ "</p>";
			htmlText += "</tr>";
			htmlText += "</tbody>";
			htmlText += "</table>";
			htmlText += "</td>";
			htmlText += "</tr>";
			htmlText += "</tbody>";
			htmlText += "</table>";
			htmlText += "</td>";
			htmlText += "</tr>";
			htmlText += "<tr bgcolor=\"#ffffff\">";
			htmlText += "<td>";
			htmlText += "<table cellpadding=\"0\" cellspacing=\"15\" border=\"0\" width=\"100%\">";
			htmlText += "<tbody>";

			htmlText += " <tr><td><b>&nbsp;Interview Details </b><hr>" + "</td> </tr>";

			htmlText += "<tr>";
			htmlText += "<td>";
			htmlText += "<table cellpadding=\"10\" cellspacing=\"0\" border=\"0\" width=\"100%\" style=\"border: solid #f4f4f4 1px\">";
			htmlText += "<tbody>";
			htmlText += "<tr>";
			htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">"
					+ " <strong>Position applied for </strong> </p> </td>";
			htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 14px; color: #121212; line-height: 13px\">"
					+ position + "</p></td>";
			htmlText += "</tr>";
			htmlText += "<tr>";
			htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n"
					+ "<strong>Date </strong> </p> </td>";
			htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n"
					+ "" + desc1 + "</p> </td>";
			htmlText += "</tr>";
			htmlText += "<tr>";
			htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n"
					+ " <strong>Interview Time</strong> </p> </td>";
			htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n"
					+ " " + desc2 + "</p> </td>";
			htmlText += "</tr>";
			htmlText += "<tr>";
			htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n"
					+ " <strong>Interview Location</strong> </p> </td>";
			htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n"
					+ " " + desc3 + "</p> </td>";
			htmlText += "</tr>";
			htmlText += "</tbody>";
			htmlText += "</table>";
			htmlText += "</td>";
			htmlText += "</tr>";
			htmlText += "</tbody>";
			htmlText += "</table>";
			htmlText += "</td>";
			htmlText += "</tr>";

			htmlText += "<tr bgcolor=\"#ffffff\">";
			htmlText += "<td>";
			htmlText += "<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\">";
			htmlText += "<tbody>";
			htmlText += "<tr>";
			htmlText += "<td>";
			htmlText += "<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"100%\">";
			htmlText += "<tbody>";
			htmlText += "<tr bgcolor=\"#ffffff\">";
			htmlText += "<td>";
			htmlText += "<table cellpadding=\"15\" cellspacing=\"0\" border=\"0\">";
			htmlText += "<tbody>";
			htmlText += "<tr>";
			htmlText += "<td>";
			htmlText += "<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"100%\">";
			htmlText += "<tbody>";
			htmlText += "<tr>";
			htmlText += "<td><p style=\"margin: 0; padding-left: 10px; font-family: arial; font-size: 13px; color: #121212; line-height: 20px; padding-bottom: 0px\"> "
					+ desc4 + "</p>"
					+ "<p style=\"margin: 0; padding-left: 10px; font-family: arial; font-size: 13px; color: #121212; line-height: 20px; padding-bottom: 0px\">"
					+ desc5 + "</p>"
					+ "<p style=\"margin: 0; padding-left: 10px; font-family: arial; font-size: 13px; color: #121212; line-height: 20px; padding-bottom: 10px\">"
					+ desc6 + " </p></td>";
			htmlText += "</tr>";
			htmlText += "<tr>";
			htmlText += "<td>";
			htmlText += "<p style=\"margin: 0; padding-left: 10px; font-family: arial; font-size: 13px; color: #121212; line-height: 20px\"> Regards,<br> HR Team. </p>";
			htmlText += "</td>";
			htmlText += "</tr>";
			htmlText += "</tbody>";
			htmlText += "</table>";
			htmlText += "</td>";
			htmlText += "</tr>";
			htmlText += "</tbody>";
			htmlText += "</table>";
			htmlText += "</td>";
			htmlText += "</tr>";
			htmlText += "</tbody>";
			htmlText += "</table>";
			htmlText += "</td>";
			htmlText += "</tr>";
			htmlText += "</tbody>";
			htmlText += "</table>";
			htmlText += "</td>";
			htmlText += "</tr>";
			htmlText += "</tbody>";
			htmlText += "</table>";
			htmlText += "</body>";
			htmlText += "</html>";

			messageBodyPart.setContent(htmlText, "text/html");
			// add it
			multipart.addBodyPart(messageBodyPart);

			// second part (the image)
			messageBodyPart = new MimeBodyPart();
			DataSource fds = new FileDataSource("D:/workspace/HRMS/WebContent/img/sltllogo.png");

			messageBodyPart.setDataHandler(new DataHandler(fds));
			messageBodyPart.setHeader("Content-ID", "<image>");

			// add image to the multipart
			multipart.addBodyPart(messageBodyPart);

			message.setContent(multipart);

			// 3rd step)send message
			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}

	public static void send1(String subject, String desc, String desc1, List<String> email) { // Recruitment

		// Sender's email ID needs to be mentioned
		String from = "hrms@sltl.com";
		String pass = "hrms#123";
		// Recipient's email ID needs to be mentioned.
		String host = "smtp.gmail.com";

		// 1st step) Get the session object
		Properties props = new Properties();
		// props.put("mail.smtp.starttls.enable", "true");

		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");

		props.put("mail.smtp.socketFactory.port", "587");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.class", "javax.net.SocketFactory");
		props.put("mail.smtp.ssl.enable", "false");
		props.put("mail.smtp.ssl.trust", host);

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, pass);
			}
		});
		// 2nd step)compose message
		String body = "Sahajanand Laser Technology Ltd.";
		String body1 = "E-30, Electronics Estate, G.I.D.C., Sector-26,";
		String body2 = "GANDHINAGAR - 382028, Gujarat, INDIA.";
		String body3 = "Contact:( O): 079-2328 7461-68 Fax No.: 079-2328 7470.";
		String body4 = "www.sahajanandlaser.com";

		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));// From Address

			for (String cc : email) {
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(cc));
			}
			message.setSubject(subject);// MSG Subject
			// This mail has 2 part, the BODY and the embedded image
			MimeMultipart multipart = new MimeMultipart("related");

			// first part (the html)
			BodyPart messageBodyPart = new MimeBodyPart();
			BodyPart messageBodyPart1 = new MimeBodyPart();

			/**/

			String htmlText = "<html>";

			htmlText += "<head>";
			htmlText += "<link href=\"bower_components/bootstrap/dist/css/bootstrap.min.css\" rel=\"stylesheet\">";
			htmlText += "<link href=\"bower_components/bootstrap/dist/css/bootstrap.css\" rel=\"stylesheet\">";
			htmlText += "</head>";

			htmlText += "<body>";
			htmlText += "<br>";
			htmlText += "<fieldset>";
			htmlText += "<legend><h4>Recruitment Management</h4></legend>";
			htmlText += "<table class=\"table table-striped table-bordered table-hover\">";

			htmlText += "<tbody>";
			htmlText += "<tr>";
			htmlText += "<th>" + desc + "</th>";
			htmlText += "<th>" + desc1 + "</th>";
			htmlText += "</tr>";
			htmlText += "</tbody>";

			htmlText += "</table>";
			htmlText += "</fieldset>";

			htmlText += "</body>";
			htmlText += "</html>";

			/* String htmlText = type+"<br>"+query+"<br>"+code; */
			htmlText += "<br><br><br>";
			htmlText += "<img src=\"cid:image\"><br><b>" + body + "</b><br><b>" + body1 + "</b><br><b>" + body2
					+ "</b><br><b>" + body3 + "</b><br><b>" + body4 + "</b>";
			messageBodyPart.setContent(htmlText, "text/html");
			// add it
			multipart.addBodyPart(messageBodyPart);

			// second part (the image)
			messageBodyPart = new MimeBodyPart();
			DataSource fds = new FileDataSource("d:/hrms/upload/img/sltllogo.png");

			messageBodyPart.setDataHandler(new DataHandler(fds));
			messageBodyPart.setHeader("Content-ID", "<image>");

			// add image to the multipart
			multipart.addBodyPart(messageBodyPart);

			message.setContent(multipart);

			// 3rd step)send message
			Transport.send(message);

			System.out.println("Done Akash");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		
		
	}
	
	
	public static void send12 (String subject, String desc, String desc1, List<String> email) { // Recruitment

		// Sender's email ID needs to be mentioned
		String from = "hrms@sltl.com";
		String pass = "hrms#123";
		// Recipient's email ID needs to be mentioned.
		String host = "smtp.gmail.com";

		// 1st step) Get the session object
		Properties props = new Properties();
		// props.put("mail.smtp.starttls.enable", "true");

		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");

		props.put("mail.smtp.socketFactory.port", "587");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.class", "javax.net.SocketFactory");
		props.put("mail.smtp.ssl.enable", "false");
		props.put("mail.smtp.ssl.trust", host);

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, pass);
			}
		});
		// 2nd step)compose message
		String body = "Sahajanand Laser Technology Ltd.";
		String body1 = "E-30, Electronics Estate, G.I.D.C., Sector-26,";
		String body2 = "GANDHINAGAR - 382028, Gujarat, INDIA.";
		String body3 = "Contact:( O): 079-2328 7461-68 Fax No.: 079-2328 7470.";
		String body4 = "www.sahajanandlaser.com";

		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));// From Address

			for (String cc : email) {
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(cc));
			}
			message.setSubject(subject);// MSG Subject
			// This mail has 2 part, the BODY and the embedded image
			MimeMultipart multipart = new MimeMultipart("related");

			// first part (the html)
			BodyPart messageBodyPart = new MimeBodyPart();
			BodyPart messageBodyPart1 = new MimeBodyPart();

			/**/

			String htmlText = "<html>";

			htmlText += "<head>";
			htmlText += "<link href=\"bower_components/bootstrap/dist/css/bootstrap.min.css\" rel=\"stylesheet\">";
			htmlText += "<link href=\"bower_components/bootstrap/dist/css/bootstrap.css\" rel=\"stylesheet\">";
			htmlText += "</head>";

			htmlText += "<body>";
			htmlText += "<br>";
			htmlText += "<fieldset>";
			htmlText += "<legend><h4>Recruitment Management</h4></legend>";
			htmlText += "<table class=\"table table-striped table-bordered table-hover\">";

			htmlText += "<tbody>";
			htmlText += "<tr>";
			htmlText += "<th>" + desc + "</th>";
			htmlText += "<th>" + desc1 + "</th>";
			htmlText += "</tr>";
			htmlText += "</tbody>";

			htmlText += "</table>";
			htmlText += "</fieldset>";

			htmlText += "</body>";
			htmlText += "</html>";

			/* String htmlText = type+"<br>"+query+"<br>"+code; */
			htmlText += "<br><br><br>";
			htmlText += "<img src=\"cid:image\"><br><b>" + body + "</b><br><b>" + body1 + "</b><br><b>" + body2
					+ "</b><br><b>" + body3 + "</b><br><b>" + body4 + "</b>";
			messageBodyPart.setContent(htmlText, "text/html");
			// add it
			multipart.addBodyPart(messageBodyPart);

			// second part (the image)
			messageBodyPart = new MimeBodyPart();
			DataSource fds = new FileDataSource("d:/hrms/upload/img/sltllogo.png");

			messageBodyPart.setDataHandler(new DataHandler(fds));
			messageBodyPart.setHeader("Content-ID", "<image>");

			// add image to the multipart
			multipart.addBodyPart(messageBodyPart);

			message.setContent(multipart);

			// 3rd step)send message
			Transport.send(message);

			System.out.println("Done Akash");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		
		
	}
	
	
	public static void send2(String subject, String desc1, String desc2,String desc3, String email[]) 
	
	{ // Recruitment

		// Sender's email ID needs to be mentioned
		String from = "hrms@sltl.com";
		String pass = "hrms#123";
		// Recipient's email ID needs to be mentioned.
		String host = "smtp.gmail.com";

		// 1st step) Get the session object
		Properties props = new Properties();
		// props.put("mail.smtp.starttls.enable", "true");

		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");

		props.put("mail.smtp.socketFactory.port", "587");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.class", "javax.net.SocketFactory");
		props.put("mail.smtp.ssl.enable", "false");
		props.put("mail.smtp.ssl.trust", host);

		Session session1 = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, pass);
			}
		});
		// 2nd step)compose message
		String body11 = "Sahajanand Laser Technology Ltd.";
		String body12 = "E-30, Electronics Estate, G.I.D.C., Sector-26,";
		String body13 = "GANDHINAGAR - 382028, Gujarat, INDIA.";
		String body14 = "Contact:( O): 079-2328 7461-68 Fax No.: 079-2328 7470.";
		String body15 = "www.sahajanandlaser.com";

		try {
			MimeMessage message = new MimeMessage(session1);
			message.setFrom(new InternetAddress(from));// From Address

			for (String cc : email) {
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(cc));
			}
			message.setSubject(subject);// MSG Subject
			// This mail has 2 part, the BODY and the embedded image
			MimeMultipart multipart = new MimeMultipart("related");

			// first part (the html)
			BodyPart messageBodyPart = new MimeBodyPart();
			BodyPart messageBodyPart1 = new MimeBodyPart();

			/**/

			String htmlText = "<html>";

			htmlText += "<head>";
			htmlText += "<link href=\"bower_components/bootstrap/dist/css/bootstrap.min.css\" rel=\"stylesheet\">";
			htmlText += "<link href=\"bower_components/bootstrap/dist/css/bootstrap.css\" rel=\"stylesheet\">";
			htmlText += "</head>";

			htmlText += "<body>";
			htmlText += "<br>";
			htmlText += "<fieldset>";
			htmlText += "<legend><h4>Recruitment Management</h4></legend>";
			htmlText += "<table class=\"table table-striped table-bordered table-hover\">";

			htmlText += "<tbody>";
			htmlText += "<tr>";
			htmlText += "<th>" + desc1 + "</th>";
			htmlText += "<th>" + desc2 + "</th>";
			htmlText += "<br>";
			htmlText += "<th>" + desc3 + "</th>";
			htmlText += "</tr>";
			htmlText += "</tbody>";

			htmlText += "</table>";
			htmlText += "</fieldset>";

			htmlText += "</body>";
			htmlText += "</html>";

			/* String htmlText = type+"<br>"+query+"<br>"+code; */
			htmlText += "<br><br><br>";
			htmlText += "<img src=\"cid:image\"><br><b>" + body11 + "</b><br><b>" + body12 + "</b><br><b>" + body13
					+ "</b><br><b>" + body14 + "</b><br><b>" + body15 + "</b>";
			messageBodyPart.setContent(htmlText, "text/html");
			// add it
			multipart.addBodyPart(messageBodyPart);

			// second part (the image)
			messageBodyPart = new MimeBodyPart();
			DataSource fds = new FileDataSource("d:/hrms/upload/img/sltllogo.png");

			messageBodyPart.setDataHandler(new DataHandler(fds));
			messageBodyPart.setHeader("Content-ID", "<image>");

			// add image to the multipart
			multipart.addBodyPart(messageBodyPart);

			message.setContent(multipart);

			// 3rd step)send message
			Transport.send(message);

			System.out.println("Done Akash");

		}
		
		catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
