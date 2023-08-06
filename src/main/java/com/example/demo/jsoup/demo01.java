package com.example.demo.jsoup;

import lombok.extern.log4j.Log4j2;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

@Log4j2
public class demo01 {
    public static void main(String[] args) {
        String html = "<html><head><title>First parse</title></head>"
                + "<body><p>Parsed HTML into a doc.</p></body></html>";
        Document doc = Jsoup.parse(html);


        System.out.println(doc.body());
        log.info("-------------------1-------------------");
        System.out.println(doc.title());
        log.info("-------------------2-------------------");
        System.out.println(doc.head().text());
    }
}
