/**
 * Copyright © 2022 国网信通产业集团有限公司. All rights reserved.
 *
 * @title: strateMan
 * @project: czy
 * @package: com.example.demo.test.xingwei.strategy
 * @date: 2023/6/1
 * @version: V1.0
 */
package com.example.demo.test.xingwei.strategy;

/**
 * strateMan
 *  促销员     环境类
 * @author czy
 * @date 2023/6/1
 */
public class strateMan {
    //聚合一下策略对象
    private Strategy strategy;

    public strateMan(Strategy strategy) {
        this.strategy = strategy;
    }

    //促销员根据环境来展示不同的促销活动（调用不同的策略）
    public void salesMan(){
        strategy.show();
    }
}
