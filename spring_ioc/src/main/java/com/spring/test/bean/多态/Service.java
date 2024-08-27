package com.spring.test.bean.多态;

public class Service {
    public void action(Base base) {
        System.out.println(base.getId());
    }

    public static void main(String[] args) {
        Dog base = new Dog();
        base.setName("Yong");
        new Service().action(base);
    }
}
