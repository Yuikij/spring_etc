//package com.spring.test.TSDB.service;
//
//import com.alibaba.fastjson.JSONObject;
//import com.spring.test.TSDB.dao.Meter;
//import com.spring.test.TSDB.dao.MeterMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class MeterService {
//    @Autowired
//    private MeterMapper meterMapper;
//
//    public List<Meter> list() {
//        return meterMapper.find();
//    }
//
//    public void create(Meter meter, String tableName) {
//        meterMapper.create(meter, tableName);
//    }
//
//    public int insert(Meter meter, String tableName) {
//        return meterMapper.save(meter, tableName);
//    }
//
//    public JSONObject lastRow(String tableName) {
//        return meterMapper.lastRow(tableName);
//    }
//}
