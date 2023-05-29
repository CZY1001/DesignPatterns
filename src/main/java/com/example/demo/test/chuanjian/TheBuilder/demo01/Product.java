/**
 * Copyright © 2022 国网信通产业集团有限公司. All rights reserved.
 *
 * @title: Product
 * @project: test
 * @package: com.example.demo.test.chuanjian.TheBuilder
 * @date: 2023/5/18
 * @version: V1.0
 */
package com.example.demo.test.chuanjian.TheBuilder.demo01;

/**
 * Product
 *
 * @author czy
 * @date 2023/5/18
 */
public   class Product {
    private  String buildA;
    private  String buildB;
    private  String buildC;

    @Override
    public String toString() {
        return "Product{" +
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

    private  String buildD;

}
