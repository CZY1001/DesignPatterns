package com.example.demo.test.xingwei.Intermediary;

import org.apache.http.client.utils.DateUtils;

import java.util.Date;

/**
 * @author czy
 * @description 中介类
 * @date 2023/7/26
 */
public class chatRom {
    public static void showMessage(User user, String message){
        System.out.println(DateUtils.formatDate(new Date(),"yyyy-MM-dd HH:mm:ss") + "------>"+user.getName() + " : "+message);

    }
}
