package com.example.demo.test.xingwei.responsiblitiy;


/**
 * 责任链模式
 *
 * 抽象处理者类
 */
public abstract class Handler {
    protected final static int NUM_ONE = 1;
    protected final static int NUM_THREE = 3;
    protected final static int NUM_SEVER = 7;

    //该领导处理的请假区间
    private int numStart;
    private int numEnd;

    //声明后继者
    private Handler nextHandler;

    public Handler(int numStart) {
        this.numStart = numStart;
    }

    public Handler(int numStart, int numEnd) {
        this.numStart = numStart;
        this.numEnd = numEnd;
    }
    //设置后继者对象
    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }
    //各领导处理请求条的方法
    protected abstract void handleLeave(LeaveRequest leave);

    //提交请假条
    public final void submit(LeaveRequest leave){
        //判断请假时间是否符合规定
        if(leave.getNumber()> NUM_SEVER){
            System.out.println("请假时间过长，不允许");
            return;
        }
        //该领导先进行审批
        this.handleLeave(leave);
        //判断有没有上级领导，并且需不需要上级领导审批、
        if (nextHandler != null && leave.getNumber() > this.numEnd) {
            //提交给上级领导进行审批
            this.nextHandler.submit(leave);
        } else {
            System.out.println("审批结束！！！！放假去吧");
        }
    }
}
