/**
 * Copyright © 2022 国网信通产业集团有限公司. All rights reserved.
 *
 * @title: Video
 * @project: test
 * @package: com.example.demo.test.chuanjian.prototype.demo01
 * @date: 2023/5/23
 * @version: V1.0
 */
package com.example.demo.test.chuanjian.prototype.demo02;

import java.util.Date;

/**
 * Video
 *
 *
 * 原型模式    ----- 浅克隆
 * @author czy
 * @date 2023/5/23
 */
public class Video implements Cloneable{
    private String name;
    private Date createTime;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object clone = super.clone();
        Video clone1 = (Video) clone;
        clone1.createTime = (Date) this.createTime.clone();
        return clone;
    }

    public Video(String name, Date createTime) {
        this.name = name;
        this.createTime = createTime;
    }
    public Video(){
    }

    @Override
    public String toString() {
        return "Video{" +
                "name='" + name + '\'' +
                ", createTime=" + createTime +
                '}';
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
