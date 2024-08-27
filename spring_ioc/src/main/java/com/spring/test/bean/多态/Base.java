package com.spring.test.bean.多态;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component("this.bean.test")
@Data
public class Base {
    private Long id;
}
