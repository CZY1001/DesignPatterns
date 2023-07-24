package com.example.demo.test.jiegou.appearance;

/**
 * @author czy
 * @description 根据自身业务实现了接口里面的需要外观访问的方法
 * @date 2023/7/24
 */
public class pig implements shape{
    @Override
    public void say() {
        System.out.println("我是猪，我说话是，哼哧！！哼哧！！！");
    }
}
