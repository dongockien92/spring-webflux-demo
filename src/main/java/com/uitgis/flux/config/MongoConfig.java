package com.uitgis.flux.config;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

import com.mongodb.ConnectionString;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import com.uitgis.flux.component.MongoDbProps;

@Configuration
@EnableReactiveMongoRepositories(basePackages = "com.uitgis.flux.repo")
public class MongoConfig extends AbstractReactiveMongoConfiguration {
	@Autowired
	private MongoDbProps mongoDbProps;

	@Override
	public MongoClient reactiveMongoClient() {
		String connectionUrl = StringUtils.join("mongodb://", mongoDbProps.getHost(), ":", mongoDbProps.getPort()); // mongodb://localhost:27017
		ConnectionString connectionString = new ConnectionString(connectionUrl);
		return MongoClients.create(connectionString);
	}

	@Override
	protected String getDatabaseName() {
		return mongoDbProps.getDatabase();
	}

	@Bean
	public ReactiveMongoTemplate reactiveMongoTemplate() {
		return new ReactiveMongoTemplate(reactiveMongoClient(), getDatabaseName());
	}
}
