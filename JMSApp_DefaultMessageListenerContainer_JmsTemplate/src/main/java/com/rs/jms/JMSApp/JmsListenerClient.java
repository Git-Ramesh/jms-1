package com.rs.jms.JMSApp;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

import org.apache.activemq.command.ActiveMQQueue;
//Receive the messages using JMS Template
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;

public class JmsListenerClient {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		JmsTemplate jmsTemplate = null;
		ActiveMQQueue destination = null;
		
		System.out.println("Message Listener started");
		ctx = new ClassPathXmlApplicationContext("com/rs/commons/applicationContext.xml");
		jmsTemplate = ctx.getBean("jmsTemplate", JmsTemplate.class);
		destination = ctx.getBean("destination", ActiveMQQueue.class);
		System.out.println("Waiting for message...");
		Message message = jmsTemplate.receive(destination);
		System.out.println("Message Received");
		if(message instanceof TextMessage) {
			TextMessage textMessage = (TextMessage)message;
			try {
				System.out.println(textMessage.getText());
			}catch(JMSException jex) {
				jex.printStackTrace();
			}
		}
	}

}
