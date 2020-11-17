package com.sassine.mail;

import java.util.List;
import java.util.Objects;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class MailService {

	@Autowired
	private JavaMailSender javaMailSender;
	
	public void sendMail(Mail mail, List<MultipartFile> files) throws MailException, MessagingException{
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, !(Objects.isNull(files) || files.isEmpty()));
		helper.setTo(mail.getTo());
		helper.setSubject(mail.getSubject());
		helper.setText(mail.getBody());
		for(MultipartFile i : files) { helper.addAttachment(i.getOriginalFilename(), i); }
		javaMailSender.send(message);
	}
	
}
