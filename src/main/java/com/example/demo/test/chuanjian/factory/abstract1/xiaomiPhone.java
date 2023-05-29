/**
 * Copyright © 2022 国网信通产业集团有限公司. All rights reserved.
 *
 * @title: xiaomiPhone
 * @project: test
 * @package: com.example.demo.test.chuanjian.factory.abstract1
 * @date: 2023/5/16
 * @version: V1.0
 */
package com.example.demo.test.chuanjian.factory.abstract1;

/**
 * xiaomiPhone
 *
 * @author czy
 * @date 2023/5/16
 */
public class xiaomiPhone implements  shouji{
    @Override
    public void start() {
        System.out.println("开启小米手机");
    }

    @Override
    public void shutdown() {
    System.out.println("关闭小米手机");
    }

    @Override
    public void callup() {
        System.out.println("小米手机打电话");
    }

    @Override
    public void sendMS() {
        System.out.println("小米手机发短信");
    }
}
