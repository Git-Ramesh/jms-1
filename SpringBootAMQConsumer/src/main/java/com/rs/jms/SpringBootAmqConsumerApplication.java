package com.rs.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;

@SpringBootApplication
@ComponentScan(basePackages = {"com.rs.config","com.rs.jms"})
public class SpringBootAmqConsumerApplication implements CommandLineRunner {

	private static Logger logger = LoggerFactory.getLogger(SpringBootAmqConsumerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAmqConsumerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("run(...) started");
		
	}
}
