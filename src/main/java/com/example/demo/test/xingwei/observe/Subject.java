package com.example.demo.test.xingwei.observe;

/**
 * 抽象主题角色类   被观察者
 */
public interface Subject {

    //添加订阅者  （添加观察者对象）
    void attach(Observe observe);

    //删除订阅者  （删除观察者对象）
    void detach(Observe observe);

    //通知订阅者  更新消息
    void notify(String msg);
}
