package com.hrms.pms.controller;

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

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;  
import javax.mail.internet.*;  
  
public class Mailer {  
	public static void send(String to, String subject, String msg, String desc1, String desc21, String desc31) { 
	 
	// Sender's email ID needs to be mentioned
     String from = "hrms@sltl.com";
     String pass ="hrms#123";
    // Recipient's email ID needs to be mentioned.
   String host = "smtp.gmail.com";

   // Get system properties
   Properties properties = System.getProperties();
   // Setup mail server
   properties.put("mail.smtp.starttls.enable", "true");
   properties.put("mail.smtp.host", host);
   properties.put("mail.smtp.user", from);
   properties.put("mail.smtp.password", pass);
   properties.put("mail.smtp.port", "587");
   properties.put("mail.smtp.auth", "true");
   
   
   
   properties.put("mail.smtp.socketFactory.port", "587");  
   properties.put("mail.smtp.socketFactory.class",  
	            "javax.net.ssl.SSLSocketFactory");  
   properties.put("mail.smtp.starttls.enable", "true");
   properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
   properties.put("mail.smtp.socketFactory.class", "javax.net.SocketFactory");
   properties.put("mail.smtp.ssl.enable", "false");
   properties.put("mail.smtp.ssl.trust", host);
   
   

   // Get the default Session object.
   Session session = Session.getDefaultInstance(properties);

   try{
      // Create a default MimeMessage object.
      MimeMessage message = new MimeMessage(session);

      // Set From: header field of the header.
      message.setFrom(new InternetAddress(from));

      // Set To: header field of the header.
      message.addRecipient(Message.RecipientType.TO,
                               new InternetAddress(to));

      // Set Subject: header field
      message.setSubject(subject);

      // Now set the actual message
      message.setContent(msg+"<br>"+desc1+"<br>"+desc21+"<br>"+desc31, "text/html");
      

      // Send message
      Transport transport = session.getTransport("smtp");
      transport.connect(host, from, pass);
      transport.sendMessage(message, message.getAllRecipients());
      transport.close();
      System.out.println(" Mail Sent successfully....");
   }catch (MessagingException mex) {
      mex.printStackTrace();
   }
	 
 }
	
	
	public static void send1(String to, String subject, int otp ) {      // OTP mail
		 
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
}
	
	

  


