package com.spring.test.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/test5")
public class TestController5 {

//    @PostMapping("1")
//    public void test1(@RequestParam("md5") String md5, @RequestParam("file") List<MultipartFile> files) {
//        System.out.println("enter 1");
//    }

    @PostMapping("2")
    public void test2(@RequestParam("md5") String md5, @RequestParam("file") List<MultipartFile> files, @RequestParam(required = false, value = "type") String type) {
        System.out.println("enter 2");
    }
}
