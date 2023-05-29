/**
 * Copyright © 2022 国网信通产业集团有限公司. All rights reserved.
 *
 * @title: computer
 * @project: test
 * @package: com.example.demo.test.jitgou.adapter
 * @date: 2023/5/23
 * @version: V1.0
 */
package com.example.demo.test.jiegou.adapter;

/**
 * computer
 * 电脑类
 * 适配器模式    ---- 客户端类
 * @author czy
 * @date 2023/5/23
 */
public class computer {

    public void  net(netToUsb adapter){
        //上网的具体实现，  需要一个转接
        adapter.handleRequest();
    }

    public static void main(String[] args) {
        //电脑、适配器、网线----
        computer computer = new computer();//使用者   电脑
        adaptee adaptee = new adaptee();//网线

        adapter2 adapter = new adapter2(adaptee);//转接器


        computer.net(adapter);
    }
}
