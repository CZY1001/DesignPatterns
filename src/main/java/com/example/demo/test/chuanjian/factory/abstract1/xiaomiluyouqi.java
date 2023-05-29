/**
 * Copyright © 2022 国网信通产业集团有限公司. All rights reserved.
 *
 * @title: xiaomiluyouqi
 * @project: test
 * @package: com.example.demo.test.chuanjian.factory.abstract1
 * @date: 2023/5/16
 * @version: V1.0
 */
package com.example.demo.test.chuanjian.factory.abstract1;

/**
 * xiaomiluyouqi
 *
 * @author czy
 * @date 2023/5/16
 */
public class xiaomiluyouqi implements  luyouqi{
    @Override
    public void start() {
        System.out.println("开启小米路由器");
    }

    @Override
    public void shutdown() {
        System.out.println("关闭小米路由器");
    }

    @Override
    public void openWifi() {
        System.out.println("小米开启wifi");
    }

    @Override
    public void setting() {
        System.out.println("小米设置");
    }
}
