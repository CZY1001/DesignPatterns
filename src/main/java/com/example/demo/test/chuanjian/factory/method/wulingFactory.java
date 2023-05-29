/**
 * Copyright © 2022 国网信通产业集团有限公司. All rights reserved.
 *
 * @title: wulingFactory
 * @project: test
 * @package: com.example.demo.test.chuanjian.factory.method
 * @date: 2023/5/9
 * @version: V1.0
 */
package com.example.demo.test.chuanjian.factory.method;

/**
 * wulingFactory
 *
 * @author czy
 * @date 2023/5/9
 */
public class wulingFactory implements CarFactory{
    @Override
    public Car getCar() {
        return new wuling();
    }
}
