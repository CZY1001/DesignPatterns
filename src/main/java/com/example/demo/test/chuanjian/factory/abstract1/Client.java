/**
 * Copyright © 2022 国网信通产业集团有限公司. All rights reserved.
 *
 * @title: Client
 * @project: test
 * @package: com.example.demo.test.chuanjian.factory.abstract1
 * @date: 2023/5/18
 * @version: V1.0
 */
package com.example.demo.test.chuanjian.factory.abstract1;

/**
 * Client
 *
 * @author czy
 * @date 2023/5/18
 */
public class Client extends huaweiFactory {


    public static void main(String[] args) {
        System.out.println("--------------------------------小米系列-----------------------");
        xiaomiFactory xiaomiFactory = new xiaomiFactory();

        luyouqi luyouqigongchange = xiaomiFactory.luyouqigongchange();
        luyouqigongchange.start();
        luyouqigongchange.setting();

        shouji shoujigongchang = xiaomiFactory.shoujigongchang();
        shoujigongchang.start();
        shoujigongchang.sendMS();
        shoujigongchang.callup();
        System.out.println("--------------------------------华为产品-----------------------");
        huaweiFactory huaweiFactory = new huaweiFactory();

        luyouqi aa = huaweiFactory.luyouqigongchange();
        aa.start();
        aa.setting();
        shouji aaa = huaweiFactory.shoujigongchang();
        aaa.start();
        aaa.sendMS();
        aaa.callup();
    }
}
