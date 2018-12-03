package com.rs.config;

import javax.jms.ConnectionFactory;

import org.apache.activemq.jms.pool.PooledConnectionFactory;
import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class JmsConfig {
	
	public ActiveMQConnectionFactory activeMQConnectionFactory() {
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
		connectionFactory.setBrokerURL("tcp://localhost:61616");
		
		return connectionFactory;
	}
	@Bean
	public ConnectionFactory connectionFactory() {
		PooledConnectionFactory connectionFactory = null;
		
		connectionFactory = new PooledConnectionFactory();
		connectionFactory.setMaxConnections(5);
		connectionFactory.setIdleTimeout(200);
		connectionFactory.setConnectionFactory(activeMQConnectionFactory());
		
		return connectionFactory;
	}
	
	@Bean
	public JmsTemplate jmsTemplate() {
		JmsTemplate jmsTemplate = new JmsTemplate();
		
		jmsTemplate.setConnectionFactory(connectionFactory());
		jmsTemplate.setDefaultDestinationName("Queue1");
		
		return jmsTemplate;
	}
}
