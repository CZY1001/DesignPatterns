package com.example.demo.test.jiegou.appearance;

/**
 * @author czy
 * @description 根据自身业务实现了接口里面的需要外观访问的方法
 * @date 2023/7/24
 */
public class cow implements shape{
    @Override
    public void say() {
        System.out.println("我是牛，我说话：哞！！！哞！！！牟！！！");
    }
}
