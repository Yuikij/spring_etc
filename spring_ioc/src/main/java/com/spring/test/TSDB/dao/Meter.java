package com.spring.test.TSDB.dao;


import lombok.Data;

import java.sql.Timestamp;

@Data
public class Meter {
    private Timestamp ts;
    private float current;
    private int voltage;
    private float phase;
    private int groupId;
    private String location;


    private float f1;
    private float f2;
    private float f3;
    private float f4;
    private float f5;
    private float f6;
    private float f7;
    private float f8;
    private float f9;
    private float f10;

}
