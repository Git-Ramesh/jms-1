package com.rs.jms.JMSApp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rs.jms.listener.MessageProducer;

public class JmsSenderClient {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		MessageProducer messageProducer = null;

		System.out.println("Message Producer Started");
		ctx = new ClassPathXmlApplicationContext("com/rs/commons/JSMConfig.xml");
		messageProducer = ctx.getBean("messageProducer", MessageProducer.class);
		messageProducer.sendMessages();
		((AbstractApplicationContext) ctx).close();
	}

}	
