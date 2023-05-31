/**
 * Copyright © 2022 国网信通产业集团有限公司. All rights reserved.
 *
 * @title: AbstractClass
 * @project: czy
 * @package: com.example.demo.test.xingwei.template
 * @date: 2023/5/31
 * @version: V1.0
 */
package com.example.demo.test.xingwei.template;

/**
 * AbstractClass
 *  抽象类  定义模板方法和基本方法
 * @author czy
 * @date 2023/5/31
 */
public abstract class AbstractClass {

    //模板方法定义
    public final void pengreng(){
        daoyou();
        reyou();
        daocai();
        tiaoliao();
        fanchao();
    }
    //倒油
    public void  daoyou(){
        System.out.println("倒油");
    }
    //热油
    public void reyou(){
        System.out.println("热油");
    }
    //倒菜
    public abstract void daocai();
    //加调料
    public abstract void tiaoliao();
    //翻炒
    public void fanchao(){
        System.out.println("抄啊抄啊抄熟了");
    }
}
