package com.spring.test.bean;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;
@Data
public class User {
    private String name;
    private List<Children> children;
}
