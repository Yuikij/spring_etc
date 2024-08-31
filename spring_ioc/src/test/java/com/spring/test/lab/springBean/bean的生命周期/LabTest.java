package com.spring.test.lab.springBean.bean的生命周期;

import com.spring.test.lab.springBean.bean的作用域.bean.ApplicationBean;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;

import javax.servlet.http.Cookie;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@WebMvcTest(controllers = BeanScopeController.class)
@SpringBootTest
@Log4j2
public class LabTest {

    @Autowired
    ApplicationContext applicationContext;

    @Test
    void runTest() throws Exception {
        applicationContext.getBean("test");
    }
}
