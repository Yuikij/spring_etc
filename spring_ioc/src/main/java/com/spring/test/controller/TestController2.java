package com.spring.test.controller;

import com.alibaba.fastjson.JSONObject;
import com.spring.test.bean.多态.Base;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("test2")
public class TestController2 {

    @GetMapping("/1/{id}")
    public void test1(){
        System.out.println("a");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("b");
    }

    @GetMapping("/{id}/2")
    public void test2(@PathVariable("id") String id){
        System.out.println(id);
    }

    @PostMapping("/3")
    public <T extends Base> void  test3(@RequestBody JSONObject obj){
        System.out.println(obj);
    }
}
