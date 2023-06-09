/**
 * Copyright © 2022 国网信通产业集团有限公司. All rights reserved.
 *
 * @title: client
 * @project: czy
 * @package: com.example.demo.test.jiegou.decorator
 * @date: 2023/5/29
 * @version: V1.0
 */
package com.example.demo.test.jiegou.decorator;

/**
 * client
 *  客户端    实际调用者  测试类
 * @author czy
 * @date 2023/5/29
 */
public class client {
    public static void main(String[] args) {
        //点一份炒饭  10快钱
        FastFood friedRice = new FriedRice();

        System.out.println(friedRice.getDesc()+"------->"+friedRice.cost()+"块钱");

        System.out.println("---------------我是一个分割线--------------------");
        //现在想加个鸡蛋
        friedRice= new Egg(friedRice);
        System.out.println(friedRice.getDesc()+"------->"+friedRice.cost()+"块钱");
        System.out.println("---------------我是一个分割线--------------------");
        huotui friedRices =  new huotui(friedRice);
        System.out.println(friedRices.getDesc()+"------->"+friedRices.cost()+"块钱");
    }
}
