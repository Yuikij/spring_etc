package com.spring.test.bean.多态;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Dog extends Base{
    private String name;
}
