package com.rs.producer;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.json.JSONObject;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class Producer {
    private JmsTemplate jmsTemplate ;

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
    
	public void sendMessage() {
		MessageCreator messageCreator = new MessageCreator() {
			
			public Message createMessage(Session session) throws JMSException {
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("name", "Ramesh");
				jsonObject.put("age", 22);
				
				TextMessage textMessage = session.createTextMessage(jsonObject.toString());
				textMessage.setStringProperty("message", "Hello Message");
				
				return textMessage;
			}
		};
		jmsTemplate.send(messageCreator);
	}
    
}
