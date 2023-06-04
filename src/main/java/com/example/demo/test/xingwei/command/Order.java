package com.example.demo.test.xingwei.command;

import java.util.HashMap;
import java.util.Map;

/**
 * 命令者模式  订单类
 */
public class Order {

    //餐桌号码
    private int dingingTable;

    private Map<String,Integer> foodDir = new HashMap<>();

    public int getDingingTable() {
        return dingingTable;
    }

    public void setDingingTable(int dingingTable) {
        this.dingingTable = dingingTable;
    }

    public Map<String, Integer> getFoodDir() {
        return foodDir;
    }

    public void setFood(String name, Integer num) {
        this.foodDir.put(name, num);
    }
}
