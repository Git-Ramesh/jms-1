package com.rs.consumer;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class Consumer implements MessageListener{

	@Override
	public void onMessage(Message message) {
		if(message instanceof TextMessage) {
			TextMessage textMessage = (TextMessage)message;
			try {
				System.out.println(textMessage.getText());
				System.out.println(textMessage.getStringProperty("message"));
			} catch(JMSException jmsEx) {
				jmsEx.printStackTrace();
			}
		
		}
	}
}
