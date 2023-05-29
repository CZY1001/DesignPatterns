/**
 * Copyright © 2022 国网信通产业集团有限公司. All rights reserved.
 *
 * @title: mgr03
 * @project: test
 * @package: com.example.demo.test.chuanjian.danli
 * @date: 2023/5/2
 * @version: V1.0
 */
package com.example.demo.test.chuanjian.danli;

/**
 * mgr03
 * 双重检索DSL 线程安全，在多线程下可以保持性能良好 因为锁的是对象不是方法
 * @author czy
 * @date 2023/5/2
 */
public class mgr03 {
    private volatile static mgr03  INSTANCE;

    private mgr03() {}

    public static mgr03 getInstance() {
        if (INSTANCE == null) {
            synchronized (mgr03.class) {
                if (INSTANCE == null) {
                    INSTANCE = new mgr03();
                }
            }

        }
        return INSTANCE;
    }
}
