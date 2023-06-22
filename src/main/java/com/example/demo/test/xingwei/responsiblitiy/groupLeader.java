package com.example.demo.test.xingwei.responsiblitiy;


/**
 * 我是小组长
 * 我可以审批0到一天的调休
 */
public class groupLeader extends Handler {

    public groupLeader(){
        super(0,NUM_ONE);
    }
    @Override
    protected void handleLeave(LeaveRequest leave) {
        System.out.println(leave.getName()+"请假"+leave.getNumber()+"天-----"+leave.getContent());
        System.out.println("小组长审批，同意");
    }
}
