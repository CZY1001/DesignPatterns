/**
 * Copyright © 2022 国网信通产业集团有限公司. All rights reserved.
 *
 * @title: clint
 * @project: czy
 * @package: com.example.demo.test.xingwei.strategy
 * @date: 2023/6/1
 * @version: V1.0
 */
package com.example.demo.test.xingwei.strategy;

/**
 * clint
 *   测试类   实际调用者
 * @author czy
 * @date 2023/6/1
 */
public class clint {
    public static void main(String[] args) {
        //现在是春节   执行A活动
        strateMan strateMan = new strateMan(new strateA());
        strateMan.salesMan();
        //现在国庆节   执行B活动
        strateMan = new strateMan(new strateB());
        strateMan.salesMan();
        //现在是圣诞节   执行C活动
        strateMan = new strateMan(new strateC());
        strateMan.salesMan();
    }
}
