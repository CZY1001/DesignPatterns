/**
 * Copyright © 2022 国网信通产业集团有限公司. All rights reserved.
 *
 * @title: strateB
 * @project: czy
 * @package: com.example.demo.test.xingwei.strategy
 * @date: 2023/6/1
 * @version: V1.0
 */
package com.example.demo.test.xingwei.strategy;

/**
 * strateB
 *   具体策略实现类
 * @author czy
 * @date 2023/6/1
 */
public class strateB implements Strategy{
    @Override
    public void show() {
        System.out.println("全场八折");
    }
}
