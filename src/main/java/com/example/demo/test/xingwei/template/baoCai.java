/**
 * Copyright © 2022 国网信通产业集团有限公司. All rights reserved.
 *
 * @title: baoCai
 * @project: czy
 * @package: com.example.demo.test.xingwei.template
 * @date: 2023/5/31
 * @version: V1.0
 */
package com.example.demo.test.xingwei.template;

/**
 * baoCai
 *          抄包菜的类
 * @author czy
 * @date 2023/5/31
 */
public class baoCai extends AbstractClass{
    @Override
    public void daocai() {
        System.out.println("包菜下锅");
    }

    @Override
    public void daoyou() {
        System.out.println("倒入菜籽油");
    }

    @Override
    public void tiaoliao() {
        System.out.println("加入辣椒大蒜调味");
    }
}
