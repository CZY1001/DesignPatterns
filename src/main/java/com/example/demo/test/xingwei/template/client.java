/**
 * Copyright © 2022 国网信通产业集团有限公司. All rights reserved.
 *
 * @title: client
 * @project: czy
 * @package: com.example.demo.test.xingwei.template
 * @date: 2023/5/31
 * @version: V1.0
 */
package com.example.demo.test.xingwei.template;

/**
 * client
 *  测试类，实际调用者
 * @author czy
 * @date 2023/5/31
 */
public class client {

    public static void main(String[] args) {
        //我现在要炒包菜
        AbstractClass baocai = new baoCai();
        baocai.pengreng();
        System.out.println("----------------------------------");
        //我现在要做玉米炒肉
        AbstractClass rousi = new rousi();
        rousi.pengreng();
    }
}
