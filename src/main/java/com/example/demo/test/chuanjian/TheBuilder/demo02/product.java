/**
 * Copyright © 2022 国网信通产业集团有限公司. All rights reserved.
 *
 * @title: product
 * @project: test
 * @package: com.example.demo.test.chuanjian.TheBuilder.demo02
 * @date: 2023/5/21
 * @version: V1.0
 */
package com.example.demo.test.chuanjian.TheBuilder.demo02;

/**
 * product
 *  我是肯德基的套餐类
 * @author czy
 * @date 2023/5/21
 */
public class product {
    private String buildA = "我们现在是默认配置";
    private String buildB = "可乐";
    private String buildC = "炸鸡";
    private String buildD = "薯条";

    @Override
    public String toString() {
        return "product{" +
                "buildA='" + buildA + '\'' +
                ", buildB='" + buildB + '\'' +
                ", buildC='" + buildC + '\'' +
                ", buildD='" + buildD + '\'' +
                '}';
    }

    public String getBuildA() {
        return buildA;
    }

    public void setBuildA(String buildA) {
        this.buildA = buildA;
    }

    public String getBuildB() {
        return buildB;
    }

    public void setBuildB(String buildB) {
        this.buildB = buildB;
    }

    public String getBuildC() {
        return buildC;
    }

    public void setBuildC(String buildC) {
        this.buildC = buildC;
    }

    public String getBuildD() {
        return buildD;
    }

    public void setBuildD(String buildD) {
        this.buildD = buildD;
    }
}
