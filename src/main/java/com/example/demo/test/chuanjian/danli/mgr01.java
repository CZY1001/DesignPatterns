/**
 * Copyright © 2022 国网信通产业集团有限公司. All rights reserved.
 *
 * @title: mgr01
 * @project: test
 * @package: com.example.demo.test.chuanjian.danli
 * @date: 2023/5/2
 * @version: V1.0
 */
package com.example.demo.test.chuanjian.danli;

/**
 * mgr01
 *  饿汉式
 *  类加载到内存之后，就直接实例化一个单例对象，jvm可以保证线程安全
 *  简单、没有加锁，执行效率会提高
 *  缺点：不管是否用到这个，类加载的时候就直接实例化这个对象
 * @author czy
 * @date 2023/5/2
 */
public class mgr01 {

    private static final mgr01 INSTANCE = new mgr01();

    private mgr01() {}

    public static mgr01 getInstance(){
        return INSTANCE;
    }
}
