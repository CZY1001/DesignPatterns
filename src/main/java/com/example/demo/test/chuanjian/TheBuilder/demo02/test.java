/**
 * Copyright © 2022 国网信通产业集团有限公司. All rights reserved.
 *
 * @title: test
 * @project: test
 * @package: com.example.demo.test.chuanjian.TheBuilder.demo02
 * @date: 2023/5/21
 * @version: V1.0
 */
package com.example.demo.test.chuanjian.TheBuilder.demo02;

/**
 * test
 *  我是实际调用者
 * @author czy
 * @date 2023/5/21
 */
public class test {
    public static void main(String[] args) {
        product product = new work().getProduct();
        System.out.println(product.toString());
    }
}
