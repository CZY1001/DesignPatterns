package com.example.demo.test.jiegou.appearance;

/**
 * @author czy
 * @description 客户端调用者
 * @date 2023/7/24
 */
public class clint {

    public static void main(String[] args) {
        shapeMake shapeMake = new shapeMake();
        shapeMake.haha(new human());
        shapeMake.haha(new cow());
        shapeMake.haha(new pig());
    }
}
