package com.spring.test.shiori.jdkProxy.handler;

import com.spring.test.shiori.jdkProxy.tools.ServiceTools;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {
    //目标对象
    private Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    //通过代理对象执行方法时，会调用执行这个invoke()方法

    /**
     *
     * @param proxy 代理类实例
     * @param method 被代理的方法
     * @param args 方法的参数数组
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("执行MyInvocationHandler中的invoke方法");

        //打印被调用的目标类中的方法名
        System.out.println(method.getName());

        Object res = null;

        //此方法是通过动态代理实现的增强的功能
        ServiceTools.doLog();

        //执行目标类方法，通过Method实现
        res = method.invoke(target, args);

        //此方法是通过动态代理实现的增强的功能
        ServiceTools.doTrans();

        //返回目标方法的执行结果
        return res;
    }
}