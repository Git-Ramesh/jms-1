package com.rs.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.rs.config.AppConfig;
import com.rs.jms.consumer.MessageConsumer;
import com.rs.model.Employee;

public class App {
	private static Logger logger = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = null;
		ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		logger.info("Consumer Started");
	}
}
