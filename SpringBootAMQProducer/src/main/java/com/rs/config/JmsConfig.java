package com.rs.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

@Configuration
//@EnableJms
public class JmsConfig {
	private static Logger logger = LoggerFactory.getLogger(JmsConfig.class);

	public JmsConfig() {
		logger.info("JmsConfig: 0-param constr");
	}

	@Bean(name="connectionFactory")
	public ActiveMQConnectionFactory connectionFactory() {
		ActiveMQConnectionFactory connectionFactory = null;

		connectionFactory = new ActiveMQConnectionFactory();
		connectionFactory.setBrokerURL("tcp://RameshPanthangi:61616");

		return connectionFactory;
	}

	@Bean(name = "jmsTemplate")
	public JmsTemplate jmsTemplate() {
		logger.info("jmsTemplate()");
		JmsTemplate jmsTemplate = null;

		jmsTemplate = new JmsTemplate();

		// Enable Publisher/Subscriber(Topics)
		jmsTemplate.setPubSubDomain(true);
		jmsTemplate.setConnectionFactory(connectionFactory());
		jmsTemplate.setDefaultDestinationName("Topic1");
		
		return jmsTemplate;
	}
}
