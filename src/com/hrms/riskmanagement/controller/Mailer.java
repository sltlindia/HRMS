package com.hrms.riskmanagement.controller;

/*import java.util.*;

import javax.activation.*;
import javax.mail.*;
import javax.mail.internet.*;


public class Mailer {
	public static void send(String to, String subject, String msg) {

		final String user = "vacationrentalrmn@gmail.com";// change accordingly
		final String pass = "vacationrental079";

		// 1st step) Get the session object
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		// props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "465");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, pass);
			}
		});
		// 2nd step)compose message
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));// From Address
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));// To
																					// Address
			message.setSubject(subject);// MSG Subject
			message.setContent("<a href="+msg+">click here</a>", "text/html");// MSG BODY

			// 3rd step)send message
			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		
		
		final String user = "vacationrentalrmn@gmail.com";// change accordingly
		final String pass = "vacationrental079";

		// 1st step) Get the session object
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		// props.put("mail.smtp.starttls.enable", "true");
		//props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.host", "smtp.bizmail.yahoo.com");
		props.put("mail.smtp.port", "465");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, pass);
			}
		});
		// 2nd step)compose message
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));// From Address
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));// To
																					// Address
			message.setSubject(subject);// MSG Subject

			BodyPart messageBodyPart = new MimeBodyPart();
			
			messageBodyPart.setText(msg); 

			 Multipart multipart = new MimeMultipart();
			
			 multipart.addBodyPart(messageBodyPart);
			 
			 messageBodyPart = new MimeBodyPart();
	         String filename = "sachin.txt";
	         DataSource source = new FileDataSource("C://Users//Akash//Desktop//"+filename);
	         messageBodyPart.setDataHandler(new DataHandler(source));
	         messageBodyPart.setFileName(filename);
	         multipart.addBodyPart(messageBodyPart);
	         
	         message.setContent(multipart );
	         
			// 3rd step)send message
			Transport.send(message);
			
			

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		
		
		
		
		final String user = "vacationrentalrmn@gmail.com";// change accordingly
		final String pass = "vacationrental079";

		// 1st step) Get the session object
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		// props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "465");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, pass);
			}
		});
		// 2nd step)compose message
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));// From Address
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));// To
																					// Address
			message.setSubject(subject);// MSG Subject
			// This mail has 2 part, the BODY and the embedded image
	         MimeMultipart multipart = new MimeMultipart("related");

	         // first part (the html)
	         BodyPart messageBodyPart = new MimeBodyPart();
	         String htmlText = "<H1>Hello</H1><img src=\"cid:image\">";
	         messageBodyPart.setContent(htmlText, "text/html");
	         // add it
	         multipart.addBodyPart(messageBodyPart);

	         // second part (the image)
	         messageBodyPart = new MimeBodyPart();
	         DataSource fds = new FileDataSource(
	            "C:/Users/Akash/Desktop/sltllogo.png");

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

}
*/


import java.util.Properties;

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
	public static void send(String to, String subject, String msg, String desc,String mitigation_plan ,String person_for_mitigation,String contingency_plan,String person_for_contingency,String fallbackPlan) { 
		// Sender's email ID needs to be mentioned
	     String from = "hrms@sltl.com";
	     String pass ="hrms#123";
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
		          htmlText += "<link href=\"bower_components/bootstrap/dist/css/bootstrap.min.css\" rel=\"stylesheet\">";
		          htmlText += "<link href=\"bower_components/bootstrap/dist/css/bootstrap.css\" rel=\"stylesheet\">";
		          htmlText += "</head>";
		          
		          htmlText += "<body>";
		          htmlText += "<br>";
		          htmlText += "<fieldset>";
		          htmlText += "<table class=\"table table-striped table-bordered table-hover\">";
		          
		          htmlText += "<tbody>";
		          htmlText += "<tr>";
		          htmlText += "<th align=\"left\"> Subject </th>";
		          htmlText += "<td>:</td>";
		          
		          htmlText += "<td>"+msg+"</td>";
		          htmlText += "</tr>";
		          htmlText += "</tbody>";
		          
		          htmlText += "<tbody>";
		          htmlText += "<tr>";
		          htmlText += "<th align=\"left\"> Risk Description </th>";
		          htmlText += "<td>:</td>";
		          htmlText += "<td>"+desc+"</td>";
		          htmlText += "</tr>";
		          htmlText += "</tbody>";
		          
		          htmlText += "<tbody>";
		          htmlText += "<tr>";
		          htmlText += "<th align=\"left\"> Mitigation Plan </th>";
		          htmlText += "<td>:</td>";
		          htmlText += "<td>"+mitigation_plan+"</td>";
		          htmlText += "</tr>";
		          htmlText += "</tbody>";
		          
		          htmlText += "<tbody>";
		          htmlText += "<tr>";
		          htmlText += "<th align=\"left\"> Person Responsible for Mitigation Action Plan</th>";
		          htmlText += "<td>:</td>";
		          htmlText += "<td>"+person_for_mitigation+"</td>";
		          htmlText += "</tr>";
		          htmlText += "</tbody>";
		          
		          htmlText += "<tbody>";
		          htmlText += "<tr>";
		          htmlText += "<th align=\"left\"> Contingency Plan </th>";
		          htmlText += "<td>:</td>";
		          htmlText += "<td>"+contingency_plan+"</td>";
		          htmlText += "</tr>";
		          htmlText += "</tbody>";
		          
		          htmlText += "<tbody>";
		          htmlText += "<tr>";
		          htmlText += "<th align=\"left\"> Person Responsible for Contingency Action Plan </th>";
		          htmlText += "<td>:</td>";
		          htmlText += "<td>"+person_for_contingency+"</td>";
		          htmlText += "</tr>";
		          htmlText += "</tbody>";
		          
		          htmlText += "<tbody>";
		          htmlText += "<tr>";
		          htmlText += "<th align=\"left\"> Fall-Back Plan </th>";
		          htmlText += "<td>:</td>";
		          htmlText += "<td>"+fallbackPlan+"</td>";
		          htmlText += "</tr>";
		          htmlText += "</tbody>";
		          
		          htmlText += "</table>";
		          htmlText += "</fieldset>";
		        
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
		            "c:/hrms/upload/img/sltllogo.png");

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
			
		 

	public static void send1(String to1, String subject1, String msg1, String desc2, String action_plan) {
		// Sender's email ID needs to be mentioned
	     String from = "hrms@sltl.com";
	     String pass ="hrms#123";
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
	        
			try {
				MimeMessage message = new MimeMessage(session);
				message.setFrom(new InternetAddress(from));// From Address
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(to1));// To
				
				message.setSubject(subject1);// MSG Subject
				// This mail has 2 part, the BODY and the embedded image
		         MimeMultipart multipart = new MimeMultipart("related");

		         // first part (the html)
		         BodyPart messageBodyPart = new MimeBodyPart();
		         BodyPart messageBodyPart1 = new MimeBodyPart();
		         
		         /**/
		         
		          String  htmlText = "<html>";
		          
		          htmlText += "<head>";
		          htmlText += "<link href=\"bower_components/bootstrap/dist/css/bootstrap.min.css\" rel=\"stylesheet\">";
		          htmlText += "<link href=\"bower_components/bootstrap/dist/css/bootstrap.css\" rel=\"stylesheet\">";
		          htmlText += "</head>";
		          
		          htmlText += "<body>";
		          htmlText += "<br>";
		          htmlText += "<fieldset>";
		          htmlText += "<table class=\"table table-striped table-bordered table-hover\">";
		          
		          htmlText += "<tbody>";
		          htmlText += "<tr>";
		          htmlText += "<th align=\"left\"> Subject </th>";
		          htmlText += "<td>:</td>";
		          
		          htmlText += "<td>"+msg1+"</td>";
		          htmlText += "</tr>";
		          htmlText += "</tbody>";
		          
		          htmlText += "<tbody>";
		          htmlText += "<tr>";
		          htmlText += "<th align=\"left\"> Risk Description </th>";
		          htmlText += "<td>:</td>";
		          htmlText += "<td>"+desc2+"</td>";
		          htmlText += "</tr>";
		          htmlText += "</tbody>";
		          
		         htmlText += "<tbody>";
		          htmlText += "<tr>";
		          htmlText += "<th align=\"left\"> Action Plan </th>";
		          htmlText += "<td>:</td>";
		          htmlText += "<td>"+action_plan+"</td>";
		          htmlText += "</tr>";
		          htmlText += "</tbody>";
		          
		          htmlText += "</table>";
		          htmlText += "</fieldset>";
		        
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
		            "D:/workspace/HRMS/WebContent/img/sltllogo.png");

		         messageBodyPart.setDataHandler(new DataHandler(fds));
		         messageBodyPart.setHeader("Content-ID", "<image>");

		         // add image to the multi-part
		         multipart.addBodyPart(messageBodyPart);
		         message.setContent(multipart);
		         
					// 3rd step)send message
					Transport.send(message);

					System.out.println("Done");
			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
}

}
	

  


