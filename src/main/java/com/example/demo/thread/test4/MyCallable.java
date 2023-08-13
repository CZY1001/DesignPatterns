package com.example.demo.thread.test4;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * 记笔记了
 * 实现了Callable接口之后，cal方法是可以有返回值的，而且还能抛出异常，之前run就不行
 */
@Slf4j
public class MyCallable implements Callable<Integer> {
    //存储所有的奖，参数从调用者获取，如果调用者在一个线程，那么每个线程list最终会指向那个原本初始化的集合，这样就共享了
    List<Integer> list;


    public MyCallable(List<Integer> list) {
        this.list = list;
    }

    @Override
    public Integer call() throws Exception {
        //记录当前线程，抽中的奖
        List<Integer> list1 = new ArrayList<>();
        //1.循环
        //2.同步代码块
        while (true) {
            synchronized (list) {
                if (list.size() == 0) {
                    Integer max = Collections.max(list1);
                    int sum = list1.stream().mapToInt(Integer::intValue).sum();
                    log.info("我是{},我的结果是{},最大值是{},总和是{}", Thread.currentThread().getName(), list1, max, sum);
                    break;
                } else {
                    //继续抽奖
                    Collections.shuffle(list);
                    int price = list.remove(0);
                    list1.add(price);
                }
            }
            Thread.sleep(1);
        }
        if (CollectionUtils.isEmpty(list1)) {
            return null;
        } else {
            return Collections.max(list1);
        }

    }
}
