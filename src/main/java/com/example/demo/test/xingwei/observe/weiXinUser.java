package com.example.demo.test.xingwei.observe;


/**
 * 具体的观察者类
 */
public class weiXinUser implements Observe {
    private String name;

    public weiXinUser(String name) {
        this.name = name;
    }

    @Override
    public void update(String msg) {
        System.out.println(this.name + "-----在微信公众号接收到了消息------=" + msg);
    }
}
