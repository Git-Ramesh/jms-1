package com.rs.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.rs.config.AppConfig;
import com.rs.jms.producer.MessageProducer;
import com.rs.model.Employee;

public class App {
	private static Logger logger = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = null;
		MessageProducer producer = null;
		ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		logger.info("Producer started");
		producer = ctx.getBean("messageProducer", MessageProducer.class);
		producer.sendMessage(new Employee(110, "Ramesh"));
		logger.info("Producer Completed");

		ctx.close();
	}
}
