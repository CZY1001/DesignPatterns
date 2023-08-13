package com.example.demo.thread.test4;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 有一个抽奖池 里面存放了奖励金额，奖项为
 * <p>
 * {1,5,20,50,100,200,500,800,2,80,300,700}
 * <p>
 * 创建两个抽奖箱（线程)，名字分别叫抽奖箱1，抽奖箱2
 * 随机从抽奖池中获取元素并打印到控制台上
 * <p>
 * 需要返回每个抽奖箱的最大奖还有每个抽奖箱自己的抽奖综合
 * 还需要显示全场最大的奖发生在哪个抽奖箱，是多少
 */
public class test4 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {


        List<Integer> list = new ArrayList<Integer>();
        Collections.addAll(list, 1, 5, 20, 50, 100, 200, 500, 800, 2, 80, 300, 700);
        //丢一百个奖进去
//        for (int i=1;i<=100;i++){
//            list.add(i);
//        }
        //创建多线程要运行的参数对象
        MyCallable myThead1 = new MyCallable(list);
        //创建管理者对象
        FutureTask<Integer> integerFutureTask1 = new FutureTask<>(myThead1);
        FutureTask<Integer> integerFutureTask2 = new FutureTask<>(myThead1);


        Thread thread1 = new Thread(integerFutureTask1);
        Thread thread2 = new Thread(integerFutureTask2);
        thread1.setName("抽奖箱1");
        thread2.setName("抽奖箱2");
        thread1.start();
        thread2.start();
        Integer max1 = integerFutureTask1.get();
        Integer max2 = integerFutureTask2.get();
        System.out.println("1----->" + max1);
        System.out.println("2----->" + max2);
        if (max1 > max2) {
            System.out.println("最大的奖项发生在" + thread1.getName() + "奖项为" + max1);
        } else {
            System.out.println("最大的奖项发生在" + thread2.getName() + "奖项为" + max2);
        }

    }
}
