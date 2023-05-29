/**
 * Copyright © 2022 国网信通产业集团有限公司. All rights reserved.
 *
 * @title: mgr05
 * @project: test
 * @package: com.example.demo.test.chuanjian.danli
 * @date: 2023/5/2
 * @version: V1.0
 */
package com.example.demo.test.chuanjian.danli;

/**
 * mgr05
 *枚举式
 *
 * 这种实现方式还没有被广泛采用，但这是实现单例模式的最佳方法。它更简洁，自动支持序列化机制，绝对防止多次实例化。
 * 这种方式是 Effective Java 作者提倡的方式，它不仅能避免多线程同步问题，而且还自动支持序列化机制，
 * 防止反序列化重新创建新的对象，绝对防止多次实例化。不过，由于 JDK1.5 之后才加入 enum 特性，用这种方式写不免让人感觉生疏，在实际工作中，也很少用。
 * 不能通过 reflection attack 来调用私有构造方法。
 * @author czy
 * @date 2023/5/2
 */
public enum mgr05 {
    INSTANCE;

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println(mgr05.INSTANCE.hashCode());
            }).start();
        }
    }
}
