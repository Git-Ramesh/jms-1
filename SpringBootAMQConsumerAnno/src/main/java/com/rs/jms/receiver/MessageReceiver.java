package com.rs.jms.receiver;

import javax.jms.Message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {
	private static Logger logger = LoggerFactory.getLogger(MessageReceiver.class);

	public MessageReceiver() {
		logger.info("MessgaeReceiver: 0-param constr");
	}

	@JmsListener(destination = "Topic1")
	public void receiveMessage(Message message) {
		String line = "-------------------------------------------";
		System.out.println(line);
		System.out.println(message);
		System.out.println(line);
	}
}
