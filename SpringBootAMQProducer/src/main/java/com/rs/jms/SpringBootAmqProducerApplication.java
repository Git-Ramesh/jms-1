package com.rs.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jms.core.JmsTemplate;

import com.rs.config.JmsConfig;

@SpringBootApplication
@ComponentScan(basePackageClasses= {JmsConfig.class})
public class SpringBootAmqProducerApplication implements CommandLineRunner {
	private static Logger logger = LoggerFactory.getLogger(SpringBootAmqProducerApplication.class);
	@Autowired
	JmsTemplate jmsTemplate;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAmqProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("run(...) method");
		jmsTemplate.convertAndSend("Topic1", "MyFirstMessgae");
	}
}
