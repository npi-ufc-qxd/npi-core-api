package br.ufc.quixada.npi.service.impl;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.activation.DataSource;
import javax.inject.Inject;
import javax.inject.Named;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.util.ByteArrayDataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import br.ufc.quixada.npi.model.Attachment;
import br.ufc.quixada.npi.model.Email;
import br.ufc.quixada.npi.service.EmailService;

@Named
public class EmailServiceImpl implements EmailService {
	
	@Inject
	private JavaMailSender mailSender;
	
	private ExecutorService execService = Executors.newFixedThreadPool(5);
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public void setMailSender(JavaMailSenderImpl mailSender) {
		this.mailSender = mailSender;
	}

	public JavaMailSender getMailSender() {
		return mailSender;
	}

	/* (non-Javadoc)
	 * @see br.ufc.quixada.npi.service.impl.EmailService#sendEmail(br.ufc.quixada.npi.model.Email)
	 */
	@Override
	public void sendEmail(final Email email) throws MessagingException {
		final MimeMessage mimeMessage = mailSender.createMimeMessage();
		// use the true flag to indicate you need a multipart message
		boolean hasAttachments = (email.getAttachments() != null && email
				.getAttachments().size() > 0);
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,
				hasAttachments);
		helper.setTo(email.getTo());
		helper.setFrom(email.getFrom());
		helper.setSubject(email.getSubject());
		helper.setText(email.getText(), true);

		List<Attachment> attachments = email.getAttachments();
		if (attachments != null && attachments.size() > 0) {
			for (Attachment attachment : attachments) {
				String filename = attachment.getFilename();
				DataSource dataSource = new ByteArrayDataSource(
						attachment.getData(), attachment.getMimeType());
				if (attachment.isInline()) {
					helper.addInline(filename, dataSource);
				} else {
					helper.addAttachment(filename, dataSource);
				}
			}
		}
		execService.submit(new Runnable() {
			@Override
			public void run() {
				mailSender.send(mimeMessage);
				email.setSent(true);
				logger.info("Email sent successfully to {}. Subject: {}", email.getTo(), email.getSubject());
			}
		});
	}
	
	public void shutdown() {
		execService.shutdown();
	}
	
}