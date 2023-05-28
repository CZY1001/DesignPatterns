/**
 * Copyright © 2022 国网信通产业集团有限公司. All rights reserved.
 *
 * @title: fangdong
 * @project: test
 * @package: com.example.demo.test.jitgou.agent.demo01
 * @date: 2023/5/25
 * @version: V1.0
 */
package com.example.demo.test.jitgou.agent.demo02;

/**
 * fangdong
 *   我现在是一个房东
 * @author czy
 * @date 2023/5/25
 */
public class fangdong implements Rent {
    @Override
    public void rent() {
        System.out.println("我是房东    ------      我房子租出去了");
    }

    @Override
    public void rent2() {
        System.out.println("rent2");
    }

    @Override
    public void rent3() {
        System.out.println("rent3");
    }

    @Override
    public void rent4() {
        System.out.println("rent4");
    }
}
