package br.ufc.quixada.npi.service;

import javax.mail.MessagingException;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import br.ufc.quixada.npi.model.Email;

public interface EmailService {

	public abstract void sendEmail(Email email) throws MessagingException;
	
	public abstract void setMailSender(JavaMailSenderImpl mailSender);

	public abstract JavaMailSender getMailSender();

	public abstract void shutdown();
}