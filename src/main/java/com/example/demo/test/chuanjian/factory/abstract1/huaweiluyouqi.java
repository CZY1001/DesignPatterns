/**
 * Copyright © 2022 国网信通产业集团有限公司. All rights reserved.
 *
 * @title: huaweiluyouqi
 * @project: test
 * @package: com.example.demo.test.chuanjian.factory.abstract1
 * @date: 2023/5/16
 * @version: V1.0
 */
package com.example.demo.test.chuanjian.factory.abstract1;

/**
 * huaweiluyouqi
 *
 * @author czy
 * @date 2023/5/16
 */
public class huaweiluyouqi implements  luyouqi{
    @Override
    public void start() {
        System.out.println("开启华为路由器");
    }

    @Override
    public void shutdown() {
        System.out.println("关闭华为路由器");
    }

    @Override
    public void openWifi() {
        System.out.println("华为开启wifi");
    }

    @Override
    public void setting() {
        System.out.println("华为设置");
    }
}
