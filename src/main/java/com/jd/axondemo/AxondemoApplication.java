package com.jd.axondemo;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStorageEngine;
import org.axonframework.eventsourcing.eventstore.inmemory.InMemoryEventStorageEngine;
import org.axonframework.mongo.MongoTemplate;
import org.axonframework.mongo.eventsourcing.eventstore.MongoEventStorageEngine;
import org.axonframework.spring.config.EnableAxon;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class AxondemoApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(AxondemoApplication.class, args);
        String[] beanDefNames = context.getBeanDefinitionNames();
        for (String name : beanDefNames) {
            System.out.println(name);
            System.out.println(context.getBean(name).getClass());
            System.out.println("===========================");
        }
    }
}
