package com.example.demo.test.xingwei.Intermediary;

/**
 * @author czy
 * @description 客户类
 * @date 2023/7/27
 */
public class clint {
    public static void main(String[] args) {
        User czyy = new User("czyy");
        User zhangsan = new User("张三");

        czyy.sendMessage("开饭啦，快去干饭！！！！！！！！！！！！！！！！！！！！！！！！！");
        zhangsan.sendMessage("我是法外狂徒，法律不可能制裁我");
    }
}
