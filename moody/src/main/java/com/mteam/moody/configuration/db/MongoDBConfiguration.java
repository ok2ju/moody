package com.mteam.moody.configuration.db;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
/**
 * @author Aleh_Atsman
 */
@Configuration
public class MongoDBConfiguration extends AbstractMongoConfiguration {

	private static String DATABASE_NAME = "test";
	
	private static String DATABASE_HOST = "localhost";
	
	@Override
	protected String getDatabaseName() {
		return DATABASE_NAME;
	}

	@Override
	public Mongo mongo() throws Exception {
		return new MongoClient(DATABASE_HOST);
	}
}
