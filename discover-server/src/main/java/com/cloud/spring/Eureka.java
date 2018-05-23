package com.cloud.spring;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class Eureka {
    public static void main(String[] args) {
        new SpringApplicationBuilder(Eureka.class).web(true).run(args);
    }
}
