package com.rs.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(JmsConfig.class)
@ComponentScan(basePackages = {"com.rs.jms.consumer"})
public class AppConfig {
	
}
