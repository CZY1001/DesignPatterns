package com.example.demo.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * 通过字符串解析html
 */
public class demo02 {

    public static void main(String[] args) {
        String html = "<div><p>Lorem ipsum.</p>";
        Document doc = Jsoup.parseBodyFragment(html);

        System.out.println(doc);
        System.out.println("1------------------------------");

        Element body = doc.body();
        System.out.println(body);
    }
}
