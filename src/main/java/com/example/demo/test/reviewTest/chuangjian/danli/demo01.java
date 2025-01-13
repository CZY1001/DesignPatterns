package com.example.demo.test.reviewTest.chuangjian.danli;

/**
 * @author czy
 * @summary 饿汉式------01
 * 最简单、最直接的单例，类在初始加载的时候就实例化，并且在内存中只有一个实例。
 * 类加载时就创建对象 私有构造器，不让外部创建实例，只提供一个外部获取实例的静态方法。
 *
 * 优点：实现简单，在系统启动时实例化，避免频繁创建销毁对象
 * 缺点：类加载时就实例化，不利于代码的热更新。
 * @date 2025-01-11 10:07
 */
public class demo01 {
    private static final demo01 instance = new demo01();

    private demo01() {
        System.out.println("demo01 init======");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static demo01 getInstance() {
        System.out.println("demo01 getInstance======");
        return instance;
    }
    public void show() {
        System.out.println("兄弟们好，我是demo01");
    }
}




