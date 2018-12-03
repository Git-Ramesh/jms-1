package com.rs.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;

import com.rs.jms.JmsSubcriber;

@Configuration
@EnableJms
public class JmsConfig {
	private static Logger logger = LoggerFactory.getLogger(JmsConfig.class);
	@Autowired
	JmsSubcriber jmsSubcriber;

	public JmsConfig() {
		logger.info("JmsConfig: 0-param constr");
	}

	@Bean
	public JmsTemplate jmsTemplate() {
		logger.info("JmsTemplate created");

		JmsTemplate jmsTemplate = null;

		jmsTemplate = new JmsTemplate();

		// Enable Publisher/Subscriber(Topics) model
		jmsTemplate.setPubSubDomain(true);
		jmsTemplate.setConnectionFactory(cachingConnectionFactory());
		// jmsTemplate.setDestinationName("Topic1");

		return jmsTemplate;
	}

	public ActiveMQConnectionFactory connectionFactory() {
		logger.info("ActiveMQConnectionFactory created");
		ActiveMQConnectionFactory connectionFactory = null;

		connectionFactory = new ActiveMQConnectionFactory();
		connectionFactory.setBrokerURL("tcp://RameshPanthangi:61616");

		return connectionFactory;
	}

	@Bean
	public CachingConnectionFactory cachingConnectionFactory() {
		logger.info("CachingConnectionFactory created");
		CachingConnectionFactory cachingConnectionFactory = null;

		cachingConnectionFactory = new CachingConnectionFactory(connectionFactory());

		return cachingConnectionFactory;
	}

	@Bean(name = "messageListenerContainer")
	public DefaultMessageListenerContainer messageListenerContainer() {
		DefaultMessageListenerContainer messageListenerContainer = null;

		messageListenerContainer = new DefaultMessageListenerContainer();

		messageListenerContainer.setDestination(new ActiveMQTopic("Topic1"));
		messageListenerContainer.setConnectionFactory(cachingConnectionFactory());
		messageListenerContainer.setPubSubDomain(true);
		messageListenerContainer.setMessageListener(jmsSubcriber);
		return messageListenerContainer;
	}

}
