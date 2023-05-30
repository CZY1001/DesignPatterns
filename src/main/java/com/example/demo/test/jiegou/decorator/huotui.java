/**
 * Copyright © 2022 国网信通产业集团有限公司. All rights reserved.
 *
 * @title: huotui
 * @project: czy
 * @package: com.example.demo.test.jiegou.decorator
 * @date: 2023/5/29
 * @version: V1.0
 */
package com.example.demo.test.jiegou.decorator;

/**
 * huotui
 *  我现在是具体的快餐装饰类   火腿类
 * @author czy
 * @date 2023/5/29
 */
public class huotui extends Garnish{


    public huotui(FastFood fastFood) {
        super(fastFood, 8, "火腿肠");
    }

    @Override
    public float cost() {
        return getPrice()+getFastFood().cost();
    }

    @Override
    public String getDesc() {
        return getFastFood().getDesc()+"加"+super.getDesc();
    }
}
