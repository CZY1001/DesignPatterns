package com.example.demo.test.xingwei.responsiblitiy;

/**
 * 责任链模式
 * 请假条类
 */
public class LeaveRequest {
    //请假人姓名
    private String name;
    //请假天数
    private Integer number;
    //请假内容
    private String content;

    public LeaveRequest(String name, Integer number, String content) {
        this.name = name;
        this.number = number;
        this.content = content;
    }
    public String getName() {
        return name;
    }

    public Integer getNumber() {
        return number;
    }

    public String getContent() {
        return content;
    }
}
