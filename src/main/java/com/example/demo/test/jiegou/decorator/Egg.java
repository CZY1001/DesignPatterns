/**
 * Copyright © 2022 国网信通产业集团有限公司. All rights reserved.
 *
 * @title: Egg
 * @project: czy
 * @package: com.example.demo.test.jiegou.decorator
 * @date: 2023/5/29
 * @version: V1.0
 */
package com.example.demo.test.jiegou.decorator;

/**
 * Egg
 *  鸡蛋类   具体的装饰者角色
 * @author czy
 * @date 2023/5/29
 */
public class Egg extends Garnish{


    public Egg(FastFood fastFood) {
        super(fastFood,5,"鸡蛋");
    }

    @Override
    public float cost() {
        return getPrice()+ getFastFood().cost();
    }

    @Override
    public String getDesc() {
        return super.getDesc()+getFastFood().getDesc();
    }
}
