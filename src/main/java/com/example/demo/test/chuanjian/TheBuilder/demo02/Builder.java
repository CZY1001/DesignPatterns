/**
 * Copyright © 2022 国网信通产业集团有限公司. All rights reserved.
 *
 * @title: Builder
 * @project: test
 * @package: com.example.demo.test.chuanjian.TheBuilder.demo02
 * @date: 2023/5/21
 * @version: V1.0
 */
package com.example.demo.test.chuanjian.TheBuilder.demo02;

/**
 * Builder
 *   我是一个抽象的工人
 * @author czy
 * @date 2023/5/21
 */
public abstract class Builder {
    abstract Builder buildA(String msg);
    abstract Builder buildB(String msg);
    abstract Builder buildC(String msg);
    abstract Builder buildD(String msg);
    abstract product getProduct();
}
