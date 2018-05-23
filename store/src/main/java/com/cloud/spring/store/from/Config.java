package com.cloud.spring.store.from;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class Config {

    @Autowired
    private Environment env;

    @Value("${config.username}")
    private String from;

    @RequestMapping("/config")
    public String form(){
        return this.from;
    }

    @RequestMapping("/environment")
    public String getEnvironment(){
        String config = env.getProperty("config.username");
        return config;
        /*String[] configs = env.getDefaultProfiles();
        return StringUtils.arrayToCommaDelimitedString(configs);*/
    }
}
