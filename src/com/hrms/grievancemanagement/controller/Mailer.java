package com.hrms.grievancemanagement.controller;

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

	public static void send(String subject, String type ,String query,int code,String attachment,String candidateName,List<String> email) {      // GRIEVANCE QUERY MAIL 
		 
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
				
				for(String cc : email){
					if(cc==email.get(0) ){
						message.addRecipient(Message.RecipientType.TO, new InternetAddress(cc));
					}else{
						message.addRecipient(Message.RecipientType.CC, new InternetAddress(cc));// CC
					}
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
		          htmlText += "<link href=\"bower_components/bootstrap/dist/css/bootstrap.min.css\" rel=\"stylesheet\">";
		          htmlText += "<link href=\"bower_components/bootstrap/dist/css/bootstrap.css\" rel=\"stylesheet\">";
		          htmlText += "</head>";
		          
		          htmlText += "<body>";
		          htmlText += "<br>";
		          htmlText += "<fieldset>";
		          htmlText += "<legend><h4>Grievance Management</h4></legend>";
		          htmlText += "<table class=\"table table-striped table-bordered table-hover\">";
		          
		          htmlText += "<tbody>";
		          htmlText += "<tr>";
		          htmlText += "<th align=\"left\"> Employee Code </th>";
		          htmlText += "<td>:</td>";
		          
		          htmlText += "<td>"+code+"</td>";
		          htmlText += "</tr>";
		          htmlText += "</tbody>";
		          
		          htmlText += "<tbody>";
		          htmlText += "<tr>";
		          htmlText += "<th align=\"left\"> Type </th>";
		          htmlText += "<td>:</td>";
		          htmlText += "<td>"+type+"</td>";
		          htmlText += "</tr>";
		          htmlText += "</tbody>";
		          
		          htmlText += "<tbody>";
		          htmlText += "<tr>";
		          htmlText += "<th align=\"left\"> Query </th>";
		          htmlText += "<td>:</td>";
		          htmlText += "<td>"+query+"</td>";
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
		            "D:/hrms/upload/img/sltllogo.png");

		         messageBodyPart.setDataHandler(new DataHandler(fds));
		         messageBodyPart.setHeader("Content-ID", "<image>");

		         // add image to the multipart
		         multipart.addBodyPart(messageBodyPart);
		         
		        
				 if(!attachment.equalsIgnoreCase("")){
				messageBodyPart1 = new MimeBodyPart();
		        String filename = attachment ;
		        DataSource source = new FileDataSource("D://hrms//upload//grievance//"+filename);
		        messageBodyPart1.setDataHandler(new DataHandler(source));
		        messageBodyPart1.setFileName(filename);
		        multipart.addBodyPart(messageBodyPart1);
				 }

		         message.setContent(multipart);
		         
				// 3rd step)send message
				Transport.send(message);

				System.out.println("Done");

			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
			
			
		 
	 }
	
	
	
	public static void send2(String subject, String type ,String query,int code,String attachment,String candidateName,String to) {      // GRIEVANCE QUERY MAIL 
		 
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
				
						message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
						
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
		          htmlText += "<legend><h4>Grievance Management</h4></legend>";
		          htmlText += "<table class=\"table table-striped table-bordered table-hover\">";
		          
		          htmlText += "<tbody>";
		          htmlText += "<tr>";
		          htmlText += "<th align=\"left\"> Employee Code </th>";
		          htmlText += "<td>:</td>";
		          
		          htmlText += "<td>"+code+"</td>";
		          htmlText += "</tr>";
		          htmlText += "</tbody>";
		          
		          htmlText += "<tbody>";
		          htmlText += "<tr>";
		          htmlText += "<th align=\"left\"> Type </th>";
		          htmlText += "<td>:</td>";
		          htmlText += "<td>"+type+"</td>";
		          htmlText += "</tr>";
		          htmlText += "</tbody>";
		          
		          htmlText += "<tbody>";
		          htmlText += "<tr>";
		          htmlText += "<th align=\"left\"> Query </th>";
		          htmlText += "<td>:</td>";
		          htmlText += "<td>"+query+"</td>";
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
		            "D:/hrms/upload/img/sltllogo.png");

		         messageBodyPart.setDataHandler(new DataHandler(fds));
		         messageBodyPart.setHeader("Content-ID", "<image>");

		         // add image to the multipart
		         multipart.addBodyPart(messageBodyPart);
		         
		        
				 if(!attachment.equalsIgnoreCase("")){
				messageBodyPart1 = new MimeBodyPart();
		        String filename = attachment ;
		        DataSource source = new FileDataSource("D://hrms//upload//grievance//"+filename);
		        messageBodyPart1.setDataHandler(new DataHandler(source));
		        messageBodyPart1.setFileName(filename);
		        multipart.addBodyPart(messageBodyPart1);
				 }

		         message.setContent(multipart);
		         
				// 3rd step)send message
				Transport.send(message);

				System.out.println("Done");

			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
			
			
		 
	 }
	
	
	
	public static void send1(String to, String subject, String reply ,String query,String attachment) {      // GRIEVANCE REPLY MAIL	
		 
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
																						// Address
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
		          htmlText += "<legend><h4>Grievance Management</h4></legend>";
		          htmlText += "<table class=\"table table-striped table-bordered table-hover\">";
		          
		          
		          htmlText += "<tbody>";
		          htmlText += "<tr>";
		          htmlText += "<th align=\"left\"> Query </th>";
		          htmlText += "<td>:</td>";
		          htmlText += "<td>"+query+"</td>";
		          htmlText += "</tr>";
		          htmlText += "</tbody>";
		          
		          
		          htmlText += "<tbody>";
		          htmlText += "<tr>";
		          htmlText += "<th align=\"left\"> Reply </th>";
		          htmlText += "<td>:</td>";
		          htmlText += "<td>"+reply+"</td>";
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
		            "D:/hrms/upload/img/sltllogo.png");

		         messageBodyPart.setDataHandler(new DataHandler(fds));
		         messageBodyPart.setHeader("Content-ID", "<image>");

		         // add image to the multipart
		         multipart.addBodyPart(messageBodyPart);
		         
		        
				 if(!attachment.equalsIgnoreCase("")){
				messageBodyPart1 = new MimeBodyPart();
		        String filename = attachment ;
		        DataSource source = new FileDataSource("D://hrms//upload//grievance//"+filename);
		        messageBodyPart1.setDataHandler(new DataHandler(source));
		        messageBodyPart1.setFileName(filename);
		        multipart.addBodyPart(messageBodyPart1);
				 }

		         message.setContent(multipart);
		         
				// 3rd step)send message
				Transport.send(message);

				System.out.println("Done");

			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
			
			
		 
	 }

	
}
