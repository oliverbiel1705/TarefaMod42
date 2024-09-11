package com.gabdev.msClient.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.maxjdev.msClient.repository")
public class MongoConfig {
}
