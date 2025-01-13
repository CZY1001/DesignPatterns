package com.example.demo.test.reviewTest.chuangjian.danli;

/**
 * @author czy
 * @summary 懒汉式-线程安全
 * 在懒汉式的基础上加了sy锁，使得线程安全。但是锁方法粒度太大，导致效率辣鸡
 * @date 2025-01-11 16:08
 */
public class demo03 {
    private static demo03 instance;
    private demo03() {
        System.out.println("demo03 init初始化======");
    }
    public static synchronized demo03 getInstance() {
        System.out.println("demo03 getInstance获取实例======");
        if (instance == null) {
            instance = new demo03();
        }
        return instance;
    }
    public void show() {
        System.out.println("demo03 show方法执行======");
    }
}
