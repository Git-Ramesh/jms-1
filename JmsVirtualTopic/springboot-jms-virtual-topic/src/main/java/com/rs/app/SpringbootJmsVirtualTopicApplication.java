package com.rs.app;

import javax.jms.Message;
import javax.jms.Session;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;

import com.rs.app.model.User;

@SpringBootApplication
public class SpringbootJmsVirtualTopicApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJmsVirtualTopicApplication.class, args);
	}

	@JmsListener(destination = "Consumer.myConsumer1.VirtualTopic.MY-SUPER-TOPIC")
	public void jmsListener1(@Payload User user, @Headers MessageHeaders headers, Message message, Session session) {
		
		System.out.println("listenet1: User: " + user);
	}

	@JmsListener(destination = "Consumer.myConsumer2.VirtualTopic.MY-SUPER-TOPIC")
	public void jmsListener2(@Payload User user, @Headers MessageHeaders headers, Message message, Session session) {
		System.out.println("listener2: User: " + user);
	}
}
