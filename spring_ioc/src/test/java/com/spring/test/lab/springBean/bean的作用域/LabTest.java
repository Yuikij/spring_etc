package com.spring.test.lab.springBean.bean的作用域;

import com.spring.test.lab.springBean.bean的作用域.controller.BeanScopeController;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpCookie;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;


import javax.servlet.http.Cookie;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = BeanScopeController.class)
@Log4j2
public class LabTest {


    @Autowired
    private MockMvc mockMvc;

    @Test
    void runTest() throws Exception {
        MockHttpSession session = new MockHttpSession();
        session.setAttribute("JSESSIONID", "123");
        mockMvc.perform(get("/scope/request")
                        .cookie(new Cookie("JSESSIONID", "123"))
                        .session(session))
                .andDo((result)->{
                            log.info(result.getResponse().getContentAsString());
                }).andExpect(status().isOk());

        mockMvc.perform(get("/scope/request")
                .cookie(new Cookie("JSESSIONID", "222"))).andDo((result)->{
            log.info(result.getResponse().getContentAsString());
        }).andExpect(status().isOk());

        mockMvc.perform(get("/scope/request")
                .cookie(new Cookie("JSESSIONID", "123"))
                .session(session)
        ).andDo((result)->{
            log.info(result.getResponse().getContentAsString());
        }).andExpect(status().isOk());
    }
}
