package com.example.demo.jsoup;

import lombok.extern.log4j.Log4j2;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author czy
 * @description 这是一个爬虫测试demo   爬取笔趣阁小说
 * @date 2023/7/31
 */
@Log4j2
public class test {

    public static void main(String[] args) throws IOException, InterruptedException {
        test test = new test();
        test.start("https://www.ibiquges.info/118/118977/");
    }

    /**
     * 启动 爬虫
     *
     * @param url
     */
    public void start(String url) throws IOException, InterruptedException {
        Document document = Jsoup.connect(url).get();
//   #表示 id  class前面要用.表示
        String attr = document.select(".box_con>#list>dl>dd>a").attr("abs:href");
        String h1 = document.select("h1").text();
        String path = "D:/testt/ " + h1;
        save(attr, path);

    }

    /**
     * @param url  章节地址
     * @param path 保存路径
     * @author czy
     * @description 保存数据到文件
     */
    public void save(String url, String path) throws IOException, InterruptedException {
        Document document = Jsoup.connect(url).get();
        Element content = document.getElementById("content");
        String text = content.text().replaceAll("       ", "\n").replaceAll("。", "。\n");
        String title = document.getElementsByTag("h1").text();
        String next = document.getElementsByClass("bottem2").get(0).child(3).attr("abs:href");

        File file = createFile(title, path);
        writerFile(file, text);
        if (next.contains("html")) {
            log.info("-----下一章------>" + title);
            Thread.sleep(2000);
            save(next, path);
        }

    }

    /**
     * 创建文件
     *
     * @param name 文件名
     */
    public File createFile(String name, String path) {
        File file = new File(path + "/ " + name + ".txt");

        try {
            //获取父目录
            File parentFile = file.getParentFile();
            //如果没有就创建目录
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            //创建文件
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("新建文件夹出错了");
        }
        return file;
    }

    /**
     * 写入到文件
     *
     * @param file
     * @param context
     */
    public void writerFile(File file, String context) {
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            PrintWriter writer = new PrintWriter(fileWriter);
            writer.println(context);
            writer.println("\n");
            writer.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("写入文件出错了");
        }
    }
}
