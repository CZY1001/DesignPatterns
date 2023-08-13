package com.example.demo.thread.test1;


/**
 * ### 1 、 抢红包
 * 假设 100块   分成了三个红包，现在有五个人去抢
 * <p>
 * 其中、红包是共享数据
 * <p>
 * 五个人是5条线程
 * <p>
 * 打印结果需要如下
 * ```text
 * <p>
 * xxx抢到了xxx元
 * xxx抢到了xxx元
 * xxx抢到了xxx元
 * xxx没有抢到
 * xxx没有抢到
 * ```
 */
public class test {
    public static void main(String[] args) {


        MyThead myThead1 = new MyThead();
        MyThead myThead2 = new MyThead();
        MyThead myThead3 = new MyThead();
        MyThead myThead4 = new MyThead();
        MyThead myThead5 = new MyThead();

        myThead1.setName("A");
        myThead2.setName("B");
        myThead3.setName("C");
        myThead4.setName("D");
        myThead5.setName("E");


        myThead1.start();
        myThead2.start();
        myThead3.start();
        myThead4.start();
        myThead5.start();


    }
}
