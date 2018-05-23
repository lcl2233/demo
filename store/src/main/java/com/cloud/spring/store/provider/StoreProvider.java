package com.cloud.spring.store.provider;

import com.cloud.spring.store.feign.UserService;
import com.cloud.spring.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Service
@RequestMapping("store")
@ResponseBody
public class StoreProvider {

    @Autowired
    DiscoveryClient discoveryClient;

   /* @Autowired
    LoadBalancerClient loadBalancerClient;*/

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    UserService userService;

    @RequestMapping(value = "getUser/{kid}",method = RequestMethod.GET)
    public User getUser(@PathVariable("kid") Long kid){
        System.out.println("this is store provider");
        return userService.getUserByKid(kid);
    }

    @RequestMapping("getEurekaClientServer")
    public String getEurekaClientServer(){
        return "server : " + discoveryClient.getServices();
    }

    @RequestMapping("consumer")
    public User consumer(){
        //负载客户端直接选取服务服务处理
        /*ServiceInstance serviceInstance = loadBalancerClient.choose("user-provider");
        String url = "http://" + serviceInstance.getHost().toLowerCase() + ":" + serviceInstance.getPort() + "/user/10";*/

        //@LoadBalanced使用负载均衡自动选取服务处理
        String url = "http://user-provider/user/10";
        return restTemplate.getForObject(url, User.class);
    }
}
