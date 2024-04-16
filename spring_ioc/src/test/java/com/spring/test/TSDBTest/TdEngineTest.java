package com.spring.test.TSDBTest;

import com.spring.test.TSDB.dao.Meter;
import com.spring.test.TSDB.service.MeterService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@SpringBootTest
@Log4j2
public class TdEngineTest {

    public static ThreadPoolExecutor threadPoolExecutor =
            new ThreadPoolExecutor(10000, 10000, 1, TimeUnit.DAYS, new SynchronousQueue<>());

    public  static ThreadPoolExecutor threadPoolExecutor2 = (ThreadPoolExecutor) Executors.newCachedThreadPool();
    @Autowired
    private MeterService meterService;

    @Test
    void TDTest() {
        Thread[] threads = new Thread[Thread.activeCount()];
//        System.out.println(createTable("TDTest"));
//        System.out.println(insert("TDTest"));
        List<Meter> list = meterService.list();
        System.out.println(list);
    }

    public String insert(String tableName) {
        // mock data
        Random random = new Random();
        Meter meter = new Meter();
        meter.setTs(new java.sql.Timestamp(System.currentTimeMillis()));
        meter.setCurrent(random.nextFloat());
        meter.setVoltage(random.nextInt());
        meter.setPhase(random.nextFloat());
        meter.setF1(random.nextFloat());
        meter.setF2(random.nextFloat());
        meter.setF3(random.nextFloat());
        meter.setF4(random.nextFloat());
        meter.setF5(random.nextFloat());
        meter.setF6(random.nextFloat());
        meter.setF7(random.nextFloat());
        meter.setF8(random.nextFloat());
        meter.setF9(random.nextFloat());
        meter.setF10(random.nextFloat());
        try {
            meterService.insert(meter, tableName);
            return "insert success "+tableName;
        } catch (Exception e) {
            e.printStackTrace();
            return "insert failed! "+tableName;
        }
    }

    public String createTable(String tableName) {
        Meter meter = new Meter();
        meter.setGroupId(1);
        meter.setLocation("Los Angeles");
        try {
            meterService.create(meter, tableName);
            return "create sub-table " + tableName + " success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @Test
    void insertTest() {
        for (int i = 0; i < 10000; i++) {
            int finalI = i;
            Runnable runnable = () -> {
                log.info(createTable("TDTest"+ finalI));
//                System.out.println(createTable("TDTest"+ finalI));
                for (int j = 0; j < 3110400; j++) {
                    log.info(insert("TDTest"+ finalI)+j);
//                    System.out.println(insert("TDTest"+ finalI)+j);
//                    try {
//                        Thread.sleep(2000);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
                }
            };
            threadPoolExecutor2.execute(runnable);
        }
        try {
            threadPoolExecutor2.awaitTermination(1,TimeUnit.DAYS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void selectTest(){
        System.out.println(meterService.lastRow("TDTest"));

    }

}
