/**
 * Copyright © 2022 国网信通产业集团有限公司. All rights reserved.
 *
 * @title: xiaomiFactory
 * @project: test
 * @package: com.example.demo.test.chuanjian.factory.abstract1
 * @date: 2023/5/16
 * @version: V1.0
 */
package com.example.demo.test.chuanjian.factory.abstract1;

/**
 * xiaomiFactory
 *
 * @author czy
 * @date 2023/5/16
 */
public class xiaomiFactory extends xiaomiPhone implements abstractFactory{

    @Override
    public shouji shoujigongchang() {
        return new xiaomiPhone();
    }

    @Override
    public luyouqi luyouqigongchange() {
        return new xiaomiluyouqi();
    }
}
