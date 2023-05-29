/**
 * Copyright © 2022 国网信通产业集团有限公司. All rights reserved.
 *
 * @title: client
 * @project: test
 * @package: com.example.demo.test.chuanjian.prototype.demo01
 * @date: 2023/5/23
 * @version: V1.0
 */
package com.example.demo.test.chuanjian.prototype.demo02;

import java.util.Date;

/**
 * client
 * 调用者
 * @author czy
 * @date 2023/5/23
 */
public class client {
    public static void main(String[] args) throws CloneNotSupportedException {
        //原型对象
        Date date = new Date();
        Video v1 = new Video("我是测试原型模式的", date);

        System.out.println("v1==========>"+v1);
        System.out.println("v1===hash=======>"+v1.hashCode());

        System.out.println("---------------------------------------------------我是一个分割线");

        //v1克隆v2
        Video v2 = (Video) v1.clone();
        System.out.println("v2==========>"+v2);
        System.out.println("v2===hash=======>"+v2.hashCode());

        date.setTime(1000000);
        System.out.println("------------------------------>>>>>>>>>>--------------------------------------");
        System.out.println("v1==========>"+v1);
        System.out.println("v1===hash=======>"+v1.hashCode());
        System.out.println("v2==========>"+v2);
        System.out.println("v2===hash=======>"+v2.hashCode());
    }
}
