package com.uitgis.flux.component;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@ConfigurationProperties(prefix = "spring.data.mongodb")
@Getter
@Setter
public class MongoDbProps {
	private String host;

	private String port;

	private String database;
}
