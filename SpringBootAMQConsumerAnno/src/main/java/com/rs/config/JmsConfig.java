package com.rs.config;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class JmsConfig {
	private static Logger logger = LoggerFactory.getLogger(JmsConfig.class);

	public JmsConfig() {
		logger.info("JmsConfig: 0-param constr");
	}

	@Bean
	public ConnectionFactory connectionFactory() {
		logger.info("ConnectionFactory created");
		ActiveMQConnectionFactory connectionFactory = null;

		connectionFactory = new ActiveMQConnectionFactory();
		connectionFactory.setBrokerURL("tcp://localhost:61616");

		return connectionFactory;
	}

	@Bean
	public JmsTemplate jmsTemplate() {
		logger.info("JmsTemplate created");
		JmsTemplate jmsTemplate = null;

		jmsTemplate = new JmsTemplate();
		jmsTemplate.setConnectionFactory(connectionFactory());
		jmsTemplate.setPubSubDomain(true);

		return jmsTemplate;
	}

	/*
	 * @Bean public DefaultMessageListenerContainer
	 * defaultMessageListenerContainer() { DefaultMessageListenerContainer
	 * defaultMessageListenerContainer = null;
	 * 
	 * defaultMessageListenerContainer = new DefaultMessageListenerContainer();
	 * defaultMessageListenerContainer.setPubSubDomain(true);
	 * defaultMessageListenerContainer.setConnectionFactory(connectionFactory());
	 * defaultMessageListenerContainer.setDestinationName("Topic1"); return
	 * defaultMessageListenerContainer; }
	 */
	@Bean
	public JmsListenerContainerFactory<?> jmsListenerContainerFactory() {
		DefaultJmsListenerContainerFactory containerFactory = null;
		
		containerFactory = new DefaultJmsListenerContainerFactory();
		containerFactory.setPubSubDomain(true);
		containerFactory.setConnectionFactory(connectionFactory());
		
		return containerFactory;
	}
}
