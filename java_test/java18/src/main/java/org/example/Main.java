package org.example;

import java.util.HashMap;
import java.util.concurrent.locks.LockSupport;

public class Main {
    public static void main(String[] args) {
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        System.out.println("Hello world!");
        LockSupport.park();
    }
}