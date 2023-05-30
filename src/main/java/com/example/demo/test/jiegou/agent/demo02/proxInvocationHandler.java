/**
 * Copyright © 2022 国网信通产业集团有限公司. All rights reserved.
 *
 * @title: proxInvocationHandler
 * @project: test
 * @package: com.example.demo.test.jitgou.agent.demo02
 * @date: 2023/5/28
 * @version: V1.0
 */
package com.example.demo.test.jiegou.agent.demo02;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * proxInvocationHandler
 *
 * @author czy
 * @date 2023/5/28
 */
public class proxInvocationHandler implements InvocationHandler {

//被代理的接口
    private Object test;

    public void setObject(Object rent) {
        this.test = rent;
    }

    //生成得到的代理类
    public Object getProxy(){
        System.out.println("getProxy被调用了");
        /**
         * Proxy提供了创建动态代理类和实例的静态方法
         * newProxyInstance(ClassLoader loader, 类<?>[] interfaces, InvocationHandler h)
         *
         * loader - 类加载器来定义代理类
         * interfaces - 代理类实现的接口列表
         * h - 调度方法调用的调用处理函数
         * 返回指定接口的代理类的实例，该接口将方法调用分派给指定的调用处理程序。
         */
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),test.getClass().getInterfaces(),this);
    }

    /**
     *重写invoke类
     * @param proxy  调用的对象
     * @param method   调用的方法信息，例如方法名、返回类型等等
     * @param args
     * @return
     * @throws Throwable
     */
    //处理代理类实例，并返回结果
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("invoke被调用了");
        //通过反射调用方法
        Object invoke = method.invoke(test);
        return invoke;
    }
}
