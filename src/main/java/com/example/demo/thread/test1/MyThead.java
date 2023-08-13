package com.example.demo.thread.test1;


import lombok.extern.slf4j.Slf4j;

import java.text.DecimalFormat;
import java.util.Random;

/**
 * 第一种方式
 */
@Slf4j
public class MyThead extends Thread {
    //共享数据有
    //100块钱分三个红包

    DecimalFormat decimalFormat = new DecimalFormat("#0.00");
    static double money = 100;
    static int count = 3;

    //最小的中奖金额
    static final double MIN_MONEY = 0.01;

    @Override
    public void run() {
        //同步代码块
        synchronized (MyThead.class) {
            if (count == 0) {
                //判断 共享数据是否到末尾（已经到了末尾）
                //证明红包抽完了
                log.info("{}没有抢到红包，小垃圾", getName());
            } else {
                //判断共享数据是否到末尾（没有到末尾）
                //还有红包
                //不能直接随机
                //定义一个抽中红包的金额
                double price = 0;
                if (count == 1) {
                    //证明这就是最后一个红包了，不需要随机，直接把钱拿走就行
                    price = money;
                } else {
                    //生成0-99.8的随机数
                    double bounds = money - (count - 1) * MIN_MONEY;
                    price = new Random().nextDouble() * bounds;
                    if (price < MIN_MONEY) {
                        price = MIN_MONEY;
                    }
                }
                money -= price;
                count--;
                String format = decimalFormat.format(price);
                //打印红包信息
                log.info("{}抢到了红包{}元", getName(), format);
            }
        }
    }
}
