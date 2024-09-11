package com.gabdev.msProduct.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.maxjdev.msProduct.repository")
public class MongoConfig {
}
