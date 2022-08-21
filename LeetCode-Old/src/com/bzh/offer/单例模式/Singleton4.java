package com.bzh.offer.单例模式;

/**
 * 只有真正需要的时候才创建对象,利用类内部类和静态变量的特性.
 */
public class Singleton4 {
    private Singleton4() {
    }
    public static Singleton4 getInstance() {
        return InnerSingleton.singleton;
    }
    static class InnerSingleton {
        private InnerSingleton() {
        }
        static Singleton4 singleton = new Singleton4();
    }
}
