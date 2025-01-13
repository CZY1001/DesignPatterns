package com.example.demo.test.reviewTest.chuangjian.danli;

/**
 * @author czy
 * @summary 懒汉式-线程不安全的
 * 同样私有构造器
 * 基于饿汉式的基础上，在获取实例的那里做处理，判断实例对象是否存在，存在就返回，不存在就创建
 * 多个线程请求进来，第一个人去创建对象了，还没创建完毕，第二个人来判断对象为空，就又去创建对象了，就导致单例失效了
 * @date 2025-01-11 11:02
 */
public class demo02 {
    private static demo02 instance;

    private demo02() {
        System.out.println("demo02 init初始化======");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static demo02 getInstance() {
        System.out.println("demo02 getInstance获取实例======");
        if (instance == null) {
            instance = new demo02();
        }
        return instance;
    }
    public void show() {
        System.out.println("兄弟们好，我是demo02=="+this.hashCode());
    }
}
