package com.rs.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.rs.config", "com.rs.jms.receiver" })
public class SpringBootAmqConsumerAnnoApplication {
	private static Logger logger = LoggerFactory.getLogger(SpringBootAmqConsumerAnnoApplication.class);

	public static void main(String[] args) {
		logger.info("Spring is booting..");
		SpringApplication.run(SpringBootAmqConsumerAnnoApplication.class, args);
	}
}
