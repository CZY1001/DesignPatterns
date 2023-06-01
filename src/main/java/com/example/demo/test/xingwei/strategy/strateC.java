/**
 * Copyright © 2022 国网信通产业集团有限公司. All rights reserved.
 *
 * @title: strateC
 * @project: czy
 * @package: com.example.demo.test.xingwei.strategy
 * @date: 2023/6/1
 * @version: V1.0
 */
package com.example.demo.test.xingwei.strategy;

/**
 * strateC
 *
 * @author czy
 * @date 2023/6/1
 */
public class strateC implements Strategy{
    @Override
    public void show() {
        System.out.println("满500减100");
    }
}
