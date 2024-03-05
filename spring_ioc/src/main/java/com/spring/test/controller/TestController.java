package com.spring.test.controller;

import com.spring.test.bean.BeanTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TestController {

    private  BeanTest beanTest;


    @Autowired
    public void setBeanTest(BeanTest beanTest) {
        this.beanTest = beanTest;
    }

    @PostMapping("/test")
    public void test1(@RequestPart("MoveDetection.xml") MultipartFile file){
        // 处理文件，您可以将文件保存到磁盘或进行其他操作
        if (!file.isEmpty()) {
            try {
                String filePath = "D:\\456\\" + file.getOriginalFilename();
                File dest = new File(filePath);
                file.transferTo(dest);
                System.out.println("File saved at: " + filePath);

            } catch (Exception e) {

            }
        } else {

        }
    }


    @GetMapping("/2")
    public void test2(){
        System.out.println("a");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("b");
    }
}
