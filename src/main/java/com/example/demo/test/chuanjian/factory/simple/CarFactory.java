package com.example.demo.test.chuanjian.factory.simple;


import org.apache.commons.lang3.StringUtils;

/**
 * CarFactory
 * 工厂模式，创建对象
 * @author czy
 * @date 2023/5/9
 */
public class CarFactory {

    //方法一
    public static Car getCarFactory(String car){
        if (StringUtils.isNotBlank(car)){
            if (car.equals("wulin")){
                return new wuling();
            }else if (car.equals("tesila")) {
                return new tesila();
            }else {
                return null;
            }
        }else {
            return null;
        }
    }
}
