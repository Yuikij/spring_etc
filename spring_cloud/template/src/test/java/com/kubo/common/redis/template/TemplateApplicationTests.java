package com.kubo.common.redis.template;

import org.junit.jupiter.api.Test;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.kubo.common.redis.service.RedisService;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.Resource;
import java.util.Map;

@SpringBootTest
@ComponentScan(basePackages = {"com.kubo"})
class TemplateApplicationTests {

    @Autowired
    private RedisService redisService;

    @Resource
    private RedissonClient redissonClient;


    @Test
    void baseRedisTest() {
        redisService.setCacheObject("123", "kubo");
        System.out.println(redisService.getCacheObject("123").toString());
    }

    /**
     * 分布式锁测试
     */
    @Test
    void distributedLock() throws InterruptedException {
        RLock lock = redissonClient.getLock("client_test");
        boolean isLocked  = lock.tryLock();
        if (isLocked ){
            System.out.println("isLocked ");
            Thread.sleep(1000000);
        }else{
            Thread.sleep(1000);
            distributedLock();
        }

    }

}
