package com.example.demo.jsoup;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * 通过url爬取网站图片
 */
public class demo04 {

    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("https://www.veer.com/").get();
        Element root = doc.getElementById("root");
        Elements home_content4_images = root.getElementsByClass("search_result_asset_link");

        home_content4_images.forEach(item -> {
            Elements img = item.getElementsByTag("img");
            img.forEach(item2 -> {
                String attr = item2.attr("data-src");
                String attr2 = item2.attr("alt");
                attr = attr.replaceAll("//", "");
                System.out.println(attr2 + "--->" + attr);
            });
        });
    }
}
