package com.example.demo.test.xingwei.command;


/**
 * 客户端，实际调用者   来吃饭的     命令者模式
 */
public class clint {
    public static void main(String[] args) {
        //第一个来吃饭的
        Order o1 = new Order();
        o1.setFood("大盘鸡",2);
        o1.setFood("宫保鸡丁",1);
        o1.setDingingTable(1);
        //第二个来吃饭的

        Order o2 = new Order();
        o2.setFood("葱爆羊肉",2);
        o2.setFood("油焖大虾",1);
        o2.setFood("大窑",5);
        o2.setDingingTable(3);

        //创建厨师
        chushi chushi = new chushi();
        //创建命令对象
        mingling dingdanOrder1 = new dingdanOrder(chushi,o1);
        mingling dingdanOrder2 = new dingdanOrder(chushi,o2);
        //创建服务员
        waitor waitor = new waitor();
        waitor.setCommand(dingdanOrder1);
        waitor.setCommand(dingdanOrder2);
        waitor.orderUp();
    }
}
