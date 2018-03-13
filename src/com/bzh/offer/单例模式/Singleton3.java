package com.bzh.offer.单例模式;

/**
 * 在初始化静态变量时,就创建单例对象.但是,会过早的创建对象.
 */
public class Singleton3 {
    private Singleton3() {}
    private static Singleton3 instance = new Singleton3();
    public static Singleton3 getInstance() {
        return instance;
    }
}
