package com.example.demo.test.xingwei.responsiblitiy;

/**
 * 总经理类
 * 我可以审批
 */
public class GeneralManager extends Handler{

    public GeneralManager(){
        super(NUM_THREE,NUM_SEVER);
    }

    @Override
    protected void handleLeave(LeaveRequest leave) {
        System.out.println(leave.getName()+"请假"+leave.getNumber()+"天-----"+leave.getContent());
        System.out.println("总经理审批，同意");
    }
}
