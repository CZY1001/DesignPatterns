package com.example.demo.thread.test3;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
public class MyThead extends Thread {
    //存储所有的奖，参数从调用者获取，如果调用者在一个线程，那么每个线程list最终会指向那个原本初始化的集合，这样就共享了
    List<Integer> list;
    //记录当前线程，抽中的奖
    List<Integer> list1 = new ArrayList<>();

    static int max = 0;


    static Integer index = 1;

    public MyThead(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        //1.循环
        //2.同步代码块
        while (true) {
            synchronized (index) {
                if (list.size() == 0) {
                    log.info("--------------------------------------------抽奖结束，公布结果--------------------------------");
                    Integer max = Collections.max(list1);
                    int sum = list1.stream().mapToInt(Integer::intValue).sum();
                    log.info("我是{},我的结果是{},最大值是{},总和是{}", getName(), list1, max, sum);
                    break;
                } else {
                    //继续抽奖
                    Collections.shuffle(list);
                    int price = list.remove(0);
                    list1.add(price);
                    index++;
                }
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
