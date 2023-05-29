/**
 * Copyright © 2022 国网信通产业集团有限公司. All rights reserved.
 *
 * @title: FriedNoodles
 * @project: czy
 * @package: com.example.demo.test.jiegou.decorator
 * @date: 2023/5/29
 * @version: V1.0
 */
package com.example.demo.test.jiegou.decorator;

/**
 * FriedNoodles
 *  炒面类  具体的构建角色
 * @author czy
 * @date 2023/5/29
 */
public class FriedNoodles  extends FastFood{

    public FriedNoodles() {
        super(15,"炒面");
    }

    @Override
    public float cost() {
        return getPrice();
    }
}
