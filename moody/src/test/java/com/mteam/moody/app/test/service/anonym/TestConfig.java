package com.mteam.moody.app.test.service.anonym;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.mteam.moody.configuration.db.MongoDBConfiguration;

@Configuration
@Import(value={MongoDBConfiguration.class})
@ComponentScan(basePackages = {"com.mteam.moody.app.service", 
		"com.mteam.moody.app.model",
		"com.mteam.moody.app.DAO"})
public class TestConfig {
	
}
