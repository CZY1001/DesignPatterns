/**
 * Copyright © 2022 国网信通产业集团有限公司. All rights reserved.
 *
 * @title: worker
 * @project: test
 * @package: com.example.demo.test.chuanjian.TheBuilder
 * @date: 2023/5/18
 * @version: V1.0
 */
package com.example.demo.test.chuanjian.TheBuilder.demo01;

/**
 * worker
 *  工人
 * @author czy
 * @date 2023/5/18
 */
public class worker extends Builder{
    private  Product product;
    public worker(){
        this.product = new Product();
    }

    @Override
    void buildA() {
        product.setBuildA("地基");
        System.out.println("地基");
    }

    @Override
    void buildB() {
        product.setBuildB("钢筋");
        System.out.println("钢筋");
    }

    @Override
    void buildC() {
        product.setBuildC("电线");
        System.out.println("电线");
    }

    @Override
    void buildD() {
        product.setBuildD("刷墙");
        System.out.println("刷墙");
    }

    @Override
    Product getProduct() {
        return this.product;
    }
}
