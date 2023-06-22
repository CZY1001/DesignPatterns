package com.example.demo.test.xingwei.observe;


/**
 * 具体的观察者类  qq客户端
 */
public class TengxunQQ implements Observe {
    private String name;

    public TengxunQQ(String name) {
        this.name = name;
    }

    @Override
    public void update(String msg) {
        System.out.println(this.name + "---在QQ频道接收到了消息------=" + msg);
    }
}
