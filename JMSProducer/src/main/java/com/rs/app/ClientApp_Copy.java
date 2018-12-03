package com.rs.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rs.producer.Producer;

public class ClientApp {
	
	public static void main(String[] args) {
		ApplicationContext ctx = null;
		Producer producer = null;
		
		ctx = new ClassPathXmlApplicationContext("com/rs/config/jms-context.xml");
		
		producer = ctx.getBean("producer", Producer.class);
		producer.sendMessage();
		System.out.println("Message has been sent..");
	}
}
