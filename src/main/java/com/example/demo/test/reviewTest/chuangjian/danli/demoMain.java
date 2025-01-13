package com.example.demo.test.reviewTest.chuangjian.danli;

/**
 * @author czy
 * @summary
 * @date 2025-01-11 14:33
 */
public class demoMain {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("开始 test=="+System.currentTimeMillis());
        Thread.sleep(5000);
        System.out.println("start test=="+System.currentTimeMillis());
        demo01 instance = demo01.getInstance();
        System.out.println("demo01.getInstance() end=="+System.currentTimeMillis());
        instance.show();
        demo01 instance2 = demo01.getInstance();
        instance2.show();
        System.out.println("end test"+System.currentTimeMillis());
    }
}
