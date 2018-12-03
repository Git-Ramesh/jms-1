package com.rs.jms.listener;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class MessageListenerImpl implements MessageListener{
	@Override
	public void onMessage(Message message) {
		System.out.println("onMessage(message)");
		TextMessage textMessage = null;
		MapMessage mapMessage = null;
		System.out.println("Message Listener..");
		//TextMessage textMessage = (TextMessage) message;
		if(message instanceof TextMessage) {
			textMessage = (TextMessage) message;
		}
		else if(message instanceof MapMessage) {
			// TODO MapMessage related handling
		}
		try {
			System.out.println(textMessage.getText());
			System.out.println("MessageReceived");
		} catch(JMSException jex) {
			jex.printStackTrace();
		}
	}
}