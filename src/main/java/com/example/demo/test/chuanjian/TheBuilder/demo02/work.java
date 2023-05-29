/**
 * Copyright © 2022 国网信通产业集团有限公司. All rights reserved.
 *
 * @title: work
 * @project: test
 * @package: com.example.demo.test.chuanjian.TheBuilder.demo02
 * @date: 2023/5/21
 * @version: V1.0
 */
package com.example.demo.test.chuanjian.TheBuilder.demo02;

/**
 * work
 *  我是一个具体的工人
 * @author czy
 * @date 2023/5/21
 */
public class work extends Builder{

    private product product;

    public work() {
        product = new product();
    }

    @Override
    Builder buildA(String msg) {
        product.setBuildA(msg);
        return this;
    }

    @Override
    Builder buildB(String msg) {
        product.setBuildB(msg);
        return this;
    }

    @Override
    Builder buildC(String msg) {
        product.setBuildC(msg);
        return this;
    }

    @Override
    Builder buildD(String msg) {
        product.setBuildD(msg);
        return this;
    }

    @Override
    product getProduct() {
        return product;
    }
}
