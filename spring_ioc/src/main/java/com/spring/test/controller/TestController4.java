package com.spring.test.controller;

import com.spring.test.bean.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class TestController4 {

    @GetMapping("/test4/url")
    public void test1(HttpServletResponse response) throws IOException {
        response.sendRedirect("" +
                "http://192.168.9.5:9000/accesstest/example.mp4?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=iHRQWlZAgERaGk7V%2F20230314%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20230314T083326Z&X-Amz-Expires=604800&X-Amz-SignedHeaders=host&X-Amz-Signature=0505dea64670599b394a1b8c7798aa1fefe613ac8f51ae15a45c80e5ed148a1b");
    }
}
