package com.spring.test.lab.springBean.concurrent.completableFuture;


import java.util.concurrent.ThreadPoolExecutor;

public class LoggingDiscardOldestPolicy extends ThreadPoolExecutor.DiscardOldestPolicy {

    public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
       super.rejectedExecution(r,e);
    }

}
