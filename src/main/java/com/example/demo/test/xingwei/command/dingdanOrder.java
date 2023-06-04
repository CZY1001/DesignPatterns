package com.example.demo.test.xingwei.command;


import java.util.Map;

/**
 * 具体的命令类
 */
public class dingdanOrder implements mingling{

    //持有接受者对象
    private chushi chushi;

    //持有订单对象
    private Order Order;

    public dingdanOrder(com.example.demo.test.xingwei.command.chushi chushi, com.example.demo.test.xingwei.command.Order order) {
        this.chushi = chushi;
        Order = order;
    }

    @Override
    public void execute() {
        System.out.println("-----------"+Order.getDingingTable() + "桌的订单----------");
        Map<String, Integer> foodDir = Order.getFoodDir();
        foodDir.forEach((key,value)->{
            chushi.makeFood(key,value);
        });
        System.out.println(Order.getDingingTable() + "桌的饭搞好了，上菜！！！！！！！！！！！！！！！！！");

    }
}
