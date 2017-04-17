package com.xuan.tools;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class EmailSender {
	private MailSender emailSender;

	public void setEmailSender(MailSender emailSender) {
		this.emailSender = emailSender;
	}

	public void sendEmail(String to, String subject, String msg) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject(subject);
		message.setText(msg);
		emailSender.send(message);
	}
}
