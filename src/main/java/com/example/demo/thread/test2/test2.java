package com.example.demo.thread.test2;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 有一个抽奖池 里面存放了奖励金额，奖项为
 * <p>
 * {1,5,20,50,100,200,500,800,2,80,300,700}
 * <p>
 * 创建两个抽奖箱（线程)，名字分别叫抽奖箱1，抽奖箱2
 * 随机从抽奖池中获取元素并打印到控制台上
 */
public class test2 {
    public static void main(String[] args) {


        List<Integer> list = new ArrayList<Integer>();
        Collections.addAll(list, 1, 5, 20, 50, 100, 200, 500, 800, 2, 80, 300, 700);
        //丢一百个奖进去
        for (int i = 1; i <= 100; i++) {
            list.add(i);
        }

        MyThead myThead1 = new MyThead(list);
        MyThead myThead2 = new MyThead(list);


        myThead1.setName("一号箱子");
        myThead2.setName("二号箱子");

        myThead1.start();
        myThead2.start();

    }
}
