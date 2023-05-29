/**
 * Copyright © 2022 国网信通产业集团有限公司. All rights reserved.
 *
 * @title: Builder
 * @project: test
 * @package: com.example.demo.test.chuanjian.TheBuilder
 * @date: 2023/5/18
 * @version: V1.0
 */
package com.example.demo.test.chuanjian.TheBuilder.demo01;

/**
 * Builder
 *抽象的建造者方法
 * @author czy
 * @date 2023/5/18
 */

public abstract class Builder {
    abstract void buildA();
    abstract void buildB();
    abstract void buildC();
    abstract void buildD();

    abstract Product getProduct();
}
