/**
 * Copyright © 2022 国网信通产业集团有限公司. All rights reserved.
 *
 * @title: leader
 * @project: test
 * @package: com.example.demo.test.chuanjian.TheBuilder
 * @date: 2023/5/18
 * @version: V1.0
 */
package com.example.demo.test.chuanjian.TheBuilder.demo01;

/**
 * leader
 *  领导负责智慧构建 工程  如何构建 他来决定
 * @author czy
 * @date 2023/5/18
 */
public class leader {

    public  Product build(Builder builder){
        builder.buildA();
        builder.buildC();
        builder.buildB();
        builder.buildD();
        return builder.getProduct();
    }
}
