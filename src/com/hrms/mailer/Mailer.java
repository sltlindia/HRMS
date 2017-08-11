package com.hrms.mailer;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Mailer {

	public static void send(String to, String subject, String fromDate ,String toDate,double days,int code,String mobileNo,String alert,int leave_id,String name,String msg) {      // MAIL FOR APPLY LEAVE
		// Sender's email ID needs to be mentioned
	     String from = "hrms@sltl.com";
	     String pass ="hrms#123";
	    // Recipient's email ID needs to be mentioned.
	   String host = "smtp.gmail.com";
	   
	   System.out.println("akash");
	   
	   
	// 1st step) Get the session object
			Properties props = new Properties();
			// props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.setProperty("mail.transport.protocol", "smtps");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.auth", "true");
			
			
			   
			   
			   
		props.put("mail.smtp.socketFactory.port", "587");  
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.socketFactory.class", "javax.net.SocketFactory");
		props.put("mail.smtp.ssl.enable", "false");
		props.put("mail.smtp.ssl.trust", host);
			   

			Session session = Session.getInstance(props, new javax.mail.Authenticator() {
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
			String link = "http://192.168.182.58:6018/HRMS/";
	        
			try {
				MimeMessage message = new MimeMessage(session);
				message.setFrom(new InternetAddress(from));// From Address
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));// To
				
				message.setSubject(subject);// MSG Subject
				// This mail has 2 part, the BODY and the embedded image
		         MimeMultipart multipart = new MimeMultipart("related");

		         // first part (the html)
		         BodyPart messageBodyPart = new MimeBodyPart();
		         BodyPart messageBodyPart1 = new MimeBodyPart();
		         
		         /**/
		         
		          String  htmlText = "<html>";
		          
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
		          htmlText += "<td align=\"right\"><img src=\"https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcQjJkNWrO_pXGhZoAvyStzhRr70iS-ZdCO7JUoQivdyMWqbV0HtLQ\"\r\n" + 
		          		"								height=\"40px\" width=\"40px\"\r\n" + 
		          		"								class=\"CToWUd\"></td>";
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
		          htmlText += "<td><div class=\"a6S\" dir=\"ltr\" style=\"opacity: 0.01; left: 521.5px; top: 236px;\"> <div id=\":13q\" class=\"T-I J-J5-Ji aQv T-I-ax7 L3 a5q\"" + 
		          		"role=\"button\" tabindex=\"0\" aria-label=\"Download attachment \" data-tooltip-class=\"a1V\" data-tooltip=\"Download\"> <div class=\"aSK J-J5-Ji aYr\"></div>" + 
		          		"</div> </div></td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td>";
		          htmlText += "<table cellpadding=\"15\" cellspacing=\"0\" border=\"0\" width=\"100%\">";
		          htmlText += "<tbody>";
		          htmlText += "<tr>";
		          htmlText += "<td> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 13px; color: #121212; line-height: 18px; padding-bottom: 10px\">" + 
		          		" Respected Sir / Ma'am,</p> "
		          		+ "<p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 13px; color: #121212; line-height: 18px\">" + 
		          		" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Your Reporting Employee <b>"+name+".</b></p>"
		          		+ "<p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 13px; color: #121212; line-height: 18px\">" + 
		          		" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <b>"+msg+"</b></p>";
		          
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
		          
		          htmlText += " <tr><td><img src=\"http://www.letk.ee/img/document.png\" style=\"color: black;\" height=\"20px\" width=\"20px\" class=\"CToWUd\"><b>&nbsp; Leave Detail </b><hr>"
		          		+ "</td> </tr>";
		          
		          htmlText += "<tr>";
		          htmlText += "<td>";
		          htmlText += "<table cellpadding=\"10\" cellspacing=\"0\" border=\"0\" width=\"100%\" style=\"border: solid #f4f4f4 1px\">";
		          htmlText += "<tbody>";
		          htmlText += "<tr>";
		          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">" + 
		          		" <strong>Employee Code </strong> </p> </td>";
		          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 14px; color: #121212; line-height: 13px\">"+code+"</p></td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		"<strong>From Date</strong> </p> </td>";
		          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		""+fromDate+"</p> </td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" <strong>To Date</strong> </p> </td>";
		          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" "+toDate+"</p> </td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" <strong>Total Days</strong> </p> </td>";
		          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" "+days+"</p> </td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" <strong>Mobile Number</strong> </p> </td>";
		          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		""+mobileNo+"</p></td>";
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
		          htmlText += "<table cellpadding=\"20\" cellspacing=\"0\" border=\"0\" width=\"100%\">";
		          htmlText += "<tbody>";
		          htmlText += "<tr>";
		          htmlText += "<td>";
		          htmlText += "<p align=\"center\" style=\"font-size: 13px; padding: 0px; margin: 0px; line-height: 20px; color: #121212;\"> For Approve Or Reject This Leave <a href=\"http://192.168.182.58:6018/HRMS/ByEmailLeaveApproveReject.jsp?leave_id="+leave_id+"\"><button style=\" background-color: white; color: black; border: 2px solid #337ab7;\">Click here</button></a></p>";
		          htmlText += "<br>";
		          htmlText += "<p align=\"center\" style=\"font-size: 13px; padding: 0px; margin: 0px; line-height: 13px; color: #121212; padding-bottom: 10px\">\r\n" + 
		          		" <span style=\"font-size: 14px\">OR</span></p>";
		          htmlText += "<p style=\"font-size: 13px; padding: 0px; margin: 0px; padding-left: 5px; line-height: 20px; color: #121212; text-align: center\">For Login into HRMS <a href=\"http://192.168.182.58:6018/HRMS/\"><button style=\" background-color: white; color: black; border: 2px solid #337ab7;\">Login</button></a> </p>";
		          htmlText += "<br>";
		          htmlText += "<p align=\"center\" style=\"font-size: 11px; padding: 0px; margin: 0px; line-height: 13px; color: red; padding-bottom: 10px\"><b>Note : This button will work only when you are connected to SLTL Intranet.</b></p>";
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
		          htmlText += "<td><p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 13px; color: #121212; line-height: 20px; padding-bottom: 10px\"> For any queries or concerns, contact us on <b>313</b>.</p></td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td>";
		          htmlText += "<p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 13px; color: #121212; line-height: 20px\"> Regards,<br> Team HRMS </p>";
		          htmlText += "<br><p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 11px; color: #333; line-height: 20px; font-style: italic\">* This is an automated e-mail alert to help you to know about leave of employee who Report You. Hence, Please do not reply to this e-mail.</p>";
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
		          
		        /* String htmlText = type+"<br>"+query+"<br>"+code;*/
		          //htmlText += "<br><br><br>";
		        //  htmlText += "<img src=\"cid:image\"><br><b>"+body+"</b><br><b>"+body1+"</b><br><b>"+body2+"</b><br><b>"+body3+"</b><br><b>"+body4+"</b>";
		         messageBodyPart.setContent(htmlText, "text/html");
		         // add it
		         multipart.addBodyPart(messageBodyPart);

		         // second part (the image)
		         messageBodyPart = new MimeBodyPart();
		         DataSource fds = new FileDataSource(
		            "D:/hrms/upload/img/sltllogo.png");

		         messageBodyPart.setDataHandler(new DataHandler(fds));
		         messageBodyPart.setHeader("Content-ID", "<image>");

		         // add image to the multipart
		         multipart.addBodyPart(messageBodyPart);
		         
		        
		         message.setContent(multipart);
		         
				// 3rd step)send message
				Transport.send(message);

				System.out.println("Done : "+to);

			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
			
			
		 
	 }
	
	
	public static void send1(String to, String subject, String fromDate ,String toDate,double days,String status,String reason, int emp_code, String name) {      // Leave Approve Reject Mail
		 
		// Sender's email ID needs to be mentioned
	     String from = "hrms@sltl.com";
	     String pass ="hrms#123";
	    // Recipient's email ID needs to be mentioned.
	   String host = "smtp.gmail.com";
	   
	   
	   
	   
	// 1st step) Get the session object
				Properties props = new Properties();
				// props.put("mail.smtp.starttls.enable", "true");
				
				props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
				
				props.setProperty("mail.transport.protocol", "smtps");
				props.put("mail.smtp.starttls.enable", "true");
				props.put("mail.smtp.host", host);
				props.put("mail.smtp.port", "587");
				props.put("mail.smtp.auth", "true");
				   
				   
				   
				props.put("mail.smtp.socketFactory.port", "587");  
				props.put("mail.smtp.starttls.enable", "true");
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
			String link = "http://192.168.182.58:6018/HRMS/";
			
			try {
				MimeMessage message = new MimeMessage(session);
				message.setFrom(new InternetAddress(from));// From Address
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));// To
				
				message.setSubject(subject);// MSG Subject
				// This mail has 2 part, the BODY and the embedded image
		         MimeMultipart multipart = new MimeMultipart("related");

		         // first part (the html)
		         BodyPart messageBodyPart = new MimeBodyPart();
		         BodyPart messageBodyPart1 = new MimeBodyPart();
		         
		         /**/
		         
		         String  htmlText = "<html>";
		          
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
		          htmlText += "<td align=\"right\"><img src=\"https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcQjJkNWrO_pXGhZoAvyStzhRr70iS-ZdCO7JUoQivdyMWqbV0HtLQ\"\r\n" + 
		          		"								height=\"40px\" width=\"40px\"\r\n" + 
		          		"								class=\"CToWUd\"></td>";
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
		          htmlText += "<td><div class=\"a6S\" dir=\"ltr\" style=\"opacity: 0.01; left: 521.5px; top: 236px;\"> <div id=\":13q\" class=\"T-I J-J5-Ji aQv T-I-ax7 L3 a5q\"" + 
		          		"role=\"button\" tabindex=\"0\" aria-label=\"Download attachment \" data-tooltip-class=\"a1V\" data-tooltip=\"Download\"> <div class=\"aSK J-J5-Ji aYr\"></div>" + 
		          		"</div> </div></td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td>";
		          htmlText += "<table cellpadding=\"15\" cellspacing=\"0\" border=\"0\" width=\"100%\">";
		          htmlText += "<tbody>";
		          htmlText += "<tr>";
		          htmlText += "<td> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 13px; color: #121212; line-height: 18px; padding-bottom: 10px\">" + 
		          		" Dear "+name+", </p> "
		          		+ "<p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 13px; color: #121212; line-height: 18px\">" + 
		          		"  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Your Leave is <b>"+status+"</b> .</p>";
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
		          
		          htmlText += " <tr><td><img src=\"http://www.letk.ee/img/document.png\" style=\"color: black;\" height=\"20px\" width=\"20px\" class=\"CToWUd\"><b>&nbsp; Leave Detail </b><hr>"
			          		+ "</td> </tr>";
		          
		          htmlText += "<tr>";
		          htmlText += "<td>";
		          htmlText += "<table cellpadding=\"10\" cellspacing=\"0\" border=\"0\" width=\"100%\" style=\"border: solid #f4f4f4 1px\">";
		          htmlText += "<tbody>";
		          htmlText += "<tr>";
		          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">" + 
		          		" <strong>Employee Code </strong> </p> </td>";
		          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 14px; color: #121212; line-height: 13px\">"+emp_code+"</p></td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		"<strong>From Date</strong> </p> </td>";
		          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		""+fromDate+"</p> </td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" <strong>To Date</strong> </p> </td>";
		          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" "+toDate+"</p> </td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" <strong>Total Days</strong> </p> </td>";
		          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" "+days+"</p> </td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" <strong>Status</strong> </p> </td>";
		          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		""+status+"</p></td>";
		          htmlText += "</tr>";
		          
		          if(reason != ""){
		          htmlText += "<tr>";
		          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" <strong>Reason</strong> </p> </td>";
		          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		""+reason+"</p></td>";
		          htmlText += "</tr>";
		          }
		          
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
		          htmlText += "<table cellpadding=\"20\" cellspacing=\"0\" border=\"0\" width=\"100%\">";
		          htmlText += "<tbody>";
		          htmlText += "<tr>";
		          htmlText += "<td>";
		          htmlText += "<p style=\"font-size: 13px; padding: 0px; margin: 0px; padding-left: 5px; line-height: 20px; color: #121212; text-align: center\">For Login into HRMS <a href=\"http://192.168.182.58:6018/HRMS/\"><button style=\" background-color: white; color: black; border: 2px solid #337ab7;\">Login</button></a> </p>";
		          htmlText += "<br>";
		          htmlText += "<p align=\"center\" style=\"font-size: 11px; padding: 0px; margin: 0px; line-height: 13px; color: red; padding-bottom: 10px\"><b>Note : This button will work only when you are connected to SLTL Intranet.</b></p>";
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
		          htmlText += "<td><p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 13px; color: #121212; line-height: 20px; padding-bottom: 10px\"> For any queries or concerns, contact us on <b>313</b>.</p></td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td>";
		          htmlText += "<p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 13px; color: #121212; line-height: 20px\"> Regards,<br> Team HRMS </p>";
		          htmlText += "<br><p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 11px; color: #333; line-height: 20px; font-style: italic\">* This is an automated e-mail alert to help you to know about your leave. Hence, Please do not reply to this e-mail.</p>";
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
		          
		        /* String htmlText = type+"<br>"+query+"<br>"+code;*/
		        //  htmlText += "<br><br><br>";
		        // htmlText += "<img src=\"cid:image\"><br><b>"+body+"</b><br><b>"+body1+"</b><br><b>"+body2+"</b><br><b>"+body3+"</b><br><b>"+body4+"</b>";
		         messageBodyPart.setContent(htmlText, "text/html");
		         // add it
		         multipart.addBodyPart(messageBodyPart);

		         // second part (the image)
		         messageBodyPart = new MimeBodyPart();
		         DataSource fds = new FileDataSource(
		            "D:/hrms/upload/img/sltllogo.png");

		         messageBodyPart.setDataHandler(new DataHandler(fds));
		         messageBodyPart.setHeader("Content-ID", "<image>");

		         // add image to the multipart
		         multipart.addBodyPart(messageBodyPart);
		         
		        
		         message.setContent(multipart);
		         
				// 3rd step)send message
				Transport.send(message);

				System.out.println("Done : "+to);

			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
			
			
		 
	 }
	
	
	
	
	public static void coPendingSend(String to, String subject, String coDate ,double totalHours,double coCount,int emp_code,String name,String purpose,int co_id,String msg) {      // MAIL FOR PENDING CO SEND
		// Sender's email ID needs to be mentioned
	     String from = "hrms@sltl.com";
	     String pass ="hrms#123";
	    // Recipient's email ID needs to be mentioned.
	   String host = "smtp.gmail.com";
	   
	   System.out.println("akash");
	   
	   
	// 1st step) Get the session object
			Properties props = new Properties();
			// props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.setProperty("mail.transport.protocol", "smtps");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.auth", "true");
			   
			props.put("mail.smtp.socketFactory.port", "587");  
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.socketFactory.class", "javax.net.SocketFactory");
			props.put("mail.smtp.ssl.enable", "false");
			props.put("mail.smtp.ssl.trust", host);
				   

			Session session = Session.getInstance(props, new javax.mail.Authenticator() {
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
			String link = "http://192.168.182.58:6018/HRMS/";
	        
			try {
				MimeMessage message = new MimeMessage(session);
				message.setFrom(new InternetAddress(from));// From Address
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));// To
				
				message.setSubject(subject);// MSG Subject
				// This mail has 2 part, the BODY and the embedded image
		         MimeMultipart multipart = new MimeMultipart("related");

		         // first part (the html)
		         BodyPart messageBodyPart = new MimeBodyPart();
		         BodyPart messageBodyPart1 = new MimeBodyPart();
		         
		         /**/
		         
		          String  htmlText = "<html>";
		          
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
		          htmlText += "<td align=\"right\"><img src=\"https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcQjJkNWrO_pXGhZoAvyStzhRr70iS-ZdCO7JUoQivdyMWqbV0HtLQ\"\r\n" + 
		          		"								height=\"40px\" width=\"40px\"\r\n" + 
		          		"								class=\"CToWUd\"></td>";
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
		          htmlText += "<td><div class=\"a6S\" dir=\"ltr\" style=\"opacity: 0.01; left: 521.5px; top: 236px;\"> <div id=\":13q\" class=\"T-I J-J5-Ji aQv T-I-ax7 L3 a5q\"" + 
		          		"role=\"button\" tabindex=\"0\" aria-label=\"Download attachment \" data-tooltip-class=\"a1V\" data-tooltip=\"Download\"> <div class=\"aSK J-J5-Ji aYr\"></div>" + 
		          		"</div> </div></td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td>";
		          htmlText += "<table cellpadding=\"15\" cellspacing=\"0\" border=\"0\" width=\"100%\">";
		          htmlText += "<tbody>";
		          htmlText += "<tr>";
		          htmlText += "<td> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 13px; color: #121212; line-height: 18px; padding-bottom: 10px\">" + 
		          		" Respected Sir / Ma'am,</p> "
		          		+ "<p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 13px; color: #121212; line-height: 18px\">" + 
		          		" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Your Reporting Employee <b>"+name+".</b></p>"
		          		+ "<p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 13px; color: #121212; line-height: 18px\">" + 
		          		" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <b>"+msg+"</b></p> ";
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
		          htmlText += " <tr><td><img src=\"http://www.letk.ee/img/document.png\" style=\"color: black;\" height=\"20px\" width=\"20px\" class=\"CToWUd\"><b>&nbsp; CO Detail </b><hr>"
			          		+ "</td> </tr>";
		         
		          htmlText += "<tr>"; 
		          htmlText += "<td>";
		          htmlText += "<table cellpadding=\"10\" cellspacing=\"0\" border=\"0\" width=\"100%\" style=\"border: solid #f4f4f4 1px\">";
		          htmlText += "<tbody>";
		          htmlText += "<tr>";
		          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\" width=\"130px;\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">" + 
		          		" <strong>Employee Code </strong> </p> </td>";
		          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 14px; color: #121212; line-height: 13px\">"
		          		+emp_code+"</p></td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\" width=\"130px;\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		"<strong>CO Date</strong> </p> </td>";
		          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		""+coDate+"</p> </td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\" width=\"130px;\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" <strong>Total Working Hours</strong> </p> </td>";
		          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" "+totalHours+"</p> </td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\" width=\"130px;\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" <strong>Total CO</strong> </p> </td>";
		          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" "+coCount+"</p> </td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\" width=\"130px;\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" <strong>Purpose</strong> </p> </td>";
		          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		""+purpose+"</p></td>";
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
		          htmlText += "<table cellpadding=\"20\" cellspacing=\"0\" border=\"0\" width=\"100%\">";
		          htmlText += "<tbody>";
		          htmlText += "<tr>";
		          htmlText += "<td>";
		          
		          
		          htmlText += "<p align=\"center\" style=\"font-size: 13px; padding: 0px; margin: 0px; line-height: 20px; color: #121212;\"> For Approve Or Reject This CO <a href=\"http://192.168.182.58:6018/HRMS/COApproveRejectByMail.jsp?co_id="+co_id+"\"><button style=\" background-color: white; color: black; border: 2px solid #337ab7;\">Click here</button></a></p>";
		          htmlText += "<br>";
		          htmlText += "<p align=\"center\" style=\"font-size: 13px; padding: 0px; margin: 0px; line-height: 13px; color: #121212; padding-bottom: 10px\">\r\n" + 
		          		" <span style=\"font-size: 14px\">OR</span></p>";
		          
		          
		          htmlText += "<p style=\"font-size: 13px; padding: 0px; margin: 0px; padding-left: 5px; line-height: 20px; color: #121212; text-align: center\">For Login into HRMS <a href=\"http://192.168.182.58:6018/HRMS/\"><button style=\" background-color: white; color: black; border: 2px solid #337ab7;\">Login</button></a> </p>";
		          htmlText += "<br>";
		          htmlText += "<p align=\"center\" style=\"font-size: 11px; padding: 0px; margin: 0px; line-height: 13px; color: red; padding-bottom: 10px\"><b>Note : This button will work only when you are connected to SLTL Intranet.</b></p>";
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
		          htmlText += "<td><p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 13px; color: #121212; line-height: 20px; padding-bottom: 10px\"> For any queries or concerns, contact us on <b>313</b>.</p></td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td>";
		          htmlText += "<p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 13px; color: #121212; line-height: 20px\"> Regards,<br> Team HRMS </p>";
		          htmlText += "<br><p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 11px; color: #333; line-height: 20px; font-style: italic\">* This is an automated e-mail alert to help you to know about CO of employee who Report You. Hence, Please do not reply to this e-mail.</p>";
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
		          
		        /* String htmlText = type+"<br>"+query+"<br>"+code;*/
		          //htmlText += "<br><br><br>";
		        //  htmlText += "<img src=\"cid:image\"><br><b>"+body+"</b><br><b>"+body1+"</b><br><b>"+body2+"</b><br><b>"+body3+"</b><br><b>"+body4+"</b>";
		         messageBodyPart.setContent(htmlText, "text/html");
		         // add it
		         multipart.addBodyPart(messageBodyPart);

		         // second part (the image)
		         messageBodyPart = new MimeBodyPart();
		         DataSource fds = new FileDataSource(
		            "D:/hrms/upload/img/sltllogo.png");

		         messageBodyPart.setDataHandler(new DataHandler(fds));
		         messageBodyPart.setHeader("Content-ID", "<image>");

		         // add image to the multipart
		         multipart.addBodyPart(messageBodyPart);
		         
		        
		         message.setContent(multipart);
		         
				// 3rd step)send message
				Transport.send(message);

				System.out.println("Done : "+to);

			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
			
			
		 
	 }
	
	
	
	
	
	
	
	
	public static void COAcceptRejectSend(String to, String subject, String CODate,double totalHours, double coCount, int emp_code, String name, String purpose, String status, String reason) {      // CO Accept Reject Mail

		// Sender's email ID needs to be mentioned
	     String from = "hrms@sltl.com";
	     String pass ="hrms#123";
	    // Recipient's email ID needs to be mentioned.
	   String host = "smtp.gmail.com";
	   
	   
	   
	   
	// 1st step) Get the session object
				Properties props = new Properties();
				// props.put("mail.smtp.starttls.enable", "true");
				
				props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
				
				props.setProperty("mail.transport.protocol", "smtps");
				props.put("mail.smtp.starttls.enable", "true");
				props.put("mail.smtp.host", host);
				props.put("mail.smtp.port", "587");
				props.put("mail.smtp.auth", "true");
				   
				   
				   
				props.put("mail.smtp.socketFactory.port", "587");  
				props.put("mail.smtp.starttls.enable", "true");
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
			String link = "http://192.168.182.58:6018/HRMS/";
			
			try {
				MimeMessage message = new MimeMessage(session);
				message.setFrom(new InternetAddress(from));// From Address
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));// To
				
				message.setSubject(subject);// MSG Subject
				// This mail has 2 part, the BODY and the embedded image
		         MimeMultipart multipart = new MimeMultipart("related");

		         // first part (the html)
		         BodyPart messageBodyPart = new MimeBodyPart();
		         BodyPart messageBodyPart1 = new MimeBodyPart();
		         
		         /**/
		         

		         String  htmlText = "<html>";
		          
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
		          htmlText += "<td align=\"right\"><img src=\"https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcQjJkNWrO_pXGhZoAvyStzhRr70iS-ZdCO7JUoQivdyMWqbV0HtLQ\"\r\n" + 
		          		"								height=\"40px\" width=\"40px\"\r\n" + 
		          		"								class=\"CToWUd\"></td>";
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
		          htmlText += "<td><div class=\"a6S\" dir=\"ltr\" style=\"opacity: 0.01; left: 521.5px; top: 236px;\"> <div id=\":13q\" class=\"T-I J-J5-Ji aQv T-I-ax7 L3 a5q\"" + 
		          		"role=\"button\" tabindex=\"0\" aria-label=\"Download attachment \" data-tooltip-class=\"a1V\" data-tooltip=\"Download\"> <div class=\"aSK J-J5-Ji aYr\"></div>" + 
		          		"</div> </div></td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td>";
		          htmlText += "<table cellpadding=\"15\" cellspacing=\"0\" border=\"0\" width=\"100%\">";
		          htmlText += "<tbody>";
		          htmlText += "<tr>";
		          htmlText += "<td> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 13px; color: #121212; line-height: 18px; padding-bottom: 10px\">" + 
		          		" Dear "+name+", </p> "
		          		+ "<p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 13px; color: #121212; line-height: 18px\">" + 
		          		"  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Your CO is <b>"+status+"</b> .</p>";
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
		          htmlText += " <tr><td><img src=\"http://www.letk.ee/img/document.png\" style=\"color: black;\" height=\"20px\" width=\"20px\" class=\"CToWUd\"><b>&nbsp; CO Detail </b><hr>"
			          		+ "</td> </tr>";
			         
		          htmlText += "<tr>";
		          htmlText += "<td>";
		          htmlText += "<table cellpadding=\"10\" cellspacing=\"0\" border=\"0\" width=\"100%\" style=\"border: solid #f4f4f4 1px\">";
		          htmlText += "<tbody>";
		          htmlText += "<tr>";
		          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\" width=\"130px;\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">" + 
		          		" <strong>Employee Code </strong> </p> </td>";
		          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 14px; color: #121212; line-height: 13px\">"+emp_code+"</p></td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\" width=\"130px;\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		"<strong>CO Date</strong> </p> </td>";
		          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		""+CODate+"</p> </td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\" width=\"130px;\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" <strong>Total Working Hours</strong> </p> </td>";
		          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" "+totalHours+"</p> </td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\" width=\"130px;\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" <strong>Total CO</strong> </p> </td>";
		          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" "+coCount+"</p> </td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\" width=\"130px;\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" <strong>Purpose</strong> </p> </td>";
		          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		""+purpose+"</p></td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\" width=\"130px;\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" <strong>Status</strong> </p> </td>";
		          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		""+status+"</p></td>";
		          htmlText += "</tr>";
		          
		          if(reason != ""){
			          htmlText += "<tr>";
			          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\" width=\"130px;\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
			          		" <strong>Reason</strong> </p> </td>";
			          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
			          		""+reason+"</p></td>";
			          htmlText += "</tr>";
		          }
		          
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
		          htmlText += "<table cellpadding=\"20\" cellspacing=\"0\" border=\"0\" width=\"100%\">";
		          htmlText += "<tbody>";
		          htmlText += "<tr>";
		          htmlText += "<td>";
		          htmlText += "<p style=\"font-size: 13px; padding: 0px; margin: 0px; padding-left: 5px; line-height: 20px; color: #121212; text-align: center\">For Login into HRMS <a href=\"http://192.168.182.58:6018/HRMS/\"><button style=\" background-color: white; color: black; border: 2px solid #337ab7;\">Login</button></a> </p>";
		          htmlText += "<br>";
		          htmlText += "<p align=\"center\" style=\"font-size: 11px; padding: 0px; margin: 0px; line-height: 13px; color: red; padding-bottom: 10px\"><b>Note : This button will work only when you are connected to SLTL Intranet.</b></p>";
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
		          htmlText += "<td><p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 13px; color: #121212; line-height: 20px; padding-bottom: 10px\"> For any queries or concerns, contact us on <b>313</b>.</p></td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td>";
		          htmlText += "<p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 13px; color: #121212; line-height: 20px\"> Regards,<br> Team HRMS </p>";
		          htmlText += "<br><p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 11px; color: #333; line-height: 20px; font-style: italic\">* This is an automated e-mail alert to help you to know about your CO. Hence, Please do not reply to this e-mail.</p>";
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
		          
		        /* String htmlText = type+"<br>"+query+"<br>"+code;*/
		        //  htmlText += "<br><br><br>";
		        // htmlText += "<img src=\"cid:image\"><br><b>"+body+"</b><br><b>"+body1+"</b><br><b>"+body2+"</b><br><b>"+body3+"</b><br><b>"+body4+"</b>";
		         messageBodyPart.setContent(htmlText, "text/html");
		         // add it
		         multipart.addBodyPart(messageBodyPart);

		         // second part (the image)
		         messageBodyPart = new MimeBodyPart();
		         DataSource fds = new FileDataSource(
		            "D:/hrms/upload/img/sltllogo.png");

		         messageBodyPart.setDataHandler(new DataHandler(fds));
		         messageBodyPart.setHeader("Content-ID", "<image>");

		         // add image to the multipart
		         multipart.addBodyPart(messageBodyPart);
		         
		        
		         message.setContent(multipart);
		         
				// 3rd step)send message
				Transport.send(message);

				System.out.println("Done : "+to);

			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
			
			
		 
	 }
	
	
	
public static void ODPendingSend(String to, String subject, String OD_start_date, String OD_end_date, double total_OD, int emp_code, String name, String purpose,int od_id,String msg) {      // MAIL FOR PENDING OD SEND
		
		// Sender's email ID needs to be mentioned
	     String from = "hrms@sltl.com";
	     String pass ="hrms#123";
	    // Recipient's email ID needs to be mentioned.
	   String host = "smtp.gmail.com";
	   
	   System.out.println("akash");
	   
	   
	// 1st step) Get the session object
			Properties props = new Properties();
			// props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.setProperty("mail.transport.protocol", "smtps");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.auth", "true");
			
			
			   
			   
			   
		props.put("mail.smtp.socketFactory.port", "587");  
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.socketFactory.class", "javax.net.SocketFactory");
		props.put("mail.smtp.ssl.enable", "false");
		props.put("mail.smtp.ssl.trust", host);
			   

			Session session = Session.getInstance(props, new javax.mail.Authenticator() {
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
			String link = "http://192.168.182.58:6018/HRMS/";
	        
			try {
				MimeMessage message = new MimeMessage(session);
				message.setFrom(new InternetAddress(from));// From Address
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));// To
				
				message.setSubject(subject);// MSG Subject
				// This mail has 2 part, the BODY and the embedded image
		         MimeMultipart multipart = new MimeMultipart("related");

		         // first part (the html)
		         BodyPart messageBodyPart = new MimeBodyPart();
		         BodyPart messageBodyPart1 = new MimeBodyPart();
		         
		         /**/
		         
		          String  htmlText = "<html>";
		          
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
		          htmlText += "<td align=\"right\"><img src=\"https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcQjJkNWrO_pXGhZoAvyStzhRr70iS-ZdCO7JUoQivdyMWqbV0HtLQ\"\r\n" + 
		          		"								height=\"40px\" width=\"40px\"\r\n" + 
		          		"								class=\"CToWUd\"></td>";
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
		          htmlText += "<td><div class=\"a6S\" dir=\"ltr\" style=\"opacity: 0.01; left: 521.5px; top: 236px;\"> <div id=\":13q\" class=\"T-I J-J5-Ji aQv T-I-ax7 L3 a5q\"" + 
		          		"role=\"button\" tabindex=\"0\" aria-label=\"Download attachment \" data-tooltip-class=\"a1V\" data-tooltip=\"Download\"> <div class=\"aSK J-J5-Ji aYr\"></div>" + 
		          		"</div> </div></td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td>";
		          htmlText += "<table cellpadding=\"15\" cellspacing=\"0\" border=\"0\" width=\"100%\">";
		          htmlText += "<tbody>";
		          htmlText += "<tr>";
		          htmlText += "<td> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 13px; color: #121212; line-height: 18px; padding-bottom: 10px\">" + 
		          		" Respected Sir / Ma'am,</p> "
		          		+ "<p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 13px; color: #121212; line-height: 18px\">" + 
		          		" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Your Reporting Employee <b>"+name+".</b></p>"
		          		+ "<p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 13px; color: #121212; line-height: 18px\">" + 
		          		" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <b>"+msg+"</b></p>";
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
		          
		          htmlText += " <tr><td><img src=\"http://www.letk.ee/img/document.png\" style=\"color: black;\" height=\"20px\" width=\"20px\" class=\"CToWUd\"><b>&nbsp; OD Detail </b><hr>"
			          		+ "</td> </tr>";
			         
		          
		          htmlText += "<tr>";
		          htmlText += "<td>";
		          htmlText += "<table cellpadding=\"10\" cellspacing=\"0\" border=\"0\" width=\"100%\" style=\"border: solid #f4f4f4 1px\">";
		          htmlText += "<tbody>";
		          htmlText += "<tr>";
		          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">" + 
		          		" <strong>Employee Code </strong> </p> </td>";
		          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 14px; color: #121212; line-height: 13px\">"+emp_code+"</p></td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		"<strong>OD Start Date</strong> </p> </td>";
		          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		""+OD_start_date+"</p> </td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" <strong>OD End Date</strong> </p> </td>";
		          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" "+OD_end_date+"</p> </td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" <strong>Total Days</strong> </p> </td>";
		          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" "+total_OD+"</p> </td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" <strong>Purpose</strong> </p> </td>";
		          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		""+purpose+"</p></td>";
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
		          htmlText += "<table cellpadding=\"20\" cellspacing=\"0\" border=\"0\" width=\"100%\">";
		          htmlText += "<tbody>";
		          htmlText += "<tr>";
		          htmlText += "<td>";
		          htmlText += "<p align=\"center\" style=\"font-size: 13px; padding: 0px; margin: 0px; line-height: 20px; color: #121212;\"> For Approve Or Reject This OD <a href=\"http://192.168.182.58:6018/HRMS/ODApproveRejectByMail.jsp?od_id="+od_id+"\"><button style=\" background-color: white; color: black; border: 2px solid #337ab7;\">Click here</button></a></p>";
		          htmlText += "<br>";
		          htmlText += "<p align=\"center\" style=\"font-size: 13px; padding: 0px; margin: 0px; line-height: 13px; color: #121212; padding-bottom: 10px\">\r\n" + 
		          		" <span style=\"font-size: 14px\">OR</span></p>";
		          htmlText += "<p style=\"font-size: 13px; padding: 0px; margin: 0px; padding-left: 5px; line-height: 20px; color: #121212; text-align: center\">For Login into HRMS <a href=\"http://192.168.182.58:6018/HRMS/\"><button style=\" background-color: white; color: black; border: 2px solid #337ab7;\">Login</button></a> </p>";
		          htmlText += "<br>";
		          htmlText += "<p align=\"center\" style=\"font-size: 11px; padding: 0px; margin: 0px; line-height: 13px; color: red; padding-bottom: 10px\"><b>Note : This button will work only when you are connected to SLTL Intranet.</b></p>";
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
		          htmlText += "<td><p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 13px; color: #121212; line-height: 20px; padding-bottom: 10px\"> For any queries or concerns, contact us on <b>313</b>.</p></td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td>";
		          htmlText += "<p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 13px; color: #121212; line-height: 20px\"> Regards,<br> Team HRMS </p>";
		          htmlText += "<br><p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 11px; color: #333; line-height: 20px; font-style: italic\">* This is an automated e-mail alert to help you to know about OD of employee who Report You. Hence, Please do not reply to this e-mail.</p>";
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
		          
		        /* String htmlText = type+"<br>"+query+"<br>"+code;*/
		          //htmlText += "<br><br><br>";
		        //  htmlText += "<img src=\"cid:image\"><br><b>"+body+"</b><br><b>"+body1+"</b><br><b>"+body2+"</b><br><b>"+body3+"</b><br><b>"+body4+"</b>";
		         messageBodyPart.setContent(htmlText, "text/html");
		         // add it
		         multipart.addBodyPart(messageBodyPart);

		         // second part (the image)
		         messageBodyPart = new MimeBodyPart();
		         DataSource fds = new FileDataSource(
		            "D:/hrms/upload/img/sltllogo.png");

		         messageBodyPart.setDataHandler(new DataHandler(fds));
		         messageBodyPart.setHeader("Content-ID", "<image>");

		         // add image to the multipart
		         multipart.addBodyPart(messageBodyPart);
		         
		        
		         message.setContent(multipart);
		         
				// 3rd step)send message
				Transport.send(message);

				System.out.println("Done : "+to);

			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
			
			
		 
	 }
	
	
	
	
	public static void ODAcceptRejectSend(String to, String subject, String OD_start_date ,String OD_end_date,double total_OD,String status,String reason, String purpose, int emp_code, String name) {      // OD Approve Reject Mail
	 
	// Sender's email ID needs to be mentioned
     String from = "hrms@sltl.com";
     String pass ="hrms#123";
    // Recipient's email ID needs to be mentioned.
   String host = "smtp.gmail.com";
   
   
   
   
// 1st step) Get the session object
			Properties props = new Properties();
			// props.put("mail.smtp.starttls.enable", "true");
			
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			
			props.setProperty("mail.transport.protocol", "smtps");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.auth", "true");
			   
			   
			   
			props.put("mail.smtp.socketFactory.port", "587");  
			props.put("mail.smtp.starttls.enable", "true");
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
		String link = "http://192.168.182.58:6018/HRMS/";
		
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));// From Address
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));// To
			
			message.setSubject(subject);// MSG Subject
			// This mail has 2 part, the BODY and the embedded image
	         MimeMultipart multipart = new MimeMultipart("related");

	         // first part (the html)
	         BodyPart messageBodyPart = new MimeBodyPart();
	         BodyPart messageBodyPart1 = new MimeBodyPart();
	         
	         /**/
	         
	         String  htmlText = "<html>";
	          
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
	          htmlText += "<td align=\"right\"><img src=\"https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcQjJkNWrO_pXGhZoAvyStzhRr70iS-ZdCO7JUoQivdyMWqbV0HtLQ\"\r\n" + 
	          		"								height=\"40px\" width=\"40px\"\r\n" + 
	          		"								class=\"CToWUd\"></td>";
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
	          htmlText += "<td><div class=\"a6S\" dir=\"ltr\" style=\"opacity: 0.01; left: 521.5px; top: 236px;\"> <div id=\":13q\" class=\"T-I J-J5-Ji aQv T-I-ax7 L3 a5q\"" + 
	          		"role=\"button\" tabindex=\"0\" aria-label=\"Download attachment \" data-tooltip-class=\"a1V\" data-tooltip=\"Download\"> <div class=\"aSK J-J5-Ji aYr\"></div>" + 
	          		"</div> </div></td>";
	          htmlText += "</tr>";
	          htmlText += "<tr>";
	          htmlText += "<td>";
	          htmlText += "<table cellpadding=\"15\" cellspacing=\"0\" border=\"0\" width=\"100%\">";
	          htmlText += "<tbody>";
	          htmlText += "<tr>";
	          htmlText += "<td> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 13px; color: #121212; line-height: 18px; padding-bottom: 10px\">" + 
	          		" Dear "+name+", </p> "
	          		+ "<p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 13px; color: #121212; line-height: 18px\">" + 
	          		"  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Your OD is <b>"+status+"</b> .</p>";
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
	          
	          htmlText += " <tr><td><img src=\"http://www.letk.ee/img/document.png\" style=\"color: black;\" height=\"20px\" width=\"20px\" class=\"CToWUd\"><b>&nbsp; OD Detail </b><hr>"
		          		+ "</td> </tr>";
	          
	          htmlText += "<tr>";
	          htmlText += "<td>";
	          htmlText += "<table cellpadding=\"10\" cellspacing=\"0\" border=\"0\" width=\"100%\" style=\"border: solid #f4f4f4 1px\">";
	          htmlText += "<tbody>";
	          htmlText += "<tr>";
	          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">" + 
	          		" <strong>Employee Code </strong> </p> </td>";
	          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 14px; color: #121212; line-height: 13px\">"+emp_code+"</p></td>";
	          htmlText += "</tr>";
	          htmlText += "<tr>";
	          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
	          		"<strong>OD Start Date</strong> </p> </td>";
	          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
	          		""+OD_start_date+"</p> </td>";
	          htmlText += "</tr>";
	          htmlText += "<tr>";
	          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
	          		" <strong>OD End Date</strong> </p> </td>";
	          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
	          		" "+OD_end_date+"</p> </td>";
	          htmlText += "</tr>";
	          htmlText += "<tr>";
	          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
	          		" <strong>Total OD</strong> </p> </td>";
	          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
	          		" "+total_OD+"</p> </td>";
	          htmlText += "</tr>";
	          htmlText += "<tr>";
	          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
	          		" <strong>Purpose</strong> </p> </td>";
	          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
	          		" "+purpose+"</p> </td>";
	          htmlText += "</tr>";
	          htmlText += "<tr>";
	          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
	          		" <strong>Status</strong> </p> </td>";
	          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
	          		""+status+"</p></td>";
	          htmlText += "</tr>";
	          
	          if(reason != ""){
	          htmlText += "<tr>";
	          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
	          		" <strong>Reason</strong> </p> </td>";
	          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
	          		""+reason+"</p></td>";
	          htmlText += "</tr>";
	          }
	          
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
	          htmlText += "<table cellpadding=\"20\" cellspacing=\"0\" border=\"0\" width=\"100%\">";
	          htmlText += "<tbody>";
	          htmlText += "<tr>";
	          htmlText += "<td>";
	          htmlText += "<p style=\"font-size: 13px; padding: 0px; margin: 0px; padding-left: 5px; line-height: 20px; color: #121212; text-align: center\">For Login into HRMS <a href=\"http://192.168.182.58:6018/HRMS/\"><button style=\" background-color: white; color: black; border: 2px solid #337ab7;\">Login</button></a> </p>";
	          htmlText += "<br>";
	          htmlText += "<p align=\"center\" style=\"font-size: 11px; padding: 0px; margin: 0px; line-height: 13px; color: red; padding-bottom: 10px\"><b>Note : This button will work only when you are connected to SLTL Intranet.</b></p>";
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
	          htmlText += "<td><p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 13px; color: #121212; line-height: 20px; padding-bottom: 10px\"> For any queries or concerns, contact us on <b>313</b>.</p></td>";
	          htmlText += "</tr>";
	          htmlText += "<tr>";
	          htmlText += "<td>";
	          htmlText += "<p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 13px; color: #121212; line-height: 20px\"> Regards,<br> Team HRMS </p>";
	          htmlText += "<br><p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 11px; color: #333; line-height: 20px; font-style: italic\">* This is an automated e-mail alert to help you to know about your OD. Hence, Please do not reply to this e-mail.</p>";
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
	          
	        /* String htmlText = type+"<br>"+query+"<br>"+code;*/
	        //  htmlText += "<br><br><br>";
	        // htmlText += "<img src=\"cid:image\"><br><b>"+body+"</b><br><b>"+body1+"</b><br><b>"+body2+"</b><br><b>"+body3+"</b><br><b>"+body4+"</b>";
	         messageBodyPart.setContent(htmlText, "text/html");
	         // add it
	         multipart.addBodyPart(messageBodyPart);

	         // second part (the image)
	         messageBodyPart = new MimeBodyPart();
	         DataSource fds = new FileDataSource(
	            "D:/hrms/upload/img/sltllogo.png");

	         messageBodyPart.setDataHandler(new DataHandler(fds));
	         messageBodyPart.setHeader("Content-ID", "<image>");

	         // add image to the multipart
	         multipart.addBodyPart(messageBodyPart);
	         
	        
	         message.setContent(multipart);
	         
			// 3rd step)send message
			Transport.send(message);

			System.out.println("Done : "+to);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		
		
	 
 }

	
	public static void pendingCancelLeaveType1(String to, String subject, String leavefrom, String leaveto, double days, int emp_code, String mobileNo, String name, String reasonForCancellation ) {    //Leave Cancellation Mail Type 1 send
	
	
		// Sender's email ID needs to be mentioned
	     String from = "hrms@sltl.com";
	     String pass ="hrms#123";
	    // Recipient's email ID needs to be mentioned.
	   String host = "smtp.gmail.com";
	   
	   System.out.println("akash");
	   
	   
	// 1st step) Get the session object
			Properties props = new Properties();
			// props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.setProperty("mail.transport.protocol", "smtps");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.auth", "true");
			
			
			   
			   
			   
		props.put("mail.smtp.socketFactory.port", "587");  
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.socketFactory.class", "javax.net.SocketFactory");
		props.put("mail.smtp.ssl.enable", "false");
		props.put("mail.smtp.ssl.trust", host);
			   

			Session session = Session.getInstance(props, new javax.mail.Authenticator() {
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
			String link = "http://192.168.182.58:6018/HRMS/";
	        
			try {
				MimeMessage message = new MimeMessage(session);
				message.setFrom(new InternetAddress(from));// From Address
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));// To
				
				message.setSubject(subject);// MSG Subject
				// This mail has 2 part, the BODY and the embedded image
		         MimeMultipart multipart = new MimeMultipart("related");

		         // first part (the html)
		         BodyPart messageBodyPart = new MimeBodyPart();
		         BodyPart messageBodyPart1 = new MimeBodyPart();
		         
		         /**/
		         
		          String  htmlText = "<html>";
		          
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
		          htmlText += "<td align=\"right\"><img src=\"https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcQjJkNWrO_pXGhZoAvyStzhRr70iS-ZdCO7JUoQivdyMWqbV0HtLQ\"\r\n" + 
		          		"								height=\"40px\" width=\"40px\"\r\n" + 
		          		"								class=\"CToWUd\"></td>";
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
		          htmlText += "<td><div class=\"a6S\" dir=\"ltr\" style=\"opacity: 0.01; left: 521.5px; top: 236px;\"> <div id=\":13q\" class=\"T-I J-J5-Ji aQv T-I-ax7 L3 a5q\"" + 
		          		"role=\"button\" tabindex=\"0\" aria-label=\"Download attachment \" data-tooltip-class=\"a1V\" data-tooltip=\"Download\"> <div class=\"aSK J-J5-Ji aYr\"></div>" + 
		          		"</div> </div></td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td>";
		          htmlText += "<table cellpadding=\"15\" cellspacing=\"0\" border=\"0\" width=\"100%\">";
		          htmlText += "<tbody>";
		          htmlText += "<tr>";
		          htmlText += "<td> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 13px; color: #121212; line-height: 18px; padding-bottom: 10px\">" + 
		          		" Respected Sir / Ma'am,</p> "
		          		+ "<p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 13px; color: #121212; line-height: 18px\">" + 
		          		" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Your Reporting Employee <b>"+name+"</b> Requested For Cancel Leave.</p>";
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
		          
		          htmlText += " <tr><td><img src=\"http://www.letk.ee/img/document.png\" style=\"color: black;\" height=\"20px\" width=\"20px\" class=\"CToWUd\"><b>&nbsp; Leave Detail </b><hr>"
			          		+ "</td> </tr>";
		          
		          htmlText += "<tr>";
		          htmlText += "<td>";
		          htmlText += "<table cellpadding=\"10\" cellspacing=\"0\" border=\"0\" width=\"100%\" style=\"border: solid #f4f4f4 1px\">";
		          htmlText += "<tbody>";
		          htmlText += "<tr>";
		          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">" + 
		          		" <strong>Employee Code </strong> </p> </td>";
		          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 14px; color: #121212; line-height: 13px\">"+emp_code+"</p></td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		"<strong>From Date</strong> </p> </td>";
		          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		""+leavefrom+"</p> </td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" <strong>To Date</strong> </p> </td>";
		          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" "+leaveto+"</p> </td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" <strong>Total Days</strong> </p> </td>";
		          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" "+days+"</p> </td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" <strong>Reason</strong> </p> </td>";
		          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		""+reasonForCancellation+"</p></td>";
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
		          htmlText += "<table cellpadding=\"20\" cellspacing=\"0\" border=\"0\" width=\"100%\">";
		          htmlText += "<tbody>";
		          htmlText += "<tr>";
		          htmlText += "<td>";
		          
		         /* 
		          htmlText += "<p align=\"center\" style=\"font-size: 13px; padding: 0px; margin: 0px; line-height: 20px; color: #121212;\"> For Approve Or Reject This Leave <a href=\"http://192.168.182.58:6018/HRMS/ByEmailLeaveApproveReject.jsp?leave_id="+leave_id+"\"><button style=\" background-color: white; color: black; border: 2px solid #337ab7;\">Click here</button></a></p>";
		          htmlText += "<br>";
		          htmlText += "<p align=\"center\" style=\"font-size: 13px; padding: 0px; margin: 0px; line-height: 13px; color: #121212; padding-bottom: 10px\">\r\n" + 
		          		" <span style=\"font-size: 14px\">OR</span></p>";*/
		          
		          
		          htmlText += "<p style=\"font-size: 13px; padding: 0px; margin: 0px; padding-left: 5px; line-height: 20px; color: #121212; text-align: center\">For Login into HRMS <a href=\"http://192.168.182.58:6018/HRMS/\"><button style=\" background-color: white; color: black; border: 2px solid #337ab7;\">Login</button></a> </p>";
		          htmlText += "<br>";
		          htmlText += "<p align=\"center\" style=\"font-size: 11px; padding: 0px; margin: 0px; line-height: 13px; color: red; padding-bottom: 10px\"><b>Note : This button will work only when you are connected to SLTL Intranet.</b></p>";
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
		          htmlText += "<td><p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 13px; color: #121212; line-height: 20px; padding-bottom: 10px\"> For any queries or concerns, contact us on <b>313</b>.</p></td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td>";
		          htmlText += "<p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 13px; color: #121212; line-height: 20px\"> Regards,<br> Team HRMS </p>";
		          htmlText += "<br><p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 11px; color: #333; line-height: 20px; font-style: italic\">* This is an automated e-mail alert to help you to know about leave of employee who Report You. Hence, Please do not reply to this e-mail.</p>";
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
		          
		        /* String htmlText = type+"<br>"+query+"<br>"+code;*/
		          //htmlText += "<br><br><br>";
		        //  htmlText += "<img src=\"cid:image\"><br><b>"+body+"</b><br><b>"+body1+"</b><br><b>"+body2+"</b><br><b>"+body3+"</b><br><b>"+body4+"</b>";
		         messageBodyPart.setContent(htmlText, "text/html");
		         // add it
		         multipart.addBodyPart(messageBodyPart);

		         // second part (the image)
		         messageBodyPart = new MimeBodyPart();
		         DataSource fds = new FileDataSource(
		            "D:/hrms/upload/img/sltllogo.png");

		         messageBodyPart.setDataHandler(new DataHandler(fds));
		         messageBodyPart.setHeader("Content-ID", "<image>");

		         // add image to the multipart
		         multipart.addBodyPart(messageBodyPart);
		         
		        
		         message.setContent(multipart);
		         
				// 3rd step)send message
				Transport.send(message);

				System.out.println("Done : "+to);

			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
	
	
	
	
	}
	
	
	public static void pendingCancelLeaveType2(String to, String subject, String leavefrom, String leaveto, double days, int emp_code, String mobileNo, String name, String update_leave_from, String update_leave_to, double updatedDays, String reasonForCancellation) {    //Leave Cancellation(Updation) Mail Type 2 Send
		
		
		// Sender's email ID needs to be mentioned
	     String from = "hrms@sltl.com";
	     String pass ="hrms#123";
	    // Recipient's email ID needs to be mentioned.
	   String host = "smtp.gmail.com";
	   
	   System.out.println("akash");
	   
	   
	// 1st step) Get the session object
			Properties props = new Properties();
			// props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.setProperty("mail.transport.protocol", "smtps");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.auth", "true");
			
			
			   
			   
			   
		props.put("mail.smtp.socketFactory.port", "587");  
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.socketFactory.class", "javax.net.SocketFactory");
		props.put("mail.smtp.ssl.enable", "false");
		props.put("mail.smtp.ssl.trust", host);
			   

			Session session = Session.getInstance(props, new javax.mail.Authenticator() {
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
			String link = "http://192.168.182.58:6018/HRMS/";
	        
			try {
				MimeMessage message = new MimeMessage(session);
				message.setFrom(new InternetAddress(from));// From Address
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));// To
				
				message.setSubject(subject);// MSG Subject
				// This mail has 2 part, the BODY and the embedded image
		         MimeMultipart multipart = new MimeMultipart("related");

		         // first part (the html)
		         BodyPart messageBodyPart = new MimeBodyPart();
		         BodyPart messageBodyPart1 = new MimeBodyPart();
		         
		         /**/
		         
		          String  htmlText = "<html>";
		          
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
		          htmlText += "<td align=\"right\"><img src=\"https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcQjJkNWrO_pXGhZoAvyStzhRr70iS-ZdCO7JUoQivdyMWqbV0HtLQ\"\r\n" + 
		          		"								height=\"40px\" width=\"40px\"\r\n" + 
		          		"								class=\"CToWUd\"></td>";
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
		          htmlText += "<td><div class=\"a6S\" dir=\"ltr\" style=\"opacity: 0.01; left: 521.5px; top: 236px;\"> <div id=\":13q\" class=\"T-I J-J5-Ji aQv T-I-ax7 L3 a5q\"" + 
		          		"role=\"button\" tabindex=\"0\" aria-label=\"Download attachment \" data-tooltip-class=\"a1V\" data-tooltip=\"Download\"> <div class=\"aSK J-J5-Ji aYr\"></div>" + 
		          		"</div> </div></td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td>";
		          htmlText += "<table cellpadding=\"15\" cellspacing=\"0\" border=\"0\" width=\"100%\">";
		          htmlText += "<tbody>";
		          htmlText += "<tr>";
		          htmlText += "<td> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 13px; color: #121212; line-height: 18px; padding-bottom: 10px\">" + 
		          		" Respected Sir / Ma'am,</p> "
		          		+ "<p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 13px; color: #121212; line-height: 18px\">" + 
		          		" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Your Reporting Employee <b>"+name+"</b> Requested For Leave Update.</p>";
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
		          
		          htmlText += " <tr><td><img src=\"http://www.letk.ee/img/document.png\" style=\"color: black;\" height=\"20px\" width=\"20px\" class=\"CToWUd\"><b>&nbsp; Leave Detail </b><hr>"
			          		+ "</td> </tr>";
		          
		          htmlText += "<tr>";
		          htmlText += "<td>";
		          htmlText += "<table cellpadding=\"10\" cellspacing=\"0\" border=\"0\" width=\"100%\" style=\"border: solid #f4f4f4 1px\">";
		          htmlText += "<tbody>";
		          htmlText += "<tr>";
		          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">" + 
		          		" <strong>Employee Code </strong> </p> </td>";
		          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 14px; color: #121212; line-height: 13px\">"+emp_code+"</p></td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		"<strong>Past Dates</strong> </p> </td>";
		          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		""+leavefrom+"<b> To </b>"+leaveto+" <b>("+days+" Days)</b> </p> </td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" <strong>Updated Dates</strong> </p> </td>";
		          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" "+update_leave_from+" <b> To </b> "+update_leave_to+" <b>("+updatedDays+" Days)</b> </p> </td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" <strong>Reason</strong> </p> </td>";
		          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		""+reasonForCancellation+"</p></td>";
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
		          htmlText += "<table cellpadding=\"20\" cellspacing=\"0\" border=\"0\" width=\"100%\">";
		          htmlText += "<tbody>";
		          htmlText += "<tr>";
		          htmlText += "<td>";
		          
		         /* 
		          htmlText += "<p align=\"center\" style=\"font-size: 13px; padding: 0px; margin: 0px; line-height: 20px; color: #121212;\"> For Approve Or Reject This Leave <a href=\"http://192.168.182.58:6018/HRMS/ByEmailLeaveApproveReject.jsp?leave_id="+leave_id+"\"><button style=\" background-color: white; color: black; border: 2px solid #337ab7;\">Click here</button></a></p>";
		          htmlText += "<br>";
		          htmlText += "<p align=\"center\" style=\"font-size: 13px; padding: 0px; margin: 0px; line-height: 13px; color: #121212; padding-bottom: 10px\">\r\n" + 
		          		" <span style=\"font-size: 14px\">OR</span></p>";*/
		          
		          
		          htmlText += "<p style=\"font-size: 13px; padding: 0px; margin: 0px; padding-left: 5px; line-height: 20px; color: #121212; text-align: center\">For Login into HRMS <a href=\"http://192.168.182.58:6018/HRMS/\"><button style=\" background-color: white; color: black; border: 2px solid #337ab7;\">Login</button></a> </p>";
		          htmlText += "<br>";
		          htmlText += "<p align=\"center\" style=\"font-size: 11px; padding: 0px; margin: 0px; line-height: 13px; color: red; padding-bottom: 10px\"><b>Note : This button will work only when you are connected to SLTL Intranet.</b></p>";
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
		          htmlText += "<td><p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 13px; color: #121212; line-height: 20px; padding-bottom: 10px\"> For any queries or concerns, contact us on <b>313</b>.</p></td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td>";
		          htmlText += "<p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 13px; color: #121212; line-height: 20px\"> Regards,<br> Team HRMS </p>";
		          htmlText += "<br><p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 11px; color: #333; line-height: 20px; font-style: italic\">* This is an automated e-mail alert to help you to know about leave of employee who Report You. Hence, Please do not reply to this e-mail.</p>";
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
		          
		        /* String htmlText = type+"<br>"+query+"<br>"+code;*/
		          //htmlText += "<br><br><br>";
		        //  htmlText += "<img src=\"cid:image\"><br><b>"+body+"</b><br><b>"+body1+"</b><br><b>"+body2+"</b><br><b>"+body3+"</b><br><b>"+body4+"</b>";
		         messageBodyPart.setContent(htmlText, "text/html");
		         // add it
		         multipart.addBodyPart(messageBodyPart);

		         // second part (the image)
		         messageBodyPart = new MimeBodyPart();
		         DataSource fds = new FileDataSource(
		            "D:/hrms/upload/img/sltllogo.png");

		         messageBodyPart.setDataHandler(new DataHandler(fds));
		         messageBodyPart.setHeader("Content-ID", "<image>");

		         // add image to the multipart
		         multipart.addBodyPart(messageBodyPart);
		         
		        
		         message.setContent(multipart);
		         
				// 3rd step)send message
				Transport.send(message);

				System.out.println("Done : "+to);

			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
	
	
	
	
	}
	
	
	
	public static void approveRejectCancelLeaveType1(String to, String subject, String leavefrom ,String leaveto,double days, int emp_code, String mobileNo, String name, String status) {      // Leave Approve Reject Mail For Cancellation
		
		// Sender's email ID needs to be mentioned
	     String from = "hrms@sltl.com";
	     String pass ="hrms#123";
	    // Recipient's email ID needs to be mentioned.
	   String host = "smtp.gmail.com";
	   
	   
	   
	   
	// 1st step) Get the session object
				Properties props = new Properties();
				// props.put("mail.smtp.starttls.enable", "true");
				
				props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
				
				props.setProperty("mail.transport.protocol", "smtps");
				props.put("mail.smtp.starttls.enable", "true");
				props.put("mail.smtp.host", host);
				props.put("mail.smtp.port", "587");
				props.put("mail.smtp.auth", "true");
				   
				   
				   
				props.put("mail.smtp.socketFactory.port", "587");  
				props.put("mail.smtp.starttls.enable", "true");
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
			String link = "http://192.168.182.58:6018/HRMS/";
			
			try {
				MimeMessage message = new MimeMessage(session);
				message.setFrom(new InternetAddress(from));// From Address
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));// To
				
				message.setSubject(subject);// MSG Subject
				// This mail has 2 part, the BODY and the embedded image
		         MimeMultipart multipart = new MimeMultipart("related");

		         // first part (the html)
		         BodyPart messageBodyPart = new MimeBodyPart();
		         BodyPart messageBodyPart1 = new MimeBodyPart();
		         
		         /**/
		         
		         String  htmlText = "<html>";
		          
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
		          htmlText += "<td align=\"right\"><img src=\"https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcQjJkNWrO_pXGhZoAvyStzhRr70iS-ZdCO7JUoQivdyMWqbV0HtLQ\"\r\n" + 
		          		"								height=\"40px\" width=\"40px\"\r\n" + 
		          		"								class=\"CToWUd\"></td>";
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
		          htmlText += "<td><div class=\"a6S\" dir=\"ltr\" style=\"opacity: 0.01; left: 521.5px; top: 236px;\"> <div id=\":13q\" class=\"T-I J-J5-Ji aQv T-I-ax7 L3 a5q\"" + 
		          		"role=\"button\" tabindex=\"0\" aria-label=\"Download attachment \" data-tooltip-class=\"a1V\" data-tooltip=\"Download\"> <div class=\"aSK J-J5-Ji aYr\"></div>" + 
		          		"</div> </div></td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td>";
		          htmlText += "<table cellpadding=\"15\" cellspacing=\"0\" border=\"0\" width=\"100%\">";
		          htmlText += "<tbody>";
		          htmlText += "<tr>";
		          htmlText += "<td> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 13px; color: #121212; line-height: 18px; padding-bottom: 10px\">" + 
		          		" Dear "+name+", </p> "
		          		+ "<p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 13px; color: #121212; line-height: 18px\">" + 
		          		"  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Your Request For Leave Cancellation is <b>"+status+"</b> .</p>";
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
		          
		          htmlText += " <tr><td><img src=\"http://www.letk.ee/img/document.png\" style=\"color: black;\" height=\"20px\" width=\"20px\" class=\"CToWUd\"><b>&nbsp; Leave Detail </b><hr>"
			          		+ "</td> </tr>";
		          
		          htmlText += "<tr>";
		          htmlText += "<td>";
		          htmlText += "<table cellpadding=\"10\" cellspacing=\"0\" border=\"0\" width=\"100%\" style=\"border: solid #f4f4f4 1px\">";
		          htmlText += "<tbody>";
		          htmlText += "<tr>";
		          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">" + 
		          		" <strong>Employee Code </strong> </p> </td>";
		          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 14px; color: #121212; line-height: 13px\">"+emp_code+"</p></td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		"<strong>From Date</strong> </p> </td>";
		          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		""+leavefrom+"</p> </td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" <strong>To Date</strong> </p> </td>";
		          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" "+leaveto+"</p> </td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" <strong>Total Days</strong> </p> </td>";
		          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" "+days+"</p> </td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" <strong>Status</strong> </p> </td>";
		          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		""+status+"</p></td>";
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
		          htmlText += "<table cellpadding=\"20\" cellspacing=\"0\" border=\"0\" width=\"100%\">";
		          htmlText += "<tbody>";
		          htmlText += "<tr>";
		          htmlText += "<td>";
		          
		         /* 
		          htmlText += "<p align=\"center\" style=\"font-size: 13px; padding: 0px; margin: 0px; line-height: 20px; color: #121212;\"> For Approve Or Reject This Leave <a href=\"http://192.168.182.58:6018/HRMS/ByEmailLeaveApproveReject.jsp?leave_id="+leave_id+"\"><button style=\" background-color: white; color: black; border: 2px solid #337ab7;\">Click here</button></a></p>";
		          htmlText += "<br>";
		          htmlText += "<p align=\"center\" style=\"font-size: 13px; padding: 0px; margin: 0px; line-height: 13px; color: #121212; padding-bottom: 10px\">\r\n" + 
		          		" <span style=\"font-size: 14px\">OR</span></p>";*/
		          
		          
		          htmlText += "<p style=\"font-size: 13px; padding: 0px; margin: 0px; padding-left: 5px; line-height: 20px; color: #121212; text-align: center\">For Login into HRMS <a href=\"http://192.168.182.58:6018/HRMS/\"><button style=\" background-color: white; color: black; border: 2px solid #337ab7;\">Login</button></a> </p>";
		          htmlText += "<br>";
		          htmlText += "<p align=\"center\" style=\"font-size: 11px; padding: 0px; margin: 0px; line-height: 13px; color: red; padding-bottom: 10px\"><b>Note : This button will work only when you are connected to SLTL Intranet.</b></p>";
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
		          htmlText += "<td><p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 13px; color: #121212; line-height: 20px; padding-bottom: 10px\"> For any queries or concerns, contact us on <b>313</b>.</p></td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td>";
		          htmlText += "<p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 13px; color: #121212; line-height: 20px\"> Regards,<br> Team HRMS </p>";
		          htmlText += "<br><p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 11px; color: #333; line-height: 20px; font-style: italic\">* This is an automated e-mail alert to help you to know about your leave. Hence, Please do not reply to this e-mail.</p>";
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
		          
		        /* String htmlText = type+"<br>"+query+"<br>"+code;*/
		        //  htmlText += "<br><br><br>";
		        // htmlText += "<img src=\"cid:image\"><br><b>"+body+"</b><br><b>"+body1+"</b><br><b>"+body2+"</b><br><b>"+body3+"</b><br><b>"+body4+"</b>";
		         messageBodyPart.setContent(htmlText, "text/html");
		         // add it
		         multipart.addBodyPart(messageBodyPart);

		         // second part (the image)
		         messageBodyPart = new MimeBodyPart();
		         DataSource fds = new FileDataSource(
		            "D:/hrms/upload/img/sltllogo.png");

		         messageBodyPart.setDataHandler(new DataHandler(fds));
		         messageBodyPart.setHeader("Content-ID", "<image>");

		         // add image to the multipart
		         multipart.addBodyPart(messageBodyPart);
		         
		        
		         message.setContent(multipart);
		         
				// 3rd step)send message
				Transport.send(message);

				System.out.println("Done : "+to);

			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
			
			
		 
	 }
	
	
	
	
public static void approveRejectCancelLeaveType2(String to, String subject, String leavefrom, String leaveto, double days, int emp_code, String mobileNo, String name, String update_leave_from, String update_leave_to, double updatedDays, String status) {    //Leave Approve Reject Mail For Updation
		
		
		// Sender's email ID needs to be mentioned
	     String from = "hrms@sltl.com";
	     String pass ="hrms#123";
	    // Recipient's email ID needs to be mentioned.
	   String host = "smtp.gmail.com";
	   
	   System.out.println("akash");
	   
	   
	// 1st step) Get the session object
			Properties props = new Properties();
			// props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.setProperty("mail.transport.protocol", "smtps");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.auth", "true");
			
			
			   
			   
			   
		props.put("mail.smtp.socketFactory.port", "587");  
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.socketFactory.class", "javax.net.SocketFactory");
		props.put("mail.smtp.ssl.enable", "false");
		props.put("mail.smtp.ssl.trust", host);
			   

			Session session = Session.getInstance(props, new javax.mail.Authenticator() {
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
			String link = "http://192.168.182.58:6018/HRMS/";
	        
			try {
				MimeMessage message = new MimeMessage(session);
				message.setFrom(new InternetAddress(from));// From Address
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));// To
				
				message.setSubject(subject);// MSG Subject
				// This mail has 2 part, the BODY and the embedded image
		         MimeMultipart multipart = new MimeMultipart("related");

		         // first part (the html)
		         BodyPart messageBodyPart = new MimeBodyPart();
		         BodyPart messageBodyPart1 = new MimeBodyPart();
		         
		         /**/
		         
		          String  htmlText = "<html>";
		          
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
		          htmlText += "<td align=\"right\"><img src=\"https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcQjJkNWrO_pXGhZoAvyStzhRr70iS-ZdCO7JUoQivdyMWqbV0HtLQ\"\r\n" + 
		          		"								height=\"40px\" width=\"40px\"\r\n" + 
		          		"								class=\"CToWUd\"></td>";
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
		          htmlText += "<td><div class=\"a6S\" dir=\"ltr\" style=\"opacity: 0.01; left: 521.5px; top: 236px;\"> <div id=\":13q\" class=\"T-I J-J5-Ji aQv T-I-ax7 L3 a5q\"" + 
		          		"role=\"button\" tabindex=\"0\" aria-label=\"Download attachment \" data-tooltip-class=\"a1V\" data-tooltip=\"Download\"> <div class=\"aSK J-J5-Ji aYr\"></div>" + 
		          		"</div> </div></td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td>";
		          htmlText += "<table cellpadding=\"15\" cellspacing=\"0\" border=\"0\" width=\"100%\">";
		          htmlText += "<tbody>";
		          htmlText += "<tr>";
		          htmlText += "<td> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 13px; color: #121212; line-height: 18px; padding-bottom: 10px\">" + 
		          		" Dear "+name+", </p> "
		          		+ "<p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 13px; color: #121212; line-height: 18px\">" + 
		          		"  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Your Request For Leave Update is <b>"+status+"</b> .</p>";
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
		          
		          htmlText += " <tr><td><img src=\"http://www.letk.ee/img/document.png\" style=\"color: black;\" height=\"20px\" width=\"20px\" class=\"CToWUd\"><b>&nbsp; Leave Detail </b><hr>"
			          		+ "</td> </tr>";
		          
		          htmlText += "<tr>";
		          htmlText += "<td>";
		          htmlText += "<table cellpadding=\"10\" cellspacing=\"0\" border=\"0\" width=\"100%\" style=\"border: solid #f4f4f4 1px\">";
		          htmlText += "<tbody>";
		          htmlText += "<tr>";
		          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">" + 
		          		" <strong>Employee Code </strong> </p> </td>";
		          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 14px; color: #121212; line-height: 13px\">"+emp_code+"</p></td>";
		          htmlText += "</tr>";
		          
		          if(status.equalsIgnoreCase("rejected")){
		        	  
		          htmlText += "<tr>";
		          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		"<strong>Past Dates</strong> </p> </td>";
		          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		""+leavefrom+"<b> To </b>"+leaveto+" <b>("+days+" Days)</b> </p> </td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" <strong>Updated Dates</strong> </p> </td>";
		          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" "+update_leave_from+"<b> To </b>"+update_leave_to+" <b>("+updatedDays+" Days)</b> </p> </td>";
		          htmlText += "</tr>";
		          
		          }else if(status.equalsIgnoreCase("approved")){
		        	  
		        	  htmlText += "<tr>";
			          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
			          		" <strong>Past Dates</strong> </p> </td>";
			          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
			          		" "+update_leave_from+"<b> To </b>"+update_leave_to+" <b>("+updatedDays+" Days)</b> </p> </td>";
			          htmlText += "</tr>";
		        	  htmlText += "<tr>";
			          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
			          		"<strong>Updated Dates</strong> </p> </td>";
			          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
			          		""+leavefrom+"<b> To </b>"+leaveto+" <b>("+days+" Days)</b> </p> </td>";
			          htmlText += "</tr>";
		        	  
		          }
		          
		          
		          htmlText += "<tr>";
		          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" <strong>Status</strong> </p> </td>";
		          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		""+status+"</p></td>";
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
		          htmlText += "<table cellpadding=\"20\" cellspacing=\"0\" border=\"0\" width=\"100%\">";
		          htmlText += "<tbody>";
		          htmlText += "<tr>";
		          htmlText += "<td>";
		          
		         /* 
		          htmlText += "<p align=\"center\" style=\"font-size: 13px; padding: 0px; margin: 0px; line-height: 20px; color: #121212;\"> For Approve Or Reject This Leave <a href=\"http://192.168.182.58:6018/HRMS/ByEmailLeaveApproveReject.jsp?leave_id="+leave_id+"\"><button style=\" background-color: white; color: black; border: 2px solid #337ab7;\">Click here</button></a></p>";
		          htmlText += "<br>";
		          htmlText += "<p align=\"center\" style=\"font-size: 13px; padding: 0px; margin: 0px; line-height: 13px; color: #121212; padding-bottom: 10px\">\r\n" + 
		          		" <span style=\"font-size: 14px\">OR</span></p>";*/
		          
		          
		          htmlText += "<p style=\"font-size: 13px; padding: 0px; margin: 0px; padding-left: 5px; line-height: 20px; color: #121212; text-align: center\">For Login into HRMS <a href=\"http://192.168.182.58:6018/HRMS/\"><button style=\" background-color: white; color: black; border: 2px solid #337ab7;\">Login</button></a> </p>";
		          htmlText += "<br>";
		          htmlText += "<p align=\"center\" style=\"font-size: 11px; padding: 0px; margin: 0px; line-height: 13px; color: red; padding-bottom: 10px\"><b>Note : This button will work only when you are connected to SLTL Intranet.</b></p>";
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
		          htmlText += "<td><p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 13px; color: #121212; line-height: 20px; padding-bottom: 10px\"> For any queries or concerns, contact us on <b>313</b>.</p></td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td>";
		          htmlText += "<p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 13px; color: #121212; line-height: 20px\"> Regards,<br> Team HRMS </p>";
		          htmlText += "<br><p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 11px; color: #333; line-height: 20px; font-style: italic\">* This is an automated e-mail alert to help you to know about your leave. Hence, Please do not reply to this e-mail.</p>";
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
		          
		        /* String htmlText = type+"<br>"+query+"<br>"+code;*/
		          //htmlText += "<br><br><br>";
		        //  htmlText += "<img src=\"cid:image\"><br><b>"+body+"</b><br><b>"+body1+"</b><br><b>"+body2+"</b><br><b>"+body3+"</b><br><b>"+body4+"</b>";
		         messageBodyPart.setContent(htmlText, "text/html");
		         // add it
		         multipart.addBodyPart(messageBodyPart);

		         // second part (the image)
		         messageBodyPart = new MimeBodyPart();
		         DataSource fds = new FileDataSource(
		            "D:/hrms/upload/img/sltllogo.png");

		         messageBodyPart.setDataHandler(new DataHandler(fds));
		         messageBodyPart.setHeader("Content-ID", "<image>");

		         // add image to the multipart
		         multipart.addBodyPart(messageBodyPart);
		         
		        
		         message.setContent(multipart);
		         
				// 3rd step)send message
				Transport.send(message);

				System.out.println("Done : "+to);

			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
	
	
	
	
	}
	
	
	
	
	public static void otpSend(String to, String subject, int otp ) {      // OTP mail
		 
		// Sender's email ID needs to be mentioned
	     String from = "hrms@sltl.com";
	     String pass ="hrms#123";
	    // Recipient's email ID needs to be mentioned.
	   String host = "smtp.gmail.com";
	   
	   
	   
	   
	// 1st step) Get the session object
			Properties props = new Properties();
			// props.put("mail.smtp.starttls.enable", "true");
			
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			
			props.setProperty("mail.transport.protocol", "smtps");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.auth", "true");
			   
			   
			   
			props.put("mail.smtp.socketFactory.port", "587");  
			props.put("mail.smtp.starttls.enable", "true");
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
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));// To
																						// Address
				message.setSubject(subject);// MSG Subject
				// This mail has 2 part, the BODY and the embedded image
		         MimeMultipart multipart = new MimeMultipart("related");

		         // first part (the html)
		         BodyPart messageBodyPart = new MimeBodyPart();
		         BodyPart messageBodyPart1 = new MimeBodyPart();
		         
		         /**/
		         
		          String  htmlText = "Your One Time Password is <b>"+otp+"</b> For change your password";
		          
		          
		          
		        /* String htmlText = type+"<br>"+query+"<br>"+code;*/
		          htmlText += "<br><br><br>";
		          htmlText += "<img src=\"cid:image\"><br><b>"+body+"</b><br><b>"+body1+"</b><br><b>"+body2+"</b><br><b>"+body3+"</b><br><b>"+body4+"</b>";
		         messageBodyPart.setContent(htmlText, "text/html");
		         // add it
		         multipart.addBodyPart(messageBodyPart);

		         // second part (the image)
		         messageBodyPart = new MimeBodyPart();
		         DataSource fds = new FileDataSource(
		            "D:/hrms/upload/img/sltllogo.png");

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
	
	
public static void approveMail(String to, String subject, String leavefrom, String leaveto, double days, int emp_code, String mobileNo, String name, String update_leave_from, String update_leave_to, double updatedDays) {    //Leave Approve mail without approvance
		
		
		// Sender's email ID needs to be mentioned
	     String from = "hrms@sltl.com";
	     String pass ="hrms#123";
	    // Recipient's email ID needs to be mentioned.
	   String host = "smtp.gmail.com";
	   
	   System.out.println("akash");
	   
	   
	// 1st step) Get the session object
			Properties props = new Properties();
			// props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.setProperty("mail.transport.protocol", "smtps");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.auth", "true");
			
			
			   
			   
			   
		props.put("mail.smtp.socketFactory.port", "587");  
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.socketFactory.class", "javax.net.SocketFactory");
		props.put("mail.smtp.ssl.enable", "false");
		props.put("mail.smtp.ssl.trust", host);
			   

			Session session = Session.getInstance(props, new javax.mail.Authenticator() {
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
			String link = "http://192.168.182.58:6018/HRMS/";
	        
			try {
				MimeMessage message = new MimeMessage(session);
				message.setFrom(new InternetAddress(from));// From Address
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));// To
				
				message.setSubject(subject);// MSG Subject
				// This mail has 2 part, the BODY and the embedded image
		         MimeMultipart multipart = new MimeMultipart("related");

		         // first part (the html)
		         BodyPart messageBodyPart = new MimeBodyPart();
		         BodyPart messageBodyPart1 = new MimeBodyPart();
		         
		         /**/
		         
		          String  htmlText = "<html>";
		          
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
		          htmlText += "<td align=\"right\"><img src=\"https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcQjJkNWrO_pXGhZoAvyStzhRr70iS-ZdCO7JUoQivdyMWqbV0HtLQ\"\r\n" + 
		          		"								height=\"40px\" width=\"40px\"\r\n" + 
		          		"								class=\"CToWUd\"></td>";
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
		          htmlText += "<td><div class=\"a6S\" dir=\"ltr\" style=\"opacity: 0.01; left: 521.5px; top: 236px;\"> <div id=\":13q\" class=\"T-I J-J5-Ji aQv T-I-ax7 L3 a5q\"" + 
		          		"role=\"button\" tabindex=\"0\" aria-label=\"Download attachment \" data-tooltip-class=\"a1V\" data-tooltip=\"Download\"> <div class=\"aSK J-J5-Ji aYr\"></div>" + 
		          		"</div> </div></td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td>";
		          htmlText += "<table cellpadding=\"15\" cellspacing=\"0\" border=\"0\" width=\"100%\">";
		          htmlText += "<tbody>";
		          htmlText += "<tr>";
		          htmlText += "<td> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 13px; color: #121212; line-height: 18px; padding-bottom: 10px\">" + 
		          		" Respected Sir / Ma'am,</p> "
		          		+ "<p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 13px; color: #121212; line-height: 18px\">" + 
		          		" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Your Reporting Employee <b>"+name+"</b> Update his/her leave.</p>";
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
		          
		          htmlText += " <tr><td><img src=\"http://www.letk.ee/img/document.png\" style=\"color: black;\" height=\"20px\" width=\"20px\" class=\"CToWUd\"><b>&nbsp; Leave Detail </b><hr>"
			          		+ "</td> </tr>";
		          
		          htmlText += "<tr>";
		          htmlText += "<td>";
		          htmlText += "<table cellpadding=\"10\" cellspacing=\"0\" border=\"0\" width=\"100%\" style=\"border: solid #f4f4f4 1px\">";
		          htmlText += "<tbody>";
		          htmlText += "<tr>";
		          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">" + 
		          		" <strong>Employee Code </strong> </p> </td>";
		          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 14px; color: #121212; line-height: 13px\">"+emp_code+"</p></td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		"<strong>Past Dates</strong> </p> </td>";
		          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		""+leavefrom+"<b> To </b>"+leaveto+" <b>("+days+" Days)</b> </p> </td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" <strong>Updated Dates</strong> </p> </td>";
		          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" "+update_leave_from+" <b> To </b> "+update_leave_to+" <b>("+updatedDays+" Days)</b> </p> </td>";
		          htmlText += "</tr>";
		          
		          htmlText += "<tr>";
		          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" <strong>Mobile No</strong> </p> </td>";
		          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" "+mobileNo+" </p> </td>";
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
		          htmlText += "<table cellpadding=\"20\" cellspacing=\"0\" border=\"0\" width=\"100%\">";
		          htmlText += "<tbody>";
		          htmlText += "<tr>";
		          htmlText += "<td>";
		          
		         /* 
		          htmlText += "<p align=\"center\" style=\"font-size: 13px; padding: 0px; margin: 0px; line-height: 20px; color: #121212;\"> For Approve Or Reject This Leave <a href=\"http://192.168.182.58:6018/HRMS/ByEmailLeaveApproveReject.jsp?leave_id="+leave_id+"\"><button style=\" background-color: white; color: black; border: 2px solid #337ab7;\">Click here</button></a></p>";
		          htmlText += "<br>";
		          htmlText += "<p align=\"center\" style=\"font-size: 13px; padding: 0px; margin: 0px; line-height: 13px; color: #121212; padding-bottom: 10px\">\r\n" + 
		          		" <span style=\"font-size: 14px\">OR</span></p>";*/
		          
		          
		          htmlText += "<p style=\"font-size: 13px; padding: 0px; margin: 0px; padding-left: 5px; line-height: 20px; color: #121212; text-align: center\">For Login into HRMS <a href=\"http://192.168.182.58:6018/HRMS/\"><button style=\" background-color: white; color: black; border: 2px solid #337ab7;\">Login</button></a> </p>";
		          htmlText += "<br>";
		          htmlText += "<p align=\"center\" style=\"font-size: 11px; padding: 0px; margin: 0px; line-height: 13px; color: red; padding-bottom: 10px\"><b>Note : This button will work only when you are connected to SLTL Intranet.</b></p>";
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
		          htmlText += "<td><p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 13px; color: #121212; line-height: 20px; padding-bottom: 10px\"> For any queries or concerns, contact us on <b>313</b>.</p></td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td>";
		          htmlText += "<p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 13px; color: #121212; line-height: 20px\"> Regards,<br> Team HRMS </p>";
		          htmlText += "<br><p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 11px; color: #333; line-height: 20px; font-style: italic\">* This is an automated e-mail alert to help you to know about leave of employee who Report You. Hence, Please do not reply to this e-mail.</p>";
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
		          
		        /* String htmlText = type+"<br>"+query+"<br>"+code;*/
		          //htmlText += "<br><br><br>";
		        //  htmlText += "<img src=\"cid:image\"><br><b>"+body+"</b><br><b>"+body1+"</b><br><b>"+body2+"</b><br><b>"+body3+"</b><br><b>"+body4+"</b>";
		         messageBodyPart.setContent(htmlText, "text/html");
		         // add it
		         multipart.addBodyPart(messageBodyPart);

		         // second part (the image)
		         messageBodyPart = new MimeBodyPart();
		         DataSource fds = new FileDataSource(
		            "D:/hrms/upload/img/sltllogo.png");

		         messageBodyPart.setDataHandler(new DataHandler(fds));
		         messageBodyPart.setHeader("Content-ID", "<image>");

		         // add image to the multipart
		         multipart.addBodyPart(messageBodyPart);
		         
		        
		         message.setContent(multipart);
		         
				// 3rd step)send message
				Transport.send(message);

				System.out.println("Done : "+to);

			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
	
	
	
	
	}


	
	public static void timeSheetInsertMail(String to, String subject, String date ,String name,String manager_name, int emp_code, double sumOfWorkHours,String fileNameWithPath) {      // Timesheet Insert Mail 
		 
		// Sender's email ID needs to be mentioned
	     String from = "hrms@sltl.com";
	     String pass ="hrms#123";
	    // Recipient's email ID needs to be mentioned.
	   String host = "smtp.gmail.com";
	   
	   
	   
	   
	// 1st step) Get the session object
			Properties props = new Properties();
			// props.put("mail.smtp.starttls.enable", "true");
			
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			
			props.setProperty("mail.transport.protocol", "smtps");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.auth", "true");
			   
			   
			   
			props.put("mail.smtp.socketFactory.port", "587");  
			props.put("mail.smtp.starttls.enable", "true");
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
			String link = "http://192.168.182.58:6018/HRMS/";
	        
			try {
				MimeMessage message = new MimeMessage(session);
				message.setFrom(new InternetAddress(from));// From Address
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));// To
				
				message.setSubject(subject);// MSG Subject
				// This mail has 2 part, the BODY and the embedded image
		         MimeMultipart multipart = new MimeMultipart("related");

		         // first part (the html)
		         BodyPart messageBodyPart = new MimeBodyPart();
		         BodyPart messageBodyPart1 = new MimeBodyPart();
		         
		         /**/
		         
		         
		         
		         
		         String  htmlText = "<html>";
		          
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
		          htmlText += "<td align=\"right\"><img src=\"https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcQjJkNWrO_pXGhZoAvyStzhRr70iS-ZdCO7JUoQivdyMWqbV0HtLQ\"\r\n" + 
		          		"								height=\"40px\" width=\"40px\"\r\n" + 
		          		"								class=\"CToWUd\"></td>";
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
		          htmlText += "<td><div class=\"a6S\" dir=\"ltr\" style=\"opacity: 0.01; left: 521.5px; top: 236px;\"> <div id=\":13q\" class=\"T-I J-J5-Ji aQv T-I-ax7 L3 a5q\"" + 
		          		"role=\"button\" tabindex=\"0\" aria-label=\"Download attachment \" data-tooltip-class=\"a1V\" data-tooltip=\"Download\"> <div class=\"aSK J-J5-Ji aYr\"></div>" + 
		          		"</div> </div></td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td>";
		          htmlText += "<table cellpadding=\"15\" cellspacing=\"0\" border=\"0\" width=\"100%\">";
		          htmlText += "<tbody>";
		          htmlText += "<tr>";
		          htmlText += "<td> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 13px; color: #121212; line-height: 18px; padding-bottom: 10px\">" + 
		          		" Respected Sir / Ma'am,</p> "
		          		+ "<p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 13px; color: #121212; line-height: 18px\">" + 
		          		" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Your Reporting Employee <b>"+name+"</b> Submitted Timesheet For Date "+date+".</p>";
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
		          
		          htmlText += " <tr><td><img src=\"https://image.freepik.com/free-icon/calendar-interface-symbol-tool_318-58214.jpg\" style=\"color: black;\" height=\"20px\" width=\"20px\" class=\"CToWUd\"><b>&nbsp; Timesheet Detail </b><hr>"
		          		+ "</td> </tr>";
		          
		          htmlText += "<tr>";
		          htmlText += "<td>";
		          htmlText += "<table cellpadding=\"10\" cellspacing=\"0\" border=\"0\" width=\"100%\" style=\"border: solid #f4f4f4 1px\">";
		          htmlText += "<tbody>";
		          htmlText += "<tr>";
		          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\" width=\"150px;\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">" + 
		          		" <strong>Employee Code </strong> </p> </td>";
		          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 14px; color: #121212; line-height: 13px\">"+emp_code+"</p></td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		"<strong>Worked Hours</strong> </p> </td>";
		          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		""+sumOfWorkHours+"</p> </td>";
		          htmlText += "</tr>";
		          
		          htmlText += "<tr>";
		          htmlText += "<td  colspan=\"2\" style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		"Please download attachment to see Full Timesheet of this Employee.</p> </td>";
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
		          htmlText += "<table cellpadding=\"20\" cellspacing=\"0\" border=\"0\" width=\"100%\">";
		          htmlText += "<tbody>";
		          htmlText += "<tr>";
		          htmlText += "<td>";
		          
		        /*  htmlText += "<p align=\"center\" style=\"font-size: 13px; padding: 0px; margin: 0px; line-height: 20px; color: #121212;\"> For Approve Or Reject This Leave <a href=\"http://192.168.182.58:6018/HRMS/ByEmailLeaveApproveReject.jsp?leave_id="+leave_id+"\"><button style=\" background-color: white; color: black; border: 2px solid #337ab7;\">Click here</button></a></p>";
		          htmlText += "<br>";
		          htmlText += "<p align=\"center\" style=\"font-size: 13px; padding: 0px; margin: 0px; line-height: 13px; color: #121212; padding-bottom: 10px\">\r\n" + 
		          		" <span style=\"font-size: 14px\">OR</span></p>";
		          */
		          
		          htmlText += "<p style=\"font-size: 13px; padding: 0px; margin: 0px; padding-left: 5px; line-height: 20px; color: #121212; text-align: center\">For Login into HRMS <a href=\"http://192.168.182.58:6018/HRMS/\"><button style=\" background-color: white; color: black; border: 2px solid #337ab7;\">Login</button></a> </p>";
		          htmlText += "<br>";
		          htmlText += "<p align=\"center\" style=\"font-size: 11px; padding: 0px; margin: 0px; line-height: 13px; color: red; padding-bottom: 10px\"><b>Note : This button will work only when you are connected to SLTL Intranet.</b></p>";
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
		          htmlText += "<td><p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 13px; color: #121212; line-height: 20px; padding-bottom: 10px\"> For any queries or concerns, contact us on <b>313</b>.</p></td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td>";
		          htmlText += "<p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 13px; color: #121212; line-height: 20px\"> Regards,<br> Team HRMS </p>";
		          htmlText += "<br><p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 11px; color: #333; line-height: 20px; font-style: italic\">* This is an automated e-mail alert to help you to know about Timesheet of employee who Report You. Hence, Please do not reply to this e-mail.</p>";
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
		         
		         
		          		  
		          		  
		        /* String htmlText = type+"<br>"+query+"<br>"+code;*/
		         // htmlText += "<br><br><br>";
		         // htmlText += "<img src=\"cid:image\"><br><b>"+body+"</b><br><b>"+body1+"</b><br><b>"+body2+"</b><br><b>"+body3+"</b><br><b>"+body4+"</b>";
		         messageBodyPart.setContent(htmlText, "text/html");
		         // add it
		         multipart.addBodyPart(messageBodyPart);

		         // second part (the image)
		        // messageBodyPart = new MimeBodyPart();
		         DataSource fds = new FileDataSource(
		            "D:/hrms/upload/img/sltllogo.png");

		        //messageBodyPart.setDataHandler(new DataHandler(fds));
		       //  messageBodyPart.setHeader("Content-ID", "<image>");

		         //Attachment
		         MimeBodyPart attachPart = new MimeBodyPart();
		         String attachFile = fileNameWithPath;
		         try {
					attachPart.attachFile(attachFile);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		         multipart.addBodyPart(attachPart);
		         
		         // add image to the multipart
		         multipart.addBodyPart(messageBodyPart);
		         
		        
		         message.setContent(multipart);
		         
				// 3rd step)send message
				Transport.send(message);

				System.out.println("Done confirm");

			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
			
			
		 
	 }
	

	public static void timeSheetMail(String to, String subject, String date ,String remarks, int emp_code, String name) {      // Timesheet rejection Mail 
		 
		// Sender's email ID needs to be mentioned
	     String from = "hrms@sltl.com";
	     String pass ="hrms#123";
	    // Recipient's email ID needs to be mentioned.
	   String host = "smtp.gmail.com";
	   
	   
	   
	   
	// 1st step) Get the session object
			Properties props = new Properties();
			// props.put("mail.smtp.starttls.enable", "true");
			
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			
			props.setProperty("mail.transport.protocol", "smtps");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.auth", "true");
			   
			   
			   
			props.put("mail.smtp.socketFactory.port", "587");  
			props.put("mail.smtp.starttls.enable", "true");
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
			String link = "http://192.168.182.58:6018/HRMS/";
	        
			try {
				MimeMessage message = new MimeMessage(session);
				message.setFrom(new InternetAddress(from));// From Address
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));// To
				
				message.setSubject(subject);// MSG Subject
				// This mail has 2 part, the BODY and the embedded image
		         MimeMultipart multipart = new MimeMultipart("related");

		         // first part (the html)
		         BodyPart messageBodyPart = new MimeBodyPart();
		         BodyPart messageBodyPart1 = new MimeBodyPart();
		         
		         /**/
		         
		        

		         
		         
		         
		         
		         String  htmlText = "<html>";
		          
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
		          htmlText += "<td align=\"right\"><img src=\"https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcQjJkNWrO_pXGhZoAvyStzhRr70iS-ZdCO7JUoQivdyMWqbV0HtLQ\"\r\n" + 
		          		"								height=\"40px\" width=\"40px\"\r\n" + 
		          		"								class=\"CToWUd\"></td>";
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
		          htmlText += "<td><div class=\"a6S\" dir=\"ltr\" style=\"opacity: 0.01; left: 521.5px; top: 236px;\"> <div id=\":13q\" class=\"T-I J-J5-Ji aQv T-I-ax7 L3 a5q\"" + 
		          		"role=\"button\" tabindex=\"0\" aria-label=\"Download attachment \" data-tooltip-class=\"a1V\" data-tooltip=\"Download\"> <div class=\"aSK J-J5-Ji aYr\"></div>" + 
		          		"</div> </div></td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td>";
		          htmlText += "<table cellpadding=\"15\" cellspacing=\"0\" border=\"0\" width=\"100%\">";
		          htmlText += "<tbody>";
		          htmlText += "<tr>";
		          htmlText += "<td> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 13px; color: #121212; line-height: 18px; padding-bottom: 10px\">" + 
		          		" Dear "+name+" ,</p> "
		          		+ "<p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 13px; color: #121212; line-height: 18px\">" + 
		          		" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Your Timesheet Rejected By Your Manager For Date "+date+".</p>";
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
		          
		          htmlText += " <tr><td><img src=\"https://image.freepik.com/free-icon/calendar-interface-symbol-tool_318-58214.jpg\" style=\"color: black;\" height=\"20px\" width=\"20px\" class=\"CToWUd\"><b>&nbsp; Timesheet Detail </b><hr>"
		          		+ "</td> </tr>";
		          
		          htmlText += "<tr>";
		          htmlText += "<td>";
		          htmlText += "<table cellpadding=\"10\" cellspacing=\"0\" border=\"0\" width=\"100%\" style=\"border: solid #f4f4f4 1px\">";
		          htmlText += "<tbody>";
		          htmlText += "<tr>";
		          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\" width=\"150px;\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">" + 
		          		" <strong>Employee Code </strong> </p> </td>";
		          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 14px; color: #121212; line-height: 13px\">"+emp_code+"</p></td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		"<strong>Reason</strong> </p> </td>";
		          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		""+remarks+"</p> </td>";
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
		          htmlText += "<table cellpadding=\"20\" cellspacing=\"0\" border=\"0\" width=\"100%\">";
		          htmlText += "<tbody>";
		          htmlText += "<tr>";
		          htmlText += "<td>";
		          
		        /*  htmlText += "<p align=\"center\" style=\"font-size: 13px; padding: 0px; margin: 0px; line-height: 20px; color: #121212;\"> For Approve Or Reject This Leave <a href=\"http://192.168.182.58:6018/HRMS/ByEmailLeaveApproveReject.jsp?leave_id="+leave_id+"\"><button style=\" background-color: white; color: black; border: 2px solid #337ab7;\">Click here</button></a></p>";
		          htmlText += "<br>";
		          htmlText += "<p align=\"center\" style=\"font-size: 13px; padding: 0px; margin: 0px; line-height: 13px; color: #121212; padding-bottom: 10px\">\r\n" + 
		          		" <span style=\"font-size: 14px\">OR</span></p>";
		          */
		          
		          htmlText += "<p style=\"font-size: 13px; padding: 0px; margin: 0px; padding-left: 5px; line-height: 20px; color: #121212; text-align: center\">For Login into HRMS <a href=\"http://192.168.182.58:6018/HRMS/\"><button style=\" background-color: white; color: black; border: 2px solid #337ab7;\">Login</button></a> </p>";
		          htmlText += "<br>";
		          htmlText += "<p align=\"center\" style=\"font-size: 11px; padding: 0px; margin: 0px; line-height: 13px; color: red; padding-bottom: 10px\"><b>Note : This button will work only when you are connected to SLTL Intranet.</b></p>";
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
		          htmlText += "<td><p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 13px; color: #121212; line-height: 20px; padding-bottom: 10px\"> For any queries or concerns, contact us on <b>313</b>.</p></td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td>";
		          htmlText += "<p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 13px; color: #121212; line-height: 20px\"> Regards,<br> Team HRMS </p>";
		          htmlText += "<br><p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 11px; color: #333; line-height: 20px; font-style: italic\">* This is an automated e-mail alert to help you to know about your Timesheet. Hence, Please do not reply to this e-mail.</p>";
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
		         
		          		  
		        /* String htmlText = type+"<br>"+query+"<br>"+code;*/
		          htmlText += "<br><br><br>";
		          htmlText += "<img src=\"cid:image\"><br><b>"+body+"</b><br><b>"+body1+"</b><br><b>"+body2+"</b><br><b>"+body3+"</b><br><b>"+body4+"</b>";
		         messageBodyPart.setContent(htmlText, "text/html");
		         // add it
		         multipart.addBodyPart(messageBodyPart);

		         // second part (the image)
		         messageBodyPart = new MimeBodyPart();
		         DataSource fds = new FileDataSource(
		            "D:/hrms/upload/img/sltllogo.png");

		         messageBodyPart.setDataHandler(new DataHandler(fds));
		         messageBodyPart.setHeader("Content-ID", "<image>");

		         // add image to the multipart
		         multipart.addBodyPart(messageBodyPart);
		         
		        
		         message.setContent(multipart);
		         
				// 3rd step)send message
				Transport.send(message);

				System.out.println("Done confirm");

			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
		 
	 }
	
	
	
	public static void applyGatePass(String to, String subject,int emp_code,String name,String out_time,String fromDec,String toDec,String mailDate,String reason) {      // Gate Pass Apply
		// Sender's email ID needs to be mentioned
	     String from = "hrms@sltl.com";
	     String pass ="hrms#123";
	    // Recipient's email ID needs to be mentioned.
	   String host = "smtp.gmail.com";
	   
	   System.out.println("akash");
	   
	   
	// 1st step) Get the session object
			Properties props = new Properties();
			// props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.setProperty("mail.transport.protocol", "smtps");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.auth", "true");
			
			
			   
			   
			   
		props.put("mail.smtp.socketFactory.port", "587");  
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.socketFactory.class", "javax.net.SocketFactory");
		props.put("mail.smtp.ssl.enable", "false");
		props.put("mail.smtp.ssl.trust", host);
			   

			Session session = Session.getInstance(props, new javax.mail.Authenticator() {
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
			String link = "http://192.168.182.58:6018/HRMS/";
	        
			try {
				MimeMessage message = new MimeMessage(session);
				message.setFrom(new InternetAddress(from));// From Address
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));// To
				
				message.setSubject(subject);// MSG Subject
				// This mail has 2 part, the BODY and the embedded image
		         MimeMultipart multipart = new MimeMultipart("related");

		         // first part (the html)
		         BodyPart messageBodyPart = new MimeBodyPart();
		         BodyPart messageBodyPart1 = new MimeBodyPart();
		         
		         /**/
		         
		          String  htmlText = "<html>";
		          
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
		          htmlText += "<td align=\"right\"><img src=\"https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcQjJkNWrO_pXGhZoAvyStzhRr70iS-ZdCO7JUoQivdyMWqbV0HtLQ\"\r\n" + 
		          		"								height=\"40px\" width=\"40px\"\r\n" + 
		          		"								class=\"CToWUd\"></td>";
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
		          htmlText += "<td><div class=\"a6S\" dir=\"ltr\" style=\"opacity: 0.01; left: 521.5px; top: 236px;\"> <div id=\":13q\" class=\"T-I J-J5-Ji aQv T-I-ax7 L3 a5q\"" + 
		          		"role=\"button\" tabindex=\"0\" aria-label=\"Download attachment \" data-tooltip-class=\"a1V\" data-tooltip=\"Download\"> <div class=\"aSK J-J5-Ji aYr\"></div>" + 
		          		"</div> </div></td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td>";
		          htmlText += "<table cellpadding=\"15\" cellspacing=\"0\" border=\"0\" width=\"100%\">";
		          htmlText += "<tbody>";
		          htmlText += "<tr>";
		          htmlText += "<td> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 13px; color: #121212; line-height: 18px; padding-bottom: 10px\">" + 
		          		" Respected Sir / Ma'am,</p> "
		          		+ "<p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 13px; color: #121212; line-height: 18px\">" + 
		          		" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Your Reporting Employee <b>"+name+"</b> Applied For Gate Pass.</p>";
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
		          
		          htmlText += " <tr><td><img src=\"http://www.letk.ee/img/document.png\" style=\"color: black;\" height=\"20px\" width=\"20px\" class=\"CToWUd\"><b>&nbsp; Gate Pass Detail </b><hr>"
		          		+ "</td> </tr>";
		          
		          htmlText += "<tr>";
		          htmlText += "<td>";
		          htmlText += "<table cellpadding=\"10\" cellspacing=\"0\" border=\"0\" width=\"100%\" style=\"border: solid #f4f4f4 1px\">";
		          htmlText += "<tbody>";
		          htmlText += "<tr>";
		          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">" + 
		          		" <strong>Employee Code </strong> </p> </td>";
		          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 14px; color: #121212; line-height: 13px\">"+emp_code+"</p></td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		"<strong>Date</strong> </p> </td>";
		          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		""+mailDate+"</p> </td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" <strong>Source</strong> </p> </td>";
		          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" "+fromDec+"</p> </td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" <strong>Deatinition</strong> </p> </td>";
		          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" "+toDec+"</p> </td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" <strong>Out Time</strong> </p> </td>";
		          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		""+out_time+"</p></td>";
		          htmlText += "</tr>";
		          
		          htmlText += "<tr>";
		          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" <strong>Reason</strong> </p> </td>";
		          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		""+reason+"</p></td>";
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
		          
		        /* String htmlText = type+"<br>"+query+"<br>"+code;*/
		          //htmlText += "<br><br><br>";
		        //  htmlText += "<img src=\"cid:image\"><br><b>"+body+"</b><br><b>"+body1+"</b><br><b>"+body2+"</b><br><b>"+body3+"</b><br><b>"+body4+"</b>";
		         messageBodyPart.setContent(htmlText, "text/html");
		         // add it
		         multipart.addBodyPart(messageBodyPart);

		         // second part (the image)
		         messageBodyPart = new MimeBodyPart();
		         DataSource fds = new FileDataSource(
		            "D:/hrms/upload/img/sltllogo.png");

		         messageBodyPart.setDataHandler(new DataHandler(fds));
		         messageBodyPart.setHeader("Content-ID", "<image>");

		         // add image to the multipart
		         multipart.addBodyPart(messageBodyPart);
		         
		        
		         message.setContent(multipart);
		         
				// 3rd step)send message
				Transport.send(message);

				System.out.println("Done : "+to);

			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
			
			
		 
	 }
	
	
	public static void timesheetReminder(String to, String subject, String currDate, String name ) {      // TIMESHEET REMINDER
		 
		// Sender's email ID needs to be mentioned
	     String from = "hrms@sltl.com";
	     String pass ="hrms#123";
	    // Recipient's email ID needs to be mentioned.
	   String host = "smtp.gmail.com";
	   
	   
	   
	   
	// 1st step) Get the session object
			Properties props = new Properties();
			// props.put("mail.smtp.starttls.enable", "true");
			
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			
			props.setProperty("mail.transport.protocol", "smtps");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.auth", "true");
			   
			   
			   
			props.put("mail.smtp.socketFactory.port", "587");  
			props.put("mail.smtp.starttls.enable", "true");
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
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));// To
				
				message.setSubject(subject);// MSG Subject
				// This mail has 2 part, the BODY and the embedded image
		         MimeMultipart multipart = new MimeMultipart("related");

		         // first part (the html)
		         BodyPart messageBodyPart = new MimeBodyPart();
		         BodyPart messageBodyPart1 = new MimeBodyPart();
		         
		         /**/
		         
		          String  htmlText = "<html>";
		          
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
		          htmlText += "<td align=\"right\"><img src=\"https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcQjJkNWrO_pXGhZoAvyStzhRr70iS-ZdCO7JUoQivdyMWqbV0HtLQ\"\r\n" + 
		          		"								height=\"40px\" width=\"40px\"\r\n" + 
		          		"								class=\"CToWUd\"></td>";
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
		          htmlText += "<td><div class=\"a6S\" dir=\"ltr\" style=\"opacity: 0.01; left: 521.5px; top: 236px;\"> <div id=\":13q\" class=\"T-I J-J5-Ji aQv T-I-ax7 L3 a5q\"" + 
		          		"role=\"button\" tabindex=\"0\" aria-label=\"Download attachment \" data-tooltip-class=\"a1V\" data-tooltip=\"Download\"> <div class=\"aSK J-J5-Ji aYr\"></div>" + 
		          		"</div> </div></td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td>";
		          htmlText += "<table cellpadding=\"15\" cellspacing=\"0\" border=\"0\" width=\"100%\">";
		          htmlText += "<tbody>";
		          htmlText += "<tr>";
		          htmlText += "<td> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 13px; color: #121212; line-height: 18px; padding-bottom: 10px\">" + 
		          		" Dear , "+name
		          		+ "</p><p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 13px; color: #121212; line-height: 18px\">" + 
		          		" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Your Timesheet Not Filled Yet Of Date <b>"+currDate+"</b> So Kindly Fill Your Timesheet.</p>";
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
		          
		          htmlText += "</td>";
		          htmlText += "</tr>";
		          
		        
		          htmlText += "</tbody>";
		          htmlText += "</table>";
		          htmlText += "</body>";
		          htmlText += "</html>";
		          
		        /* String htmlText = type+"<br>"+query+"<br>"+code;*/
		          //htmlText += "<br><br><br>";
		        //  htmlText += "<img src=\"cid:image\"><br><b>"+body+"</b><br><b>"+body1+"</b><br><b>"+body2+"</b><br><b>"+body3+"</b><br><b>"+body4+"</b>";
		         messageBodyPart.setContent(htmlText, "text/html");
		         // add it
		         multipart.addBodyPart(messageBodyPart);

		         // second part (the image)
		         messageBodyPart = new MimeBodyPart();
		         DataSource fds = new FileDataSource(
		            "D:/hrms/upload/img/sltllogo.png");

		         messageBodyPart.setDataHandler(new DataHandler(fds));
		         messageBodyPart.setHeader("Content-ID", "<image>");

		         // add image to the multipart
		         multipart.addBodyPart(messageBodyPart);
		         
		        
		         message.setContent(multipart);
		         
				// 3rd step)send message
				Transport.send(message);

				System.out.println("Done : "+to);

			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
			
			
		 
	 }
	
	
	
	public static void createProject(String to, String subject, String proj_code, String proj_name, String proj_start_date, String proj_end_date, String name, String manager_name) {      // Create New Project
		// Sender's email ID needs to be mentioned
	     String from = "hrms@sltl.com";
	     String pass ="hrms#123";
	    // Recipient's email ID needs to be mentioned.
	   String host = "smtp.gmail.com";
	   
	   System.out.println("akash");
	   
	   
	// 1st step) Get the session object
			Properties props = new Properties();
			// props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.setProperty("mail.transport.protocol", "smtps");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.auth", "true");
			
			
			   
			   
			   
		props.put("mail.smtp.socketFactory.port", "587");  
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.socketFactory.class", "javax.net.SocketFactory");
		props.put("mail.smtp.ssl.enable", "false");
		props.put("mail.smtp.ssl.trust", host);
			   

			Session session = Session.getInstance(props, new javax.mail.Authenticator() {
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
			String link = "http://192.168.182.58:6018/HRMS/";
	        
			try {
				MimeMessage message = new MimeMessage(session);
				message.setFrom(new InternetAddress(from));// From Address
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));// To
				
				message.setSubject(subject);// MSG Subject
				// This mail has 2 part, the BODY and the embedded image
		         MimeMultipart multipart = new MimeMultipart("related");

		         // first part (the html)
		         BodyPart messageBodyPart = new MimeBodyPart();
		         BodyPart messageBodyPart1 = new MimeBodyPart();
		         
		         /**/
		         
		          String  htmlText = "<html>";
		          
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
		          htmlText += "<td align=\"right\"><img src=\"https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcQjJkNWrO_pXGhZoAvyStzhRr70iS-ZdCO7JUoQivdyMWqbV0HtLQ\"\r\n" + 
		          		"								height=\"40px\" width=\"40px\"\r\n" + 
		          		"								class=\"CToWUd\"></td>";
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
		          htmlText += "<td><div class=\"a6S\" dir=\"ltr\" style=\"opacity: 0.01; left: 521.5px; top: 236px;\"> <div id=\":13q\" class=\"T-I J-J5-Ji aQv T-I-ax7 L3 a5q\"" + 
		          		"role=\"button\" tabindex=\"0\" aria-label=\"Download attachment \" data-tooltip-class=\"a1V\" data-tooltip=\"Download\"> <div class=\"aSK J-J5-Ji aYr\"></div>" + 
		          		"</div> </div></td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td>";
		          htmlText += "<table cellpadding=\"15\" cellspacing=\"0\" border=\"0\" width=\"100%\">";
		          htmlText += "<tbody>";
		          htmlText += "<tr>";
		          htmlText += "<td> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 13px; color: #121212; line-height: 18px; padding-bottom: 10px\">" + 
		          		" Respected Sir / Ma'am,</p> "
		          		+ "<p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 13px; color: #121212; line-height: 18px\">" + 
		          		" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Project : <b>"+proj_name+"</b> is created by <b>"+manager_name+"</b>.</p>";
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
		          
		          htmlText += " <tr><td><img src=\"http://www.letk.ee/img/document.png\" style=\"color: black;\" height=\"20px\" width=\"20px\" class=\"CToWUd\"><b>&nbsp; Project Detail </b><hr>"
		          		+ "</td> </tr>";
		          
		          htmlText += "<tr>";
		          htmlText += "<td>";
		          htmlText += "<table cellpadding=\"10\" cellspacing=\"0\" border=\"0\" width=\"100%\" style=\"border: solid #f4f4f4 1px\">";
		          htmlText += "<tbody>";
		          htmlText += "<tr>";
		          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">" + 
		          		" <strong>Project Code </strong> </p> </td>";
		          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 14px; color: #121212; line-height: 13px\">"
		          		+proj_code+"</p></td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		"<strong>Project Name</strong> </p> </td>";
		          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		""+proj_name+"</p> </td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" <strong>Planned Start Date</strong> </p> </td>";
		          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" "+proj_start_date+"</p> </td>";
		          htmlText += "</tr>";
		          
		          htmlText += "<tr>";
		          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" <strong>Planned End Date</strong> </p> </td>";
		          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" "+proj_end_date+"</p> </td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" <strong>Created By</strong> </p> </td>";
		          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" "+manager_name+"</p> </td>";
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
		          
		        /* String htmlText = type+"<br>"+query+"<br>"+code;*/
		          //htmlText += "<br><br><br>";
		        //  htmlText += "<img src=\"cid:image\"><br><b>"+body+"</b><br><b>"+body1+"</b><br><b>"+body2+"</b><br><b>"+body3+"</b><br><b>"+body4+"</b>";
		         messageBodyPart.setContent(htmlText, "text/html");
		         // add it
		         multipart.addBodyPart(messageBodyPart);

		         // second part (the image)
		         messageBodyPart = new MimeBodyPart();
		         DataSource fds = new FileDataSource(
		            "D:/hrms/upload/img/sltllogo.png");

		         messageBodyPart.setDataHandler(new DataHandler(fds));
		         messageBodyPart.setHeader("Content-ID", "<image>");

		         // add image to the multipart
		         multipart.addBodyPart(messageBodyPart);
		         
		        
		         message.setContent(multipart);
		         
				// 3rd step)send message
				Transport.send(message);

				System.out.println("Done : "+to);

			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
			
			
		 
	 }
	
	
	
	//Bhoomi Patel
	//Date : 17-03-2017
	public static void commentorSend(String to,String subject, String commenter, String comment, String name, String task_name, String project_name, List<String> arrayOfEmail ) {    // Send Method when Commentor Comment on Project 
		// Sender's email ID needs to be mentioned
	     String from = "hrms@sltl.com";
	     String pass ="hrms#123";
	    // Recipient's email ID needs to be mentioned.
	   String host = "smtp.gmail.com";
	   
	   System.out.println("akash");

	// 1st step) Get the session object
				Properties props = new Properties();
				// props.put("mail.smtp.starttls.enable", "true");
				props.put("mail.smtp.port", "587");
				
				props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
				
				props.setProperty("mail.transport.protocol", "smtps");
				props.put("mail.smtp.starttls.enable", "true");
				props.put("mail.smtp.host", host);
				props.put("mail.smtp.port", "587");
				props.put("mail.smtp.auth", "true");
				   
				   
				   
				props.put("mail.smtp.socketFactory.port", "587");  
				props.put("mail.smtp.socketFactory.class",  
					            "javax.net.ssl.SSLSocketFactory");  
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
				String link = "http://192.168.182.58:6018/HRMS/";
		        
				try {
					MimeMessage message = new MimeMessage(session);
					message.setFrom(new InternetAddress(from));// From Address
					message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));// To
					
					for(String email : arrayOfEmail){
						message.addRecipient(Message.RecipientType.CC, new InternetAddress(email));// CC
					}
					
					message.setSubject(subject);// MSG Subject
					// This mail has 2 part, the BODY and the embedded image
			         MimeMultipart multipart = new MimeMultipart("related");

			         // first part (the html)
			         BodyPart messageBodyPart = new MimeBodyPart();
			         BodyPart messageBodyPart1 = new MimeBodyPart();
			         
			         /**/
			         String  htmlText = "<html>";
			          
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
			          htmlText += "<td align=\"right\"><img src=\"https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcQjJkNWrO_pXGhZoAvyStzhRr70iS-ZdCO7JUoQivdyMWqbV0HtLQ\"\r\n" + 
			          		"								height=\"40px\" width=\"40px\"\r\n" + 
			          		"								class=\"CToWUd\"></td>";
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
			          htmlText += "<td><div class=\"a6S\" dir=\"ltr\" style=\"opacity: 0.01; left: 521.5px; top: 236px;\"> <div id=\":13q\" class=\"T-I J-J5-Ji aQv T-I-ax7 L3 a5q\"" + 
			          		"role=\"button\" tabindex=\"0\" aria-label=\"Download attachment \" data-tooltip-class=\"a1V\" data-tooltip=\"Download\"> <div class=\"aSK J-J5-Ji aYr\"></div>" + 
			          		"</div> </div></td>";
			          htmlText += "</tr>";
			          htmlText += "<tr>";
			          htmlText += "<td>";
			          htmlText += "<table cellpadding=\"15\" cellspacing=\"0\" border=\"0\" width=\"100%\">";
			          htmlText += "<tbody>";
			          htmlText += "<tr>";
			          htmlText += "<td> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 13px; color: #121212; line-height: 18px; padding-bottom: 10px\">" + 
			          		" Respected Sir / Ma'am,</p> "
			          		+ "<p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 13px; color: #121212; line-height: 18px\">" + 
			          		"  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;This is Notification E-mail.<br>  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <b>"+commenter+"</b> Commented On "+task_name+".</p>";
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
			          htmlText += "<tr>";
			          htmlText += "<td>";
			          htmlText += "<table cellpadding=\"10\" cellspacing=\"0\" border=\"0\" width=\"100%\" style=\"border: solid #f4f4f4 1px\">";
			          htmlText += "<tbody>";
			          
			          htmlText += "<tr>";
			          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
			          		"<strong>Project</strong> </p> </td>";
			          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
			          		""+project_name+"</p> </td>";
			          htmlText += "</tr>";
			          
			          htmlText += "<tr>";
			          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
			          		"<strong>Task</strong> </p> </td>";
			          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
			          		""+task_name+"</p> </td>";
			          htmlText += "</tr>";
			          
			          htmlText += "<tr>";
			          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
			          		"<strong>Commenter</strong> </p> </td>";
			          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
			          		""+commenter+"</p> </td>";
			          htmlText += "</tr>";
			         
			          htmlText += "<tr>";
			          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
			          		" <strong>Comment</strong> </p> </td>";
			          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
			          		" "+comment+"</p> </td>";
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
			          htmlText += "<table cellpadding=\"20\" cellspacing=\"0\" border=\"0\" width=\"100%\">";
			          htmlText += "<tbody>";
			          htmlText += "<tr>";
			          htmlText += "<td>";
			         
			          htmlText += "<p style=\"font-size: 13px; padding: 0px; margin: 0px; padding-left: 5px; line-height: 20px; color: #121212; text-align: center\">For Login into HRMS <a href=\"http://192.168.182.58:6018/HRMS/\"><button style=\" background-color: white; color: black; border: 2px solid #337ab7;\">Login</button></a> </p>";
			          htmlText += "<br>";
			          htmlText += "<p align=\"center\" style=\"font-size: 11px; padding: 0px; margin: 0px; line-height: 13px; color: red; padding-bottom: 10px\"><b>Note : This button will work only when you are connected to SLTL Intranet.</b></p>";
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
			          
				        /* String htmlText = type+"<br>"+query+"<br>"+code;*/
				         htmlText += "<br><br><br>";
				         htmlText += "<img src=\"cid:image\"><br><b>"+body+"</b><br><b>"+body1+"</b><br><b>"+body2+"</b><br><b>"+body3+"</b><br><b>"+body4+"</b>";
				         messageBodyPart.setContent(htmlText, "text/html");
				         // add it
				         multipart.addBodyPart(messageBodyPart);

				         // second part (the image)
				         messageBodyPart = new MimeBodyPart();
				         DataSource fds = new FileDataSource("D:/hrms/upload/img/sltllogo.png");

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
	
	
	
	public static void allocationReminder(String to, String subject, String projectName, String name ) {      // Project Allocation REMINDER
		 
		// Sender's email ID needs to be mentioned
	     String from = "hrms@sltl.com";
	     String pass ="hrms#123";
	    // Recipient's email ID needs to be mentioned.
	   String host = "smtp.gmail.com";
	   
	   
	   
	   
	// 1st step) Get the session object
			Properties props = new Properties();
			// props.put("mail.smtp.starttls.enable", "true");
			
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			
			props.setProperty("mail.transport.protocol", "smtps");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.auth", "true");
			   
			   
			   
			props.put("mail.smtp.socketFactory.port", "587");  
			props.put("mail.smtp.starttls.enable", "true");
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
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));// To
				
				message.setSubject(subject);// MSG Subject
				// This mail has 2 part, the BODY and the embedded image
		         MimeMultipart multipart = new MimeMultipart("related");

		         // first part (the html)
		         BodyPart messageBodyPart = new MimeBodyPart();
		         BodyPart messageBodyPart1 = new MimeBodyPart();
		         
		         /**/
		         
		          String  htmlText = "<html>";
		          
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
		          htmlText += "<td align=\"right\"><img src=\"https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcQjJkNWrO_pXGhZoAvyStzhRr70iS-ZdCO7JUoQivdyMWqbV0HtLQ\"\r\n" + 
		          		"								height=\"40px\" width=\"40px\"\r\n" + 
		          		"								class=\"CToWUd\"></td>";
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
		          htmlText += "<td><div class=\"a6S\" dir=\"ltr\" style=\"opacity: 0.01; left: 521.5px; top: 236px;\"> <div id=\":13q\" class=\"T-I J-J5-Ji aQv T-I-ax7 L3 a5q\"" + 
		          		"role=\"button\" tabindex=\"0\" aria-label=\"Download attachment \" data-tooltip-class=\"a1V\" data-tooltip=\"Download\"> <div class=\"aSK J-J5-Ji aYr\"></div>" + 
		          		"</div> </div></td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td>";
		          htmlText += "<table cellpadding=\"15\" cellspacing=\"0\" border=\"0\" width=\"100%\">";
		          htmlText += "<tbody>";
		          htmlText += "<tr>";
		          htmlText += "<td> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 13px; color: #121212; line-height: 18px; padding-bottom: 10px\">" + 
		          		" Dear , "+name
		          		+ "</p><p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 13px; color: #121212; line-height: 18px\">" + 
		          		" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; You have been allocated in <b>"+projectName+"</b>.</p>";
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
		          
		          htmlText += "</td>";
		          htmlText += "</tr>";
		          
		        
		          htmlText += "</tbody>";
		          htmlText += "</table>";
		          htmlText += "</body>";
		          htmlText += "</html>";
		          
		        /* String htmlText = type+"<br>"+query+"<br>"+code;*/
		          //htmlText += "<br><br><br>";
		        //  htmlText += "<img src=\"cid:image\"><br><b>"+body+"</b><br><b>"+body1+"</b><br><b>"+body2+"</b><br><b>"+body3+"</b><br><b>"+body4+"</b>";
		         messageBodyPart.setContent(htmlText, "text/html");
		         // add it
		         multipart.addBodyPart(messageBodyPart);

		         // second part (the image)
		         messageBodyPart = new MimeBodyPart();
		         DataSource fds = new FileDataSource(
		            "D:/hrms/upload/img/sltllogo.png");

		         messageBodyPart.setDataHandler(new DataHandler(fds));
		         messageBodyPart.setHeader("Content-ID", "<image>");

		         // add image to the multipart
		         multipart.addBodyPart(messageBodyPart);
		         
		        
		         message.setContent(multipart);
		         
				// 3rd step)send message
				Transport.send(message);

				System.out.println("Done : "+to);

			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
			
			
		 
	 }
	
	
	
	
	/*IT Complaint Register*/
	
	public static void complaintSend(String to,String  sub,String  complaint_date,int emp_code,String  complaint_description,String  userName,
			String department,String complaintnature,int extension,String location) {
		// Sender's email ID needs to be mentioned
	     String from = "hrms@sltl.com";
	     String pass ="hrms#123";
	    // Recipient's email ID needs to be mentioned.
	   String host = "smtp.gmail.com";
	   
	   System.out.println("akash");

	// 1st step) Get the session object
				Properties props = new Properties();
				// props.put("mail.smtp.starttls.enable", "true");
				props.put("mail.smtp.port", "587");
				
				props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
				
				props.setProperty("mail.transport.protocol", "smtps");
				props.put("mail.smtp.starttls.enable", "true");
				props.put("mail.smtp.host", host);
				props.put("mail.smtp.port", "587");
				props.put("mail.smtp.auth", "true");
				   
				   
				   
				props.put("mail.smtp.socketFactory.port", "587");  
				props.put("mail.smtp.socketFactory.class",  
					            "javax.net.ssl.SSLSocketFactory");  
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
				String link = "http://192.168.182.58:6018/HRMS/";
		        
				try {
					MimeMessage message = new MimeMessage(session);
					message.setFrom(new InternetAddress(from));// From Address
					message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));// To
					
					
					
					message.setSubject(sub);// MSG Subject
					// This mail has 2 part, the BODY and the embedded image
			         MimeMultipart multipart = new MimeMultipart("related");

			         // first part (the html)
			         BodyPart messageBodyPart = new MimeBodyPart();
			         BodyPart messageBodyPart1 = new MimeBodyPart();
			         
			         /**/
			         String  htmlText = "<html>";
			          
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
			          htmlText += "<td align=\"right\"><img src=\"https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcQjJkNWrO_pXGhZoAvyStzhRr70iS-ZdCO7JUoQivdyMWqbV0HtLQ\"\r\n" + 
			          		"								height=\"40px\" width=\"40px\"\r\n" + 
			          		"								class=\"CToWUd\"></td>";
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
			          htmlText += "<td><div class=\"a6S\" dir=\"ltr\" style=\"opacity: 0.01; left: 521.5px; top: 236px;\"> <div id=\":13q\" class=\"T-I J-J5-Ji aQv T-I-ax7 L3 a5q\"" + 
			          		"role=\"button\" tabindex=\"0\" aria-label=\"Download attachment \" data-tooltip-class=\"a1V\" data-tooltip=\"Download\"> <div class=\"aSK J-J5-Ji aYr\"></div>" + 
			          		"</div> </div></td>";
			          htmlText += "</tr>";
			          htmlText += "<tr>";
			          htmlText += "<td>";
			          htmlText += "<table cellpadding=\"15\" cellspacing=\"0\" border=\"0\" width=\"100%\">";
			          htmlText += "<tbody>";
			          htmlText += "<tr>";
			          htmlText += "<td> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 13px; color: #121212; line-height: 18px; padding-bottom: 10px\">" + 
			          		" Respected Sir,</p> "
			          		+ "<p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 13px; color: #121212; line-height: 18px\">" + 
			          		"  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;This is Notification E-mail.<br><br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <b>"+userName+"</b> register a complaint.</p>";
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
			          htmlText += "<tr>";
			          htmlText += "<td>";
			          htmlText += "<table cellpadding=\"10\" cellspacing=\"0\" border=\"0\" width=\"100%\" style=\"border: solid #f4f4f4 1px\">";
			          htmlText += "<tbody>";
			          
			          
			          
			         
			          htmlText += "<tr>";
			          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
			          		"<strong>Employee Code</strong> </p> </td>";
			          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
			          		""+emp_code+"</p> </td>";
			          htmlText += "</tr>";
			          
			          htmlText += "<tr>";
			          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
			          		" <strong>Department</strong> </p> </td>";
			          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
			          		" "+department+"</p> </td>";
			          htmlText += "</tr>";
			          
			          htmlText += "<tr>";
			          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
			          		"<strong>Employee Name</strong> </p> </td>";
			          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
			          		""+userName+"</p> </td>";
			          htmlText += "</tr>";
			          
			          htmlText += "<tr>";
			          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
			          		"<strong>Extension No.</strong> </p> </td>";
			          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
			          		""+extension+"</p> </td>";
			          htmlText += "</tr>";
			          
			          
			          htmlText += "<tr>";
			          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
			          		"<strong>Location</strong> </p> </td>";
			          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
			          		""+location+"</p> </td>";
			          htmlText += "</tr>";
			          
			         
			          
			          htmlText += "<tr>";
			          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
			          		"<strong>Complaint Date</strong> </p> </td>";
			          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
			          		""+complaint_date+"</p> </td>";
			          htmlText += "</tr>";
			          
			          htmlText += "<tr>";
			          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
			          		"<strong>Complaint Nature</strong> </p> </td>";
			          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
			          		""+complaintnature+"</p> </td>";
			          htmlText += "</tr>";
			         
			          htmlText += "<tr>";
			          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
			          		" <strong>Complaint Description</strong> </p> </td>";
			          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
			          		" "+complaint_description+"</p> </td>";
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
			          htmlText += "<table cellpadding=\"20\" cellspacing=\"0\" border=\"0\" width=\"100%\">";
			          htmlText += "<tbody>";
			          htmlText += "<tr>";
			          htmlText += "<td>";
			         
			          htmlText += "<p style=\"font-size: 13px; padding: 0px; margin: 0px; padding-left: 5px; line-height: 20px; color: #121212; text-align: center\">For Login into HRMS <a href=\"http://192.168.182.58:6018/HRMS/\"><button style=\" background-color: white; color: black; border: 2px solid #337ab7;\">Login</button></a> </p>";
			          htmlText += "<br>";
			          htmlText += "<p align=\"center\" style=\"font-size: 11px; padding: 0px; margin: 0px; line-height: 13px; color: red; padding-bottom: 10px\"><b>Note : This button will work only when you are connected to SLTL Intranet.</b></p>";
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
			          
				        /* String htmlText = type+"<br>"+query+"<br>"+code;*/
				         htmlText += "<br><br><br>";
				         htmlText += "<img src=\"cid:image\"><br><b>"+body+"</b><br><b>"+body1+"</b><br><b>"+body2+"</b><br><b>"+body3+"</b><br><b>"+body4+"</b>";
				         messageBodyPart.setContent(htmlText, "text/html");
				         // add it
				         multipart.addBodyPart(messageBodyPart);

				         // second part (the image)
				         messageBodyPart = new MimeBodyPart();
				         DataSource fds = new FileDataSource("D:/hrms/upload/img/sltllogo.png");

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
	


	// Chirag Prajapati
	//Date : 10-05-2017


	public static void downloadSend(String to,String  sub,String  complaint_date,int emp_code,String  userName,
			String department,String link1) {
		// Sender's email ID needs to be mentioned
	     String from = "hrms@sltl.com";
	     String pass ="hrms#123";
	    // Recipient's email ID needs to be mentioned.
	   String host = "smtp.gmail.com";
	   
	   System.out.println("akash");

	// 1st step) Get the session object
				Properties props = new Properties();
				// props.put("mail.smtp.starttls.enable", "true");
				props.put("mail.smtp.port", "587");
				
				props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
				
				props.setProperty("mail.transport.protocol", "smtps");
				props.put("mail.smtp.starttls.enable", "true");
				props.put("mail.smtp.host", host);
				props.put("mail.smtp.port", "587");
				props.put("mail.smtp.auth", "true");
				   
				   
				   
				props.put("mail.smtp.socketFactory.port", "587");  
				props.put("mail.smtp.socketFactory.class",  
					            "javax.net.ssl.SSLSocketFactory");  
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
				String link = "http://192.168.182.58:6018/HRMS/";
		        
				try {
					MimeMessage message = new MimeMessage(session);
					message.setFrom(new InternetAddress(from));// From Address
					message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));// To
					
					
					
					message.setSubject(sub);// MSG Subject
					// This mail has 2 part, the BODY and the embedded image
			         MimeMultipart multipart = new MimeMultipart("related");

			         // first part (the html)
			         BodyPart messageBodyPart = new MimeBodyPart();
			         BodyPart messageBodyPart1 = new MimeBodyPart();
			         
			         /**/
			         String  htmlText = "<html>";
			          
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
			          htmlText += "<td align=\"right\"><img src=\"https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcQjJkNWrO_pXGhZoAvyStzhRr70iS-ZdCO7JUoQivdyMWqbV0HtLQ\"\r\n" + 
			          		"								height=\"40px\" width=\"40px\"\r\n" + 
			          		"								class=\"CToWUd\"></td>";
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
			          htmlText += "<td><div class=\"a6S\" dir=\"ltr\" style=\"opacity: 0.01; left: 521.5px; top: 236px;\"> <div id=\":13q\" class=\"T-I J-J5-Ji aQv T-I-ax7 L3 a5q\"" + 
			          		"role=\"button\" tabindex=\"0\" aria-label=\"Download attachment \" data-tooltip-class=\"a1V\" data-tooltip=\"Download\"> <div class=\"aSK J-J5-Ji aYr\"></div>" + 
			          		"</div> </div></td>";
			          htmlText += "</tr>";
			          htmlText += "<tr>";
			          htmlText += "<td>";
			          htmlText += "<table cellpadding=\"15\" cellspacing=\"0\" border=\"0\" width=\"100%\">";
			          htmlText += "<tbody>";
			          htmlText += "<tr>";
			          htmlText += "<td> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 13px; color: #121212; line-height: 18px; padding-bottom: 10px\">" + 
			          		" Respected Sir,</p> "
			          		+ "<p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 13px; color: #121212; line-height: 18px\">" + 
			          		"  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;This is Notification E-mail.<br><br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <b>"+userName+"</b> register a complaint.</p>";
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
			          htmlText += "<tr>";
			          htmlText += "<td>";
			          htmlText += "<table cellpadding=\"10\" cellspacing=\"0\" border=\"0\" width=\"100%\" style=\"border: solid #f4f4f4 1px\">";
			          htmlText += "<tbody>";
			          
			          
			          
			         
			          htmlText += "<tr>";
			          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
			          		"<strong>Employee Code</strong> </p> </td>";
			          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
			          		""+emp_code+"</p> </td>";
			          htmlText += "</tr>";
			          
			          htmlText += "<tr>";
			          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
			          		" <strong>Department</strong> </p> </td>";
			          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
			          		" "+department+"</p> </td>";
			          htmlText += "</tr>";
			          
			          htmlText += "<tr>";
			          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
			          		"<strong>Employee Name</strong> </p> </td>";
			          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
			          		""+userName+"</p> </td>";
			          htmlText += "</tr>";
			          
			          htmlText += "<tr>";
			          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
			          		"<strong>Link </strong> </p> </td>";
			          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
			          		""+link1+"</p> </td>";
			          htmlText += "</tr>";
			          
			          
			          htmlText += "<tr>";
			          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
			          		"<strong>Date</strong> </p> </td>";
			          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
			          		""+complaint_date+"</p> </td>";
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
			          htmlText += "<table cellpadding=\"20\" cellspacing=\"0\" border=\"0\" width=\"100%\">";
			          htmlText += "<tbody>";
			          htmlText += "<tr>";
			          htmlText += "<td>";
			         
			          htmlText += "<p style=\"font-size: 13px; padding: 0px; margin: 0px; padding-left: 5px; line-height: 20px; color: #121212; text-align: center\">For Login into HRMS <a href=\"http://192.168.182.58:6018/HRMS/\"><button style=\" background-color: white; color: black; border: 2px solid #337ab7;\">Login</button></a> </p>";
			          htmlText += "<br>";
			          htmlText += "<p align=\"center\" style=\"font-size: 11px; padding: 0px; margin: 0px; line-height: 13px; color: red; padding-bottom: 10px\"><b>Note : This button will work only when you are connected to SLTL Intranet.</b></p>";
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
			          
				        /* String htmlText = type+"<br>"+query+"<br>"+code;*/
				         htmlText += "<br><br><br>";
				         htmlText += "<img src=\"cid:image\"><br><b>"+body+"</b><br><b>"+body1+"</b><br><b>"+body2+"</b><br><b>"+body3+"</b><br><b>"+body4+"</b>";
				         messageBodyPart.setContent(htmlText, "text/html");
				         // add it
				         multipart.addBodyPart(messageBodyPart);

				         // second part (the image)
				         messageBodyPart = new MimeBodyPart();
				         DataSource fds = new FileDataSource("D:/hrms/upload/img/sltllogo.png");

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

	public static void announcementDepartmentSend(String to,String sub,String to_time,String from_time,String announcement_date,int emp_code,String announcement_description, String userName,String announcment_title,String announced_by,String department_name) {      // Leave Approve Reject Mail
		 
		// Sender's email ID needs to be mentioned
	     String from = "hrms@sltl.com";
	     String pass ="hrms#123";
	    // Recipient's email ID needs to be mentioned.
	   String host = "smtp.gmail.com";
	   
	// 1st step) Get the session object
				Properties props = new Properties();
				// props.put("mail.smtp.starttls.enable", "true");
				
				props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
				
				props.setProperty("mail.transport.protocol", "smtps");
				props.put("mail.smtp.starttls.enable", "true");
				props.put("mail.smtp.host", host);
				props.put("mail.smtp.port", "587");
				props.put("mail.smtp.auth", "true");
				   
				   
				   
				props.put("mail.smtp.socketFactory.port", "587");  
				props.put("mail.smtp.starttls.enable", "true");
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
			String link = "http://192.168.182.58:6018/HRMS/";
			
			try {
				MimeMessage message = new MimeMessage(session);
				message.setFrom(new InternetAddress(from));// From Address
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));// To
				
				message.setSubject(sub);// MSG Subject
				// This mail has 2 part, the BODY and the embedded image
		         MimeMultipart multipart = new MimeMultipart("related");

		         // first part (the html)
		         BodyPart messageBodyPart = new MimeBodyPart();
		         BodyPart messageBodyPart1 = new MimeBodyPart();
		         
		         /**/
		         
		         String  htmlText = "<html>";
		          
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
		          htmlText += "<td align=\"right\"><img src=\"https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcQjJkNWrO_pXGhZoAvyStzhRr70iS-ZdCO7JUoQivdyMWqbV0HtLQ\"\r\n" + 
		          		"								height=\"40px\" width=\"40px\"\r\n" + 
		          		"								class=\"CToWUd\"></td>";
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
		          htmlText += "<td><div class=\"a6S\" dir=\"ltr\" style=\"opacity: 0.01; left: 521.5px; top: 236px;\"> <div id=\":13q\" class=\"T-I J-J5-Ji aQv T-I-ax7 L3 a5q\"" + 
		          		"role=\"button\" tabindex=\"0\" aria-label=\"Download attachment \" data-tooltip-class=\"a1V\" data-tooltip=\"Download\"> <div class=\"aSK J-J5-Ji aYr\"></div>" + 
		          		"</div> </div></td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td>";
		          htmlText += "<table cellpadding=\"15\" cellspacing=\"0\" border=\"0\" width=\"100%\">";
		          htmlText += "<tbody>";
		          htmlText += "<tr>";
		          htmlText += "<td> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 13px; color: #121212; line-height: 18px; padding-bottom: 10px\">" + 
		          		" Dear "+userName+", </p> "
		          		+ "<p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 13px; color: #121212; line-height: 18px\">" + 
		          		"  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Broadcast <b>"+department_name+"</b> Departmnet .</p>";
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
		          htmlText += "<tr>";
		          htmlText += "<td>";
		          htmlText += "<table cellpadding=\"10\" cellspacing=\"0\" border=\"0\" width=\"100%\" style=\"border: solid #f4f4f4 1px\">";
		          htmlText += "<tbody>";
		          htmlText += "<tr>";
		          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">" + 
		          		" <strong>Employee Code </strong> </p> </td>";
		          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 14px; color: #121212; line-height: 13px\">"+emp_code+"</p></td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" <strong>Broadcast Title</strong> </p> </td>";
		          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" "+announcment_title+"</p> </td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" <strong>Broadcast Description</strong> </p> </td>";
		          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" "+announcement_description+"</p> </td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" <strong>Broadcast for date</strong> </p> </td>";
		          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" "+announcement_date+"</p> </td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		"<strong>From Time</strong> </p> </td>";
		          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		""+from_time+"</p> </td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" <strong>To Time</strong> </p> </td>";
		          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" "+to_time+"</p> </td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" <strong>Broadcast Done by</strong> </p> </td>";
		          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" "+announced_by+"</p> </td>";
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
		          htmlText += "<table cellpadding=\"20\" cellspacing=\"0\" border=\"0\" width=\"100%\">";
		          htmlText += "<tbody>";
		          htmlText += "<tr>";
		          htmlText += "<td>";
		          htmlText += "<p style=\"font-size: 13px; padding: 0px; margin: 0px; padding-left: 5px; line-height: 20px; color: #121212; text-align: center\">For Login into HRMS <a href=\"http://192.168.182.58:6018/HRMS/\"><button style=\" background-color: white; color: black; border: 2px solid #337ab7;\">Login</button></a> </p>";
		          htmlText += "<br>";
		          htmlText += "<p align=\"center\" style=\"font-size: 11px; padding: 0px; margin: 0px; line-height: 13px; color: red; padding-bottom: 10px\"><b>Note : This button will work only when you are connected to SLTL Intranet.</b></p>";
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
		          htmlText += "<td><p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 13px; color: #121212; line-height: 20px; padding-bottom: 10px\"> For any queries or concerns, contact us on <b>313</b>.</p></td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td>";
		          htmlText += "<p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 13px; color: #121212; line-height: 20px\"> Regards,<br> Team HRMS </p>";
		          htmlText += "<br><p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 11px; color: #333; line-height: 20px; font-style: italic\">* This is an automated e-mail alert to help you to know about your leave. Hence, Please do not reply to this e-mail.</p>";
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
		          
		        /* String htmlText = type+"<br>"+query+"<br>"+code;*/
		        //  htmlText += "<br><br><br>";
		        // htmlText += "<img src=\"cid:image\"><br><b>"+body+"</b><br><b>"+body1+"</b><br><b>"+body2+"</b><br><b>"+body3+"</b><br><b>"+body4+"</b>";
		         messageBodyPart.setContent(htmlText, "text/html");
		         // add it
		         multipart.addBodyPart(messageBodyPart);

		         // second part (the image)
		         messageBodyPart = new MimeBodyPart();
		         DataSource fds = new FileDataSource(
		            "D:/hrms/upload/img/sltllogo.png");

		         messageBodyPart.setDataHandler(new DataHandler(fds));
		         messageBodyPart.setHeader("Content-ID", "<image>");

		         // add image to the multipart
		         multipart.addBodyPart(messageBodyPart);
		         
		        
		         message.setContent(multipart);
		         
				// 3rd step)send message
				Transport.send(message);

				System.out.println("Done : "+to);

			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
			
			
		 
	 }
	public static void announcementCompanySend(String to,String sub,String to_time,String from_time,String announcement_date,int emp_code,String announcement_description, String userName,String announcment_title,String announced_by,String department_name,String company_name) {      // Leave Approve Reject Mail
		 
		// Sender's email ID needs to be mentioned
	     String from = "hrms@sltl.com";
	     String pass ="hrms#123";
	    // Recipient's email ID needs to be mentioned.
	   String host = "smtp.gmail.com";
	   
	   
	   
	   
	// 1st step) Get the session object
				Properties props = new Properties();
				// props.put("mail.smtp.starttls.enable", "true");
				
				props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
				
				props.setProperty("mail.transport.protocol", "smtps");
				props.put("mail.smtp.starttls.enable", "true");
				props.put("mail.smtp.host", host);
				props.put("mail.smtp.port", "587");
				props.put("mail.smtp.auth", "true");
				   
				   
				   
				props.put("mail.smtp.socketFactory.port", "587");  
				props.put("mail.smtp.starttls.enable", "true");
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
			String link = "http://192.168.182.58:6018/HRMS/";
			
			try {
				MimeMessage message = new MimeMessage(session);
				message.setFrom(new InternetAddress(from));// From Address
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));// To
				
				message.setSubject(sub);// MSG Subject
				// This mail has 2 part, the BODY and the embedded image
		         MimeMultipart multipart = new MimeMultipart("related");

		         // first part (the html)
		         BodyPart messageBodyPart = new MimeBodyPart();
		         BodyPart messageBodyPart1 = new MimeBodyPart();
		         
		         /**/
		         
		         String  htmlText = "<html>";
		          
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
		          htmlText += "<td align=\"right\"><img src=\"https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcQjJkNWrO_pXGhZoAvyStzhRr70iS-ZdCO7JUoQivdyMWqbV0HtLQ\"\r\n" + 
		          		"								height=\"40px\" width=\"40px\"\r\n" + 
		          		"								class=\"CToWUd\"></td>";
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
		          htmlText += "<td><div class=\"a6S\" dir=\"ltr\" style=\"opacity: 0.01; left: 521.5px; top: 236px;\"> <div id=\":13q\" class=\"T-I J-J5-Ji aQv T-I-ax7 L3 a5q\"" + 
		          		"role=\"button\" tabindex=\"0\" aria-label=\"Download attachment \" data-tooltip-class=\"a1V\" data-tooltip=\"Download\"> <div class=\"aSK J-J5-Ji aYr\"></div>" + 
		          		"</div> </div></td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td>";
		          htmlText += "<table cellpadding=\"15\" cellspacing=\"0\" border=\"0\" width=\"100%\">";
		          htmlText += "<tbody>";
		          htmlText += "<tr>";
		          htmlText += "<td> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 13px; color: #121212; line-height: 18px; padding-bottom: 10px\">" + 
		          		" Dear "+userName+", </p> "
		          		+ "<p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 13px; color: #121212; line-height: 18px\">" + 
		          		"  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Broadcast for <b>"+department_name+"</b> Departmnet and <b> "+company_name+" Comapany</b> .</p>";
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
		          htmlText += "<tr>";
		          htmlText += "<td>";
		          htmlText += "<table cellpadding=\"10\" cellspacing=\"0\" border=\"0\" width=\"100%\" style=\"border: solid #f4f4f4 1px\">";
		          htmlText += "<tbody>";
		          htmlText += "<tr>";
		          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">" + 
		          		" <strong>Employee Code </strong> </p> </td>";
		          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 14px; color: #121212; line-height: 13px\">"+emp_code+"</p></td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" <strong>Broadcast Title</strong> </p> </td>";
		          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" "+announcment_title+"</p> </td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" <strong>Broadcast Description</strong> </p> </td>";
		          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" "+announcement_description+"</p> </td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" <strong>Broadcast for date</strong> </p> </td>";
		          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" "+announcement_date+"</p> </td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		"<strong>From Time</strong> </p> </td>";
		          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		""+from_time+"</p> </td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" <strong>To Time</strong> </p> </td>";
		          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" "+to_time+"</p> </td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" <strong>Broadcast Done by</strong> </p> </td>";
		          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" "+announced_by+"</p> </td>";
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
		          htmlText += "<table cellpadding=\"20\" cellspacing=\"0\" border=\"0\" width=\"100%\">";
		          htmlText += "<tbody>";
		          htmlText += "<tr>";
		          htmlText += "<td>";
		          htmlText += "<p style=\"font-size: 13px; padding: 0px; margin: 0px; padding-left: 5px; line-height: 20px; color: #121212; text-align: center\">For Login into HRMS <a href=\"http://192.168.182.58:6018/HRMS/\"><button style=\" background-color: white; color: black; border: 2px solid #337ab7;\">Login</button></a> </p>";
		          htmlText += "<br>";
		          htmlText += "<p align=\"center\" style=\"font-size: 11px; padding: 0px; margin: 0px; line-height: 13px; color: red; padding-bottom: 10px\"><b>Note : This button will work only when you are connected to SLTL Intranet.</b></p>";
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
		          htmlText += "<td><p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 13px; color: #121212; line-height: 20px; padding-bottom: 10px\"> For any queries or concerns, contact us on <b>313</b>.</p></td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td>";
		          htmlText += "<p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 13px; color: #121212; line-height: 20px\"> Regards,<br> Team HRMS </p>";
		          htmlText += "<br><p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 11px; color: #333; line-height: 20px; font-style: italic\">* This is an automated e-mail alert to help you to know about your leave. Hence, Please do not reply to this e-mail.</p>";
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
		          
		        /* String htmlText = type+"<br>"+query+"<br>"+code;*/
		        //  htmlText += "<br><br><br>";
		        // htmlText += "<img src=\"cid:image\"><br><b>"+body+"</b><br><b>"+body1+"</b><br><b>"+body2+"</b><br><b>"+body3+"</b><br><b>"+body4+"</b>";
		         messageBodyPart.setContent(htmlText, "text/html");
		         // add it
		         multipart.addBodyPart(messageBodyPart);

		         // second part (the image)
		         messageBodyPart = new MimeBodyPart();
		         DataSource fds = new FileDataSource(
		            "D:/hrms/upload/img/sltllogo.png");

		         messageBodyPart.setDataHandler(new DataHandler(fds));
		         messageBodyPart.setHeader("Content-ID", "<image>");

		         // add image to the multipart
		         multipart.addBodyPart(messageBodyPart);
		         
		        
		         message.setContent(multipart);
		         
				// 3rd step)send message
				Transport.send(message);

				System.out.println("Done : "+to);

			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
	}
	
	public static void announcementRolecategorySend(String to,String sub,String to_time,String from_time,String announcement_date,int emp_code,String announcement_description, String userName,String announcment_title,String announced_by,String department_name,String role_category_name) {      // Leave Approve Reject Mail
		 
		// Sender's email ID needs to be mentioned
	     String from = "hrms@sltl.com";
	     String pass ="hrms#123";
	    // Recipient's email ID needs to be mentioned.
	   String host = "smtp.gmail.com";
	   
	   
	   
	   
	// 1st step) Get the session object
				Properties props = new Properties();
				// props.put("mail.smtp.starttls.enable", "true");
				
				props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
				
				props.setProperty("mail.transport.protocol", "smtps");
				props.put("mail.smtp.starttls.enable", "true");
				props.put("mail.smtp.host", host);
				props.put("mail.smtp.port", "587");
				props.put("mail.smtp.auth", "true");
				   
				   
				   
				props.put("mail.smtp.socketFactory.port", "587");  
				props.put("mail.smtp.starttls.enable", "true");
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
			String link = "http://192.168.182.58:6018/HRMS/";
			
			try {
				MimeMessage message = new MimeMessage(session);
				message.setFrom(new InternetAddress(from));// From Address
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));// To
				
				message.setSubject(sub);// MSG Subject
				// This mail has 2 part, the BODY and the embedded image
		         MimeMultipart multipart = new MimeMultipart("related");

		         // first part (the html)
		         BodyPart messageBodyPart = new MimeBodyPart();
		         BodyPart messageBodyPart1 = new MimeBodyPart();
		         
		         /**/
		         
		         String  htmlText = "<html>";
		          
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
		          htmlText += "<td align=\"right\"><img src=\"https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcQjJkNWrO_pXGhZoAvyStzhRr70iS-ZdCO7JUoQivdyMWqbV0HtLQ\"\r\n" + 
		          		"								height=\"40px\" width=\"40px\"\r\n" + 
		          		"								class=\"CToWUd\"></td>";
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
		          htmlText += "<td><div class=\"a6S\" dir=\"ltr\" style=\"opacity: 0.01; left: 521.5px; top: 236px;\"> <div id=\":13q\" class=\"T-I J-J5-Ji aQv T-I-ax7 L3 a5q\"" + 
		          		"role=\"button\" tabindex=\"0\" aria-label=\"Download attachment \" data-tooltip-class=\"a1V\" data-tooltip=\"Download\"> <div class=\"aSK J-J5-Ji aYr\"></div>" + 
		          		"</div> </div></td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td>";
		          htmlText += "<table cellpadding=\"15\" cellspacing=\"0\" border=\"0\" width=\"100%\">";
		          htmlText += "<tbody>";
		          htmlText += "<tr>";
		          htmlText += "<td> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 13px; color: #121212; line-height: 18px; padding-bottom: 10px\">" + 
		          		" Dear "+userName+", </p> "
		          		+ "<p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 13px; color: #121212; line-height: 18px\">" + 
		          		"  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Broadcast <b>"+role_category_name+"</b> Category.</p>";
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
		          htmlText += "<tr>";
		          htmlText += "<td>";
		          htmlText += "<table cellpadding=\"10\" cellspacing=\"0\" border=\"0\" width=\"100%\" style=\"border: solid #f4f4f4 1px\">";
		          htmlText += "<tbody>";
		          htmlText += "<tr>";
		          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">" + 
		          		" <strong>Employee Code </strong> </p> </td>";
		          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 14px; color: #121212; line-height: 13px\">"+emp_code+"</p></td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" <strong>Broadcast Title</strong> </p> </td>";
		          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" "+announcment_title+"</p> </td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" <strong>Broadcast Description</strong> </p> </td>";
		          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" "+announcement_description+"</p> </td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" <strong>Broadcast for date</strong> </p> </td>";
		          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" "+announcement_date+"</p> </td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		"<strong>From Time</strong> </p> </td>";
		          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		""+from_time+"</p> </td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" <strong>To Time</strong> </p> </td>";
		          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" "+to_time+"</p> </td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td style=\"border-right: solid #f4f4f4 1px; border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" <strong>Broadcast Done by</strong> </p> </td>";
		          htmlText += "<td style=\"border-bottom: solid #f4f4f4 1px\"> <p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 12px; color: #121212; line-height: 13px\">\r\n" + 
		          		" "+announced_by+"</p> </td>";
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
		          htmlText += "<table cellpadding=\"20\" cellspacing=\"0\" border=\"0\" width=\"100%\">";
		          htmlText += "<tbody>";
		          htmlText += "<tr>";
		          htmlText += "<td>";
		          htmlText += "<p style=\"font-size: 13px; padding: 0px; margin: 0px; padding-left: 5px; line-height: 20px; color: #121212; text-align: center\">For Login into HRMS <a href=\"http://192.168.182.58:6018/HRMS/\"><button style=\" background-color: white; color: black; border: 2px solid #337ab7;\">Login</button></a> </p>";
		          htmlText += "<br>";
		          htmlText += "<p align=\"center\" style=\"font-size: 11px; padding: 0px; margin: 0px; line-height: 13px; color: red; padding-bottom: 10px\"><b>Note : This button will work only when you are connected to SLTL Intranet.</b></p>";
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
		          htmlText += "<td><p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 13px; color: #121212; line-height: 20px; padding-bottom: 10px\"> For any queries or concerns, contact us on <b>313</b>.</p></td>";
		          htmlText += "</tr>";
		          htmlText += "<tr>";
		          htmlText += "<td>";
		          htmlText += "<p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 13px; color: #121212; line-height: 20px\"> Regards,<br> Team HRMS </p>";
		          htmlText += "<br><p style=\"margin: 0; padding: 0px; font-family: arial; font-size: 11px; color: #333; line-height: 20px; font-style: italic\">* This is an automated e-mail alert to help you to know about your leave. Hence, Please do not reply to this e-mail.</p>";
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
		          
		        /* String htmlText = type+"<br>"+query+"<br>"+code;*/
		        //  htmlText += "<br><br><br>";
		        // htmlText += "<img src=\"cid:image\"><br><b>"+body+"</b><br><b>"+body1+"</b><br><b>"+body2+"</b><br><b>"+body3+"</b><br><b>"+body4+"</b>";
		         messageBodyPart.setContent(htmlText, "text/html");
		         // add it
		         multipart.addBodyPart(messageBodyPart);

		         // second part (the image)
		         messageBodyPart = new MimeBodyPart();
		         DataSource fds = new FileDataSource(
		            "D:/hrms/upload/img/sltllogo.png");

		         messageBodyPart.setDataHandler(new DataHandler(fds));
		         messageBodyPart.setHeader("Content-ID", "<image>");

		         // add image to the multipart
		         multipart.addBodyPart(messageBodyPart);
		         
		        
		         message.setContent(multipart);
		         
				// 3rd step)send message
				Transport.send(message);

				System.out.println("Done : "+to);

			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
			
			
	
	}
	
}
