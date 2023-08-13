package com.example.demo.thread.test2;

import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.List;

@Slf4j
public class MyThead extends Thread {
    List<Integer> list;
    static int index = 1;

    public MyThead(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        int count = 1;
        //1.循环
        //2.同步代码块
        while (true) {
            synchronized (list) {
                if (list.size() == 0) {
                    break;
                } else {
                    //继续抽奖
                    Collections.shuffle(list);
                    int price = list.remove(0);
                    log.info("{}产生了{}元的大奖,他已经抽了{}次---->一共被抽了{}次", getName(), price, count, index);
                    count++;
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
