/**
 * Copyright © 2022 国网信通产业集团有限公司. All rights reserved.
 *
 * @title: Consumer
 * @project: test
 * @package: com.example.demo.test.chuanjian.factory.simple
 * @date: 2023/5/6
 * @version: V1.0
 */
package com.example.demo.test.chuanjian.factory.simple;



/**
 * Consumer
 *
 * @author czy
 * @date 2023/5/6
 */
public class Consumer {
    public static void main(String[] args) {
        // 接口， 工厂实现类
        Car car1 = new wuling();
        Car car2 = new tesila();

        //2 工厂创建
        Car carFactory = CarFactory.getCarFactory("tesila");
        carFactory.name();
        car1.name();
        car2.name();
    }
}
