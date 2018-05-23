package com.cloud.spring.ConfigServer;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {

    @RequestMapping("/config")
    public String config() {
        return "Hello World!";
    }
}
