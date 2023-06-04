package com.example.demo.test.xingwei.command;

import java.util.ArrayList;
import java.util.List;

/**
 * 服 务员类  请求者 调用者角色
 */
public class waitor {
    //持有多个命令对象
    private List<mingling> commands = new ArrayList<>();

    public void setCommand(mingling commands) {
        this.commands.add(commands);
    }

    //发起命令的方法 喊订单来了   厨师就开始干活

    public  void orderUp(){
        System.out.println("服务员：来活咯，厨师快干活");
        this.commands.forEach(item->{
            if (item!=null){
                item.execute();
            }
        });
    }
}
