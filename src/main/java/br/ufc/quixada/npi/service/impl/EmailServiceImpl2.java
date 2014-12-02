package br.ufc.quixada.npi.service.impl;


import java.util.Properties;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.MailException;
import org.springframework.mail.MailMessage;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Named
public class EmailServiceImpl2 {
	
	@Inject
	private MailSender mailSender;

	private BlockingQueue<MailMessage> queue = new LinkedBlockingQueue<MailMessage>();
	
	private Thread thread;
	
	private boolean stop;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public void start() {
		thread = new Thread( new Runnable() {
			@Override
			public void run() {
				stop = false;
				while(!stop) {
					try {
						if (!queue.isEmpty()) {
							SimpleMailMessage message = (SimpleMailMessage)queue.take();
							logger.info("Sending mail To: {}, Subject: {}", message.getTo(), message.getSubject());
							mailSender.send(message);
							logger.info("Mail sent To: {}, Subject: {}", message.getTo(), message.getSubject());
						}
						Thread.sleep(1000);
					} catch (MailException e) {
						e.printStackTrace();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		thread.start();
	}
	
	public void stop() {
		stop = true;
	}
	
	public void sendMail(MailMessage message) {
		queue.add(message);
	}
	
	public void sendMail(String to, String subject, String body) {
		MailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject(subject);
		message.setText(body);
		sendMail(message);
	}

	public static void main(String[] args) {
		EmailServiceImpl2 e = new EmailServiceImpl2();
		e.mailSender = new JavaMailSenderImpl();
		JavaMailSenderImpl ms = (JavaMailSenderImpl)e.mailSender; 
		ms.setHost("smtp.gmail.com");
		ms.setPort(587);
		ms.setUsername("user@gmail.com");
		ms.setPassword("passwd_user");
		Properties javaMailProperties = new Properties(); 
		javaMailProperties.put("mail.transport.protocol", "smtp");
		javaMailProperties.put("mail.smtp.auth", "true");
		javaMailProperties.put("mail.smtp.starttls.enable", "true");
		javaMailProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		javaMailProperties.put("mail.debug", "true");
		ms.setJavaMailProperties(javaMailProperties);
		e.start();
		e.sendMail("regismagalhaes@ufc.br", "teste subject", "teste body");
		//e.stop();
		
	}
	
}
