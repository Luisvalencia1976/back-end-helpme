package co.edu.iudigital.app.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.MimeMessageHelper;

import co.edu.iudigital.app.service.iface.IEmailService;

//***@Service PERMITE USAR UN SERVICIO AUTOMATICAMENTE***//
@Service
public class EmailServiceImpl implements IEmailService{

	private static final Logger log = LoggerFactory.getLogger(EmailServiceImpl.class);
	//***@Autowired SE USA PARA INYECTAR LAS DEPENDENCIAS***//
	@Autowired
	private JavaMailSender sender;
	
	@Override
	public boolean sendEmail (String message, String to, String subject) {
		log.info("Message {}", message);
		return sendMailTool(message, to, subject);
	}
	
	private boolean sendMailTool(String message, String to, String subject) {
		boolean sent = false;
		MimeMessage msg = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(msg);
		try {
			helper.setFrom("noreply@iudigital.edu.co");
			helper.setTo(to);
			helper.setText(message, true);
			helper.setSubject(subject);
			sender.send(msg);
			sent = true;
		} catch (MessagingException e) {
			log.error("Error {}", e);
		}
		return sent;
	}
}