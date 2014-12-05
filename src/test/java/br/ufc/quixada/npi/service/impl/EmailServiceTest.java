package br.ufc.quixada.npi.service.impl;

import java.util.Properties;

import javax.mail.MessagingException;

import org.springframework.mail.javamail.JavaMailSenderImpl;

import br.ufc.quixada.npi.model.Email;
import br.ufc.quixada.npi.service.EmailService;

public class EmailServiceTest {

	public static void main(String[] args) {
		Email email = new Email();
		email.setFrom("user@gmail.com");
		email.setTo("regismagalhaes@ufc.br");
		email.setSubject("test subject2");
		email.setText("test body2");

		JavaMailSenderImpl ms = new JavaMailSenderImpl();
		ms.setHost("smtp.gmail.com");
		ms.setPort(587);
		ms.setUsername("user@gmail.com");
		ms.setPassword("passwd_user");

		Properties javaMailProperties = new Properties(); 
		javaMailProperties.put("mail.transport.protocol", "smtp");
		javaMailProperties.put("mail.smtp.auth", true);
		javaMailProperties.put("mail.smtp.starttls.enable", true);
		javaMailProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		javaMailProperties.put("mail.debug", "true");
		ms.setJavaMailProperties(javaMailProperties);
		
		EmailService es = new EmailServiceImpl();
		try {
			es.setMailSender(ms);
			es.sendEmail(email);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		es.shutdown();
		System.out.println("The end");
	}
	
}