package com.bzh.offer.单例模式;

/**
 * 加锁保证多线程情况下只创建一个实例,并且用两个if来提高效率.但是代码比较复杂,容易出错.
 */
public class Singleton2 {
    private Singleton2() {}
    private static Singleton2 instance = null;
    public static Singleton2 getInstance() {
        if (instance == null) {
            synchronized (Singleton2.class) {
                if (instance == null) {
                    instance = new Singleton2();
                }
            }
        }
        return instance;
    }
}
