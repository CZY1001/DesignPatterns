package com.example.demo.test.xingwei.observe;


/**
 * 测试类
 */
public class clint {
    public static void main(String[] args) {

        //创建公众号对象
        Subject subject = new Subsciptionsubject();
        //订阅公众号
        Observe observe = new TengxunQQ("czyyy");
        Observe observe2 = new weiXinUser("lsz");
        subject.attach(observe);
        subject.attach(observe2);
        //推送消息
        subject.notify("czyyyy中了五百万彩票");
    }
}
