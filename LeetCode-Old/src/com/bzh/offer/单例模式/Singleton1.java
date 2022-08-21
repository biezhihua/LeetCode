package com.bzh.offer.单例模式;

/**
 * 只适用于单线程环境
 */
public class Singleton1 {
    private Singleton1() {}
    private static Singleton1 instance = null;
    public static Singleton1 getInstance() {
        if (instance == null) {
            instance = new Singleton1();
        }
        return instance;
    }
}
