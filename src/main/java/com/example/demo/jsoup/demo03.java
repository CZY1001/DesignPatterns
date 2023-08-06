package com.example.demo.jsoup;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * 通过url去解析html
 */
public class demo03 {

    public static void main(String[] args) throws IOException {
//        Document document = Jsoup.connect("http://www.baidu.com").get();
        Document doc = Jsoup.connect("http://www.baidu.com")
                .data("query", "Java")
                .userAgent("Mozilla")
                .cookie("auth", "token")
                .timeout(3000)
                .post();
        System.out.println(doc);
    }
}
