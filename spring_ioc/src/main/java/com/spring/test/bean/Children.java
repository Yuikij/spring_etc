package com.spring.test.bean;

import lombok.Data;

import java.util.List;

@Data
public class Children {
    private String name;
    private List<Friend> friends;
}
