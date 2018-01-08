package com.jd.axondemo;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AxondemoApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(AxondemoApplication.class, args);
        String[] beanDefNames = context.getBeanDefinitionNames();
        for (String name : beanDefNames) {
            System.out.println(name);
        }
    }
}
