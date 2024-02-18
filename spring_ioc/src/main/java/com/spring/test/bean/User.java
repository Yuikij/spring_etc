package com.spring.test.bean;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.Map;

@Data
public class User {
    @JsonProperty("Name")
    private String Name;
    private Map<Integer, String> data;
    private List<Children> children;
}
