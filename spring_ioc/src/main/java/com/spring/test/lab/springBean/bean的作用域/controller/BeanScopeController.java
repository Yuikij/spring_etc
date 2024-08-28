package com.spring.test.lab.springBean.bean的作用域.controller;

import com.spring.test.lab.springBean.bean的作用域.bean.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

@RestController
@RequestMapping("/scope")
@Scope(SCOPE_PROTOTYPE)
//@Lazy
public class BeanScopeController {

    @Autowired
    private SingletonBean singletonBean;
    @Autowired
    private PrototypeBean prototypeBean;
    @Autowired
    private ApplicationBean applicationBean;
//    @Autowired
//    private RequestBean requestBean;
//    @Autowired
//    private SessionBean sessionBean;

    @Autowired
    ApplicationContext applicationContext;

    @GetMapping("/request")
    public String getRequestScope(HttpSession session) {
        RequestBean requestBean = applicationContext.getBean(RequestBean.class);
        SessionBean sessionBean = applicationContext.getBean(SessionBean.class);
        String singletonBeanField = singletonBean.getField();
        String prototypeBeanField = prototypeBean.getField();
        String applicationBeanField = applicationBean.getField();
        String requestBeanField = requestBean.getField();
        String sessionBeanField = sessionBean.getField();

        singletonBean.setField("SingletonBeanChanged");
        prototypeBean.setField("PrototypeBeanChanged");
        applicationBean.setField("ApplicationBeanChanged");
        requestBean.setField("RequestBeanChanged");
        sessionBean.setField("SessionBeanChanged");

        return "\nSingleton Bean: "+singletonBeanField+"\n"+
                "Prototype Bean: "+prototypeBeanField+"\n"+
                "Application Bean: "+applicationBeanField+"\n"+
                "Request Bean: "+requestBeanField+"\n"+
                "Session Bean: "+sessionBeanField+"\n";
    }


}
