package com.spring.test.TSDB.dao;

import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface  MeterMapper {
    @Select("select * from meters limit 10")
    List<Meter> find();

    int create(@Param("meter")Meter meter, @Param("tableName")String tableName);

    int save(@Param("meter")Meter meter, @Param("tableName")String tableName);

    JSONObject lastRow(@Param("tableName")String tableName);
}
