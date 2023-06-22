package com.example.demo.test.xingwei.responsiblitiy;


/**
 * 测试类  实际调用者
 */
public class clint {
    public static void main(String[] args) {
        //创建一个请假对象
        LeaveRequest leaveRequest = new LeaveRequest("小明",7,"出去玩");
        //创建各级领导对象
        groupLeader groupLeader = new groupLeader();
        manager manager = new manager();
        GeneralManager generalManager = new GeneralManager();
        //设置处理者链
        groupLeader.setNextHandler(manager);
        manager.setNextHandler(generalManager);

        //提交请假申请
        groupLeader.submit(leaveRequest);
    }
}
