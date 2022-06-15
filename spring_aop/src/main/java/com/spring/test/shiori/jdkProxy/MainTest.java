package com.spring.test.shiori.jdkProxy;

import com.spring.test.shiori.jdkProxy.handler.MyInvocationHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class MainTest {
    public static void main(String[] args) {
        //创建目标对象
        SomeService target = new SomeServiceImpl();

        //创建InvocationHandler对象
        InvocationHandler handler = new MyInvocationHandler(target);

        //使用Proxy创建代理
        SomeService proxy = (SomeService) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                handler
        );

        //通过代理执行方法，会调用handle中的invoke()方法
        proxy.doSome();
    }

}
