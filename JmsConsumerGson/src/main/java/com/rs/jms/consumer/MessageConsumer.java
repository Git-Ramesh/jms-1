package com.rs.jms.consumer;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component("messageConsumer")
public class MessageConsumer {
	private static Logger logger = LoggerFactory.getLogger(MessageConsumer.class);

	@JmsListener(destination = "Queue1")
	public void processMessage(Message message) throws JMSException {
		if (message instanceof TextMessage) {
			logger.info("TextMessage Found!");
			TextMessage textMessage = (TextMessage) message;
			System.out.println(textMessage);
			try {
				System.out.println(textMessage.getText());
			} catch (JMSException jex) {
				logger.error(jex.getMessage(), jex);
			}
		} else if (message instanceof MapMessage) {
			logger.info("MapMessage Found!");
		}
	}
}
