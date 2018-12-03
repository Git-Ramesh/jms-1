package com.rs.jms.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class MessageListenerImpl2 implements MessageListener {

	@Override
	public void onMessage(Message message) {
		if (message instanceof TextMessage) {
			TextMessage textMessage = (TextMessage) message;
			try {
				System.out.println("Message Received: " + textMessage.getText());
			} catch (JMSException jme) {
				System.err.println("Failed to Receive  the message: " + jme.getMessage());
			}
		}
	}
}
