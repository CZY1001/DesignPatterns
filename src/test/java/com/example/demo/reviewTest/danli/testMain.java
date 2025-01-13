package com.example.demo.reviewTest.danli;

import com.example.demo.test.reviewTest.chuangjian.danli.demo01;
import com.example.demo.test.reviewTest.chuangjian.danli.demo02;
import com.example.demo.test.reviewTest.chuangjian.danli.demo03;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author czy
 * @summary 使用测试
 * @date 2025-01-11 10:14
 */
@SpringBootTest
public class testMain {
    /**
     *  在 首次调用demo01.getInstance();的时候
     *  会先进初始化 init sleep 10秒才会打印 demo01 getInstance
     *  第二次的时候就直接获取实例，不会再初始化了
     *
     */
    @Test
    public void test01() throws InterruptedException {
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

    /**
     * 在首次调用demo02.getInstance();的时候
     * 会先进入到 getInstance中打印  demo02 getInstance获取实例
     * 判断实例对象为空，才会去初始化init创建对象，然后返回
     * 第二次判断对象不为空，就不会初始化了，直接返回实例对象
     */
    @Test
    public void test02(){
        System.out.println("start test"+System.currentTimeMillis());
        demo02 instance = demo02.getInstance();
        System.out.println("start end"+System.currentTimeMillis());
        instance.show();
        demo02 instance2 = demo02.getInstance();
        instance2.show();
        System.out.println("end test"+System.currentTimeMillis());
    }

    /**
     * 和test2没太大区别
     * 只是给getinstance加了sy锁，保证了线程安全
     */
    @Test
    public void test03(){
        System.out.println("start test"+System.currentTimeMillis());
        demo03 instance = demo03.getInstance();
        System.out.println("start end"+System.currentTimeMillis());
        instance.show();
        demo03 instance2 = demo03.getInstance();
        instance2.show();
    }
}
