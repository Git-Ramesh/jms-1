package com.rs.app.controller;

import org.apache.activemq.command.ActiveMQTopic;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rs.app.model.User;

@RestController
@RequestMapping("/jms")
public class JmsController {
	@Autowired
	private JmsTemplate jmsTemplate;

	@PostMapping(value = "/send/user", produces = "application/json")
	public String sendUser(@RequestBody User user) {
		JSONObject resp = new JSONObject();
		jmsTemplate.convertAndSend(new ActiveMQTopic("VirtualTopic.MY-SUPER-TOPIC"), user);
		resp.put("status", "Success");
		return resp.toString();
	}
}
