package com.rs.jms.JMSApp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JmsListenerClient {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		
		System.out.println("Message Listener started");
		ctx = new ClassPathXmlApplicationContext("com/rs/commons/applicationContext.xml");

		
	}

}
