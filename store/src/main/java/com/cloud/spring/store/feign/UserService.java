package com.cloud.spring.store.feign;

import com.cloud.spring.user.model.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "user-provider")
@RequestMapping("/user")
public interface UserService {

    @RequestMapping(value = "/{kid}",method = RequestMethod.GET,consumes = "application/json")
    User getUserByKid(@PathVariable("kid") Long kid);
}
