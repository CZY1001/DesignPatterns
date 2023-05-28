/**
 * Copyright © 2022 国网信通产业集团有限公司. All rights reserved.
 *
 * @title: Consumer
 * @project: test
 * @package: com.example.demo.test.chuanjian.factory.simple
 * @date: 2023/5/6
 * @version: V1.0
 */
package com.example.demo.test.chuanjian.factory.method;

import org.springframework.boot.test.context.SpringBootTest;

/**
 * Consumer
 *
 * @author czy
 * @date 2023/5/6
 */
@SpringBootTest
public class Consumer {
    public static void main(String[] args) {
        Car car1 = new tesilaFactory().getCar();
        Car car = new wulingFactory().getCar();

        Car car2 = new dazhongFactory().getCar();
        car2.name();
        car1.name();
        car.name();
    }
}
