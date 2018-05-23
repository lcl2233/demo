package com.cloud.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class Zuul {

    /*@Bean
    AccessFilter accessFilter(){
        return new AccessFilter();
    }*/

    public static void main(String[] args) {
        SpringApplication.run(Zuul.class, args);
    }
}
