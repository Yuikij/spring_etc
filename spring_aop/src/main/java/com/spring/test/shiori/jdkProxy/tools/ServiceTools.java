package com.spring.test.shiori.jdkProxy.tools;

import java.util.Date;

public class ServiceTools {

    public static void doLog() {
        System.out.println("方法的执行时间：" + new Date());
    }

    public static void doTrans() {
        System.out.println("方法执行完毕，提交事务");
    }

}
