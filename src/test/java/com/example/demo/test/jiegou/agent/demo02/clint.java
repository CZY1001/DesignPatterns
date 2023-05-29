/**
 * Copyright © 2022 国网信通产业集团有限公司. All rights reserved.
 *
 * @title: clint
 * @project: test
 * @package: com.example.demo.test.jitgou.agent.demo02
 * @date: 2023/5/28
 * @version: V1.0
 */
package com.example.demo.test.jiegou.agent.demo02;

/**
 * clint
 *
 * @author czy
 * @date 2023/5/28
 */
public class clint {
    public static void main(String[] args) {
        //真实角色
        fangdong fangdong = new fangdong();
        //实例化代理生成类
        proxInvocationHandler proxInvocationHandler = new proxInvocationHandler();
        //设置被代理的接口 ，个人感觉在实例代理类的时候可以加一个构造来设置被代理的接口
        proxInvocationHandler.setObject(fangdong);
        //获取生成的代理类
        Rent proxy = (Rent)proxInvocationHandler.getProxy();
        //通过invoke 方法执行 我们想要执行的方法，会吧我们实例出来的真实类和 需要调用方法的方法信息传给invoke
        proxy.rent();
        proxy.rent3();
        proxy.rent2();
        proxy.rent4();
    }
}
