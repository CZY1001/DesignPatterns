/**
 * Copyright © 2022 国网信通产业集团有限公司. All rights reserved.
 *
 * @title: huaweiFactory
 * @project: test
 * @package: com.example.demo.test.chuanjian.factory.abstract1
 * @date: 2023/5/18
 * @version: V1.0
 */
package com.example.demo.test.chuanjian.factory.abstract1;

/**
 * huaweiFactory
 *
 * @author czy
 * @date 2023/5/18
 */
public class huaweiFactory extends huaweiluyouqi implements abstractFactory{
    @Override
    public shouji shoujigongchang() {
        return new huaweiPhone();
    }

    @Override
    public luyouqi luyouqigongchange() {
        return new huaweiluyouqi();
    }
}
