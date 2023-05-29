/**
 * Copyright © 2022 国网信通产业集团有限公司. All rights reserved.
 *
 * @title: FastFood
 * @project: czy
 * @package: com.example.demo.test.jiegou.decorator
 * @date: 2023/5/29
 * @version: V1.0
 */
package com.example.demo.test.jiegou.decorator;

/**
 * FastFood
 * 装饰器模式-------- 快餐类   抽象构建角色
 * @author czy
 * @date 2023/5/29
 */
public abstract class FastFood {
    private float price;//价格
    private String desc;//描述

    public FastFood() {
    }

    public FastFood(float price, String desc) {
        this.price = price;
        this.desc = desc;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public abstract  float cost();//价格计算
}
