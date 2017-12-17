package com.xiaohei.springcloud.study.consumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "userFallback")
    public String print() {
        String result = restTemplate.getForEntity("http://provider/users/", String.class).getBody();
        return result;
    }

    private String userFallback() {
        return "error";
    }
}
