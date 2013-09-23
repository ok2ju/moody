package com.mteam.moody.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.mteam.moody.configuration.db.MongoDBConfiguration;
import com.mteam.moody.configuration.web.security.WebSecurityConfig;

@Configuration
@Import(value={MongoDBConfiguration.class, WebSecurityConfig.class})
@ComponentScan(basePackages = {"com.mteam.moody.app.service", "com.mteam.moody.app.model"})
public class AppConfig {
	
}
