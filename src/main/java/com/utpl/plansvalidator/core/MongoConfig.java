package com.utpl.plansvalidator.core;

import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.utpl.plansvalidator.nosql")
public class MongoConfig {
    @Value("${plansvalidator.nosql.db}")
    private String dbName;
    @Value("${plansvalidator.nosql.host}")
    private String host;
    @Value("${plansvalidator.nosql.port}")
    private int port;

    @Bean
    public MongoClient mongo() {
        return new MongoClient(host, port);
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongo(), dbName);
    }
}
