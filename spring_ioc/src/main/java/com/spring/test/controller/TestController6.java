package com.spring.test.controller;

import com.spring.test.bean.Children;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/test6")
public class TestController6 {

    @PutMapping("1")
    public void test1(Children children) {
        System.out.println(children);
    }
}
