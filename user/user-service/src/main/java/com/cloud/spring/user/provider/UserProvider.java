package com.cloud.spring.user.provider;

import com.cloud.spring.user.model.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Service
@ResponseBody
@RequestMapping("/user")
public class UserProvider {

    @RequestMapping(value = "/{kid}",method = RequestMethod.GET)
    public User getUserByKid(@PathVariable("kid") Long kid) {
        User user = new User();
        user.setKid(10l);
        user.setUserName("liuchangli");
        user.setPassword("123");
        return user;
    }
}
