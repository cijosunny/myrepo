package com.cs.rest;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SendEmail {
	public static void sendEmail() {

		 String to="cijosunny@gmail.com";//change accordingly

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
		   message.setFrom(new InternetAddress("testemail4hackathon@gmail.com"));//change accordingly
		   message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
		   message.setSubject("Hello");
		   message.setText("Testing.......");
		   
		   //send message
		   Transport.send(message);

		   System.out.println("message sent successfully");
		 
		  } catch (MessagingException e) {throw new RuntimeException(e);}
		 
		 }
	
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		org.hibernate.Session session1 = sessionFactory.openSession();
		session1.beginTransaction();
 
		AppUser user = new AppUser("firstuser");
		session1.save(user);
 
		session1.getTransaction().commit();
		session1.close();
	}
}
