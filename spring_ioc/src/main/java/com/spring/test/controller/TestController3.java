package com.spring.test.controller;

import com.spring.test.bean.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController3 {

    @PostMapping("/test3/user")
    public User test1(@RequestBody User user) {
        System.out.println(user);
        return user;
    }
}
