/**
 * Copyright © 2022 国网信通产业集团有限公司. All rights reserved.
 *
 * @title: mgr02
 * @project: test
 * @package: com.example.demo.test.chuanjian.danli
 * @date: 2023/5/2
 * @version: V1.0
 */
package com.example.demo.test.chuanjian.danli;

/**
 * mgr02
 * 懒汉式
 * 因为没有加锁，会有线程安全问题
 * @author czy
 * @date 2023/5/2
 */
public class mgr02 {
    private static  mgr02 INSTANCE;
    private mgr02(){}
    public static synchronized mgr02 getInstance (){

        if (INSTANCE == null) {
            INSTANCE= new mgr02();
        }
        return INSTANCE;
    }
}
