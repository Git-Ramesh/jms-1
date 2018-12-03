package com.rs.jms;

import javax.jms.Message;
import javax.jms.MessageListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class JmsSubcriber implements MessageListener {
	private static Logger logger = LoggerFactory.getLogger(JmsSubcriber.class);

	@Override
	public void onMessage(Message message) {
		System.out.println("Received Message: "+message);
		
	}

//	public JmsSubcriber() {
//		logger.info("JmsSubscriber: 0-param constr");
//	}
//	
//	@JmsListener(destination = "Topic1")
//	public void receiveMessage(final Message message) throws JMSException {
//		System.out.println("Received message " + message);
//		
//	}
}