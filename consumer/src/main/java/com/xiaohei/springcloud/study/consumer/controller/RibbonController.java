package com.xiaohei.springcloud.study.consumer.controller;

import com.xiaohei.springcloud.study.consumer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RefreshScope
@RestController
@RequestMapping("/users")
public class RibbonController {

    @Autowired
    private UserService userService;
    @Value("${profile}")
    private String profile;

    @RequestMapping("/")
    public String print() {
        System.out.println(profile);
        return userService.print();
    }
}
