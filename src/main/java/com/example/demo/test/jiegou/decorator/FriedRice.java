/**
 * Copyright © 2022 国网信通产业集团有限公司. All rights reserved.
 *
 * @title: FriedRice
 * @project: czy
 * @package: com.example.demo.test.jiegou.decorator
 * @date: 2023/5/29
 * @version: V1.0
 */
package com.example.demo.test.jiegou.decorator;

/**
 * FriedRice
 *  炒饭类 具体构建角色
 * @author czy
 * @date 2023/5/29
 */
public class FriedRice  extends FastFood{

    public FriedRice() {
        //炒饭10块钱一份
        super(10,"炒饭");
    }
    @Override
    public float cost() {
        return getPrice();
    }
}
