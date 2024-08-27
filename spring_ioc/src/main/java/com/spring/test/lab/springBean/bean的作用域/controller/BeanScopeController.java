package com.spring.test.lab.springBean.bean的作用域.controller;

import com.spring.test.lab.springBean.bean的作用域.bean.PrototypeBean;
import com.spring.test.lab.springBean.bean的作用域.bean.SingletonBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/scope")
@SessionAttributes("JSESSIONID")
public class BeanScopeController {


    @GetMapping("/request")
    public String getRequestScope(HttpSession session) {
        return "Request Scoped Bean: "+session.getId() ;
    }


}
