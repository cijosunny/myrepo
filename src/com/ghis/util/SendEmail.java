package com.ghis.util;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.ghis.model.AppUser;

public class SendEmail {
	public static int sendEmail(String toEmail, String subject, String body) {

		//Get the session object
		  Properties props = new Properties();
		  props.put("mail.smtp.host", "smtp.gmail.com");
		  props.put("mail.smtp.socketFactory.port", "465");
		  props.put("mail.smtp.socketFactory.class",
		        	"javax.net.ssl.SSLSocketFactory");
		  props.put("mail.smtp.auth", "true");
		  props.put("mail.smtp.port", "465");
		 
		  Session session = Session.getDefaultInstance(props,
		   new javax.mail.Authenticator() {
		   protected PasswordAuthentication getPasswordAuthentication() {
		   return new PasswordAuthentication("testemail4hackathon@gmail.com","WalmartCareers");//change accordingly
		   }
		  });
		 
		//compose message
		  try {
		   MimeMessage message = new MimeMessage(session);
		   message.setFrom(new InternetAddress("testemail4hackathon@gmail.com","careers@walmart.com"));//change accordingly
		   message.addRecipients(Message.RecipientType.TO,InternetAddress.parse(toEmail));
		   message.setSubject(subject);
		   message.setText(body);
		   
		   //send message
		   Transport.send(message);

		   System.out.println("message sent successfully");
		   
		   return 1;
		 
		  } catch (MessagingException | UnsupportedEncodingException e) {return -1;} 
		 
		 }
	
	public static void main(String[] args) {
		org.hibernate.Session session1 = HibernateUtil.getSessionFactory().openSession();
		session1.beginTransaction();
 
		AppUser user = new AppUser("firstuser");
		session1.save(user);
 
		session1.getTransaction().commit();
		session1.close();
	}
}
