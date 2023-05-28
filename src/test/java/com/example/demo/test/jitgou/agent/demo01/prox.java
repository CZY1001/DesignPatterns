/**
 * Copyright © 2022 国网信通产业集团有限公司. All rights reserved.
 *
 * @title: prox
 * @project: test
 * @package: com.example.demo.test.jitgou.agent.demo01
 * @date: 2023/5/25
 * @version: V1.0
 */
package com.example.demo.test.jitgou.agent.demo01;

/**
 * prox
 *  我是一个中介
 * @author czy
 * @date 2023/5/25
 */
public class prox  implements Rent{
    private  fangdong from;
    public prox() {
    }
    public prox(fangdong from) {
        this.from = from;
    }

    @Override
    public void rent() {
        kanfang();
        hetong();
        from.rent();
        tuifang();
    }

    //看房的
    public void  kanfang(){
        System.out.println("中介来带我看房了");
    }
    //签合同的
    public void hetong(){
        System.out.println("找中介签合同");
    }
    //退房的
    public void tuifang(){
        System.out.println("找中介推房子");
    }
}
