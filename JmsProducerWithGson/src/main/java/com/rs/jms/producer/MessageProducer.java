package com.rs.jms.producer;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.rs.model.Employee;

@Component("messageProducer")
public class MessageProducer {
	private static Logger logger = LoggerFactory.getLogger(MessageProducer.class);
	@Autowired
	private JmsTemplate jmsTemplate;

	public void sendMessage(Employee employee) {
		logger.info("sendMessage");
		Gson gson = new Gson();

		String jsonEmployee = gson.toJson(employee);
		logger.info("JSONEMPLOYEE: '{0}'", jsonEmployee);
		MessageCreator messageCreator = new MessageCreator() {

			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(jsonEmployee);
			}
		};
		
		jmsTemplate.send(messageCreator);
	}

}
