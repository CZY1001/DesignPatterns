package com.example.demo.test.chuanjian.TheBuilder.demo01;

/**
 * test
 *          建造者模式   builder模式的常规用法
 * @author czy
 * @date 2023/5/21
 */
public class test {

    public static void main(String[] args) {
        //领导
        leader leader = new leader();
        //指挥工人完成产品
        Product build = leader.build(new worker());
        System.out.println(build.toString());
    }
}
