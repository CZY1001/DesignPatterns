package com.example.demo.test.jiegou.appearance;

/**
 * @author czy
 * @description 根据自身业务实现了接口里面的需要外观访问的说话方法
 * @date 2023/7/24
 */
public class human implements shape{
    @Override
    public void say() {
        System.out.println("我是人，我说话是：哈！！！哈！！！哈！！");
    }
}
