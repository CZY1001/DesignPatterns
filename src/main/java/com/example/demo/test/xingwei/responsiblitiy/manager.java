package com.example.demo.test.xingwei.responsiblitiy;

/**
 * 部门经理类
 * 我可以审批1-3天的请假
 */
public class manager extends Handler{

    public manager(){
        super(NUM_ONE,NUM_THREE);
    }

    @Override
    protected void handleLeave(LeaveRequest leave) {
        System.out.println(leave.getName()+"请假"+leave.getNumber()+"天-----"+leave.getContent());
        System.out.println("部门经理审批，同意");
    }
}
