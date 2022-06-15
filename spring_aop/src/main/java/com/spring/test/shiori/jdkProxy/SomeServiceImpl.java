package com.spring.test.shiori.jdkProxy;

public class SomeServiceImpl implements SomeService{
    public void doSome() {
        System.out.println("执行doSome");
    }

    @Override
    public void doOther() {
        System.out.println("执行doOther");
    }
}
