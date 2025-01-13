package com.example.demo.test.reviewTest.chuangjian.danli;

/**
 * @author czy
 * @summary 通过静态内部类达到双重检索单例的效果
 * 实现简单
 * 借助了饿汉式的类一加载就实例化的概念
 * 但是他和饿汉式不同的是，
 * 饿汉式只要demo类被装载了，就会马上去实例化，没有达到延迟加载的效果
 * 这种方式demo05被加载的时候，内部类不被加载，就不会去实例化，只有当getInstance()方法被首次调用的时候，虚拟机才会去加载这个实例
 * @date 2025-01-11 17:47
 */
public class demo05 {
    private static class Singleton {
        private static final demo05 instance = new demo05();
    }

    private demo05() {}

    public static demo05 getInstance() {
        return Singleton.instance;
    }

}
