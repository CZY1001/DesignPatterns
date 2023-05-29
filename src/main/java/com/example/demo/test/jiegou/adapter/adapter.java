/**
 * Copyright © 2022 国网信通产业集团有限公司. All rights reserved.
 *
 * @title: adapter
 * @project: test
 * @package: com.example.demo.test.jitgou.adapter
 * @date: 2023/5/23
 * @version: V1.0
 */
package com.example.demo.test.jiegou.adapter;

/**
 * adapter
 *  真正的转接器
 *
 *  1 继承 （类适配器、单继承）
 *  2 组合（对象适配器、常用）
 * @author czy
 * @date 2023/5/23
 */
public class adapter extends adaptee implements netToUsb{
    @Override
    public void handleRequest() {
        super.request();//可以上网了
    }
}
