package com.aashutoshanand.CowinAlert.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class EmailTriggerService {

	@Value("${from.Email}")
	private String senderEmail;

	@Value("${to.Email}")
	private String receiverEmail;

	@Autowired
	private JavaMailSender javaMailSender;

	public void triggerEmail(String message) {
		// String text = "Hello. Welcome to the future!";
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom(senderEmail);
		mailMessage.setTo(receiverEmail);
		mailMessage.setSubject("testEmail");
		mailMessage.setText(message);
		javaMailSender.send(mailMessage);
	}
}
