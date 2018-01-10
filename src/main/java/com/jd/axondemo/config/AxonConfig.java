package com.jd.axondemo.config;

import com.mongodb.MongoClient;
import org.axonframework.common.transaction.TransactionManager;
import org.axonframework.eventsourcing.eventstore.EventStorageEngine;
import org.axonframework.mongo.DefaultMongoTemplate;
import org.axonframework.mongo.MongoTemplate;
import org.axonframework.mongo.eventsourcing.eventstore.MongoEventStorageEngine;
import org.axonframework.spring.messaging.unitofwork.SpringTransactionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
public class AxonConfig {

    @Bean
    public MongoTemplate mongoTemplate(MongoClient mongoClient) {
        return new DefaultMongoTemplate(mongoClient);
    }

    @Bean
    public EventStorageEngine eventStorageEngine(MongoTemplate mongoTemplate) {
        return new MongoEventStorageEngine(mongoTemplate);
    }

}
