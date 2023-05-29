/**
 * Copyright © 2022 国网信通产业集团有限公司. All rights reserved.
 *
 * @title: test
 * @project: test
 * @package: com.example.demo.test.chuanjian.TheBuilder
 * @date: 2023/5/21
 * @version: V1.0
 */
package com.example.demo.test.chuanjian.TheBuilder.demo01;

/**
 * test
 *
 * @author czy
 * @date 2023/5/21
 */
public class test {

    public static void main(String[] args) {
        //领导
        leader leader = new leader();
        //指挥工人完成产品
        Product build = leader.build(new worker());
        System.out.println(build.toString());
    }
}
