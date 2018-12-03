package com.rs.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClientApp {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		System.out.println("Listener Started...");
		ctx=new ClassPathXmlApplicationContext("com/rs/config/jms-context.xml");

		
		//((AbstractApplicationContext) ctx).close();
	}

}
