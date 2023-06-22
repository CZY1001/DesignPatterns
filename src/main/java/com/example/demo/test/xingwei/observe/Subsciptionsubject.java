package com.example.demo.test.xingwei.observe;


import java.util.ArrayList;
import java.util.List;

/**
 * 具体主题角色类   （被观察者类）   公众号
 */
public class Subsciptionsubject implements Subject {
    //定义一个集合来存储多个观察者对象
    private List<Observe> list = new ArrayList<>();

    @Override
    public void attach(Observe observe) {
        list.add(observe);
    }

    @Override
    public void detach(Observe observe) {
        list.remove(observe);
    }

    //通知订阅者  更新消息
    @Override
    public void notify(String msg) {
        //当公证号里面内容发送变化时会执行
        list.forEach(item -> {
            //调用观察者对象中的更新方法
            item.update(msg);
        });
    }
}










