package org.example;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        System.out.println("Hello world!");
        LockSupport.park();
    }
}