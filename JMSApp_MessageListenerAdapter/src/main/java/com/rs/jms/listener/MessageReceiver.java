package com.rs.jms.listener;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessageReceiver {
	private static Logger logger = LoggerFactory.getLogger(MessageReceiver.class);

	public void processMessage(Map<?, ?> mapMessage) {
		logger.info("mapMessage found");
	}

	public void processMessage(String textMessage) {
		String line = "-------------------------------------------";
		logger.info("textMessage found");
		System.out.println(line);
		System.out.println(textMessage);
		System.out.println(line);
		
	}
}