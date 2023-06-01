/**
 * Copyright © 2022 国网信通产业集团有限公司. All rights reserved.
 *
 * @title: strateA
 * @project: czy
 * @package: com.example.demo.test.xingwei.strategy
 * @date: 2023/6/1
 * @version: V1.0
 */
package com.example.demo.test.xingwei.strategy;

/**
 * strateA
 *     具体策略类
 * @author czy
 * @date 2023/6/1
 */
public class strateA implements Strategy{
    @Override
    public void show() {
        System.out.println("买一送一");
    }
}
