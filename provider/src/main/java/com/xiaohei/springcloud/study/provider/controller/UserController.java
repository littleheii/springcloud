package com.xiaohei.springcloud.study.provider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RefreshScope
public class UserController {

    @Value("${profile}")
    private String profile;

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/")
    public String print() {
        ServiceInstance instance = discoveryClient.getLocalServiceInstance();
        System.out.println("host:" + instance.getHost() + ",port" + instance.getPort() + ",serviceId:" + instance.getServiceId());
        return profile;
    }
}
