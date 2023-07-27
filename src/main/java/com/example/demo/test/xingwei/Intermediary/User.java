package com.example.demo.test.xingwei.Intermediary;

/**
 * @author czy
 * @description 用户类
 * @date 2023/7/26
 */
public class User {
    private String name;

    public String getName() {
        return name;
    }

    public User(String name) {
        this.name = name;
    }
    public void sendMessage(String message){
        chatRom.showMessage(this,message);
    }
}
