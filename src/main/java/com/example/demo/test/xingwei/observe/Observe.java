package com.example.demo.test.xingwei.observe;


/**
 * 抽象观察者类
 */
public interface Observe {

    //主题推送更新
    void update(String msg);
}
