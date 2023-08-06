package com.example.demo.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

/**
 * 爬取图片
 */
public class demo05 {
    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("https://www.veer.com/search-image/meinv/?sort=best")
                .cookie("Cookie", "sajssdk_2015_cross_new_user=1; Hm_lvt_570c19b57e9546eace71ea5e6aa9383a=1690708600; acw_tc=276077e116907127340825832ef29d5da20ca91dd30ea203ba227dd5585728; acw_sc__v2=64c63aa05c720b24bc629145143635d835373f70; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22189a615e2d0d7a-014d65a09f91dfd-7f5d5474-1327104-189a615e2d11158%22%2C%22first_id%22%3A%22%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%A4%BE%E4%BA%A4%E7%BD%91%E7%AB%99%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC%22%2C%22%24latest_referrer%22%3A%22https%3A%2F%2Fopen.weixin.qq.com%2F%22%2C%22%24latest_landing_page%22%3A%22https%3A%2F%2Fwww.veer.com%2Fsign-in%2F%3Fref%3D%2Fsearch-image%2Fgaoqingtupian%2F%22%7D%2C%22%24device_id%22%3A%22189a615e2d0d7a-014d65a09f91dfd-7f5d5474-1327104-189a615e2d11158%22%7D; st=VEER-ST-1475657-504-92d52c03cbcd4b6e8afdd5225066f6c4; uid=1475657; Hm_lpvt_570c19b57e9546eace71ea5e6aa9383a=1690712845; vtoken=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdCI6IlZFRVItU1QtMTQ3NTY1Ny01MDQtOTJkNTJjMDNjYmNkNGI2ZThhZmRkNTIyNTA2NmY2YzQiLCJ0aWNrZXQiOiI2QjdFOERFMzNDNkYzMEI4MkMzQzNBODQxNjJEQ0M0NUQyNjBGNDEwM0NBOTQ4RDc5NjA5NkIxMTk2MjU3QzY4MEI1OTNGNzBERjdGRjNDMDYyNkQyNUI0ODk3OUUxNUEiLCJwYXlTdGF0dXMiOiIiLCJ1aWQiOjE0NzU2NTcsIm5hbWUiOiLotKbmiLciLCJtb2JpbGUiOiIxMzIqKioqODg1NyIsInJlZ1RpbWUiOiIyMDIzLTA3LTMwIDE4OjI3OjIzIiwiYWNjb3VudEVtYWlsIjoiIiwiYWNjb3VudE1vYmlsZSI6IjEzMjY0ODY4ODU3IiwidmNnSWQiOiI2MjgxN2ZjNzI0MDczOTUyN2VjYmJlZWJlNTM3NDUyOTUiLCJhdXRvTG9naW4iOjEsImlhdCI6MTY5MDcxMjg0NCwiZXhwIjo0MjgyNzEyODQ0fQ.jzKbtyKPl6eJl6DMTZ4E5SjTWkP9yugN7Cm3r2qYiIo; _fp_=eyJpcCI6IjI3LjQyLjg3LjIzOSIsImZwIjoiNjBlNTExZWFlYzY1NTZlNzU4NzIyY2JiZGZiZGI0YTciLCJocyI6IiQyYSQwOCRpWGhzLk02Z29ld0NrYkppS0tNM1BPamJPN280bVR0LnJxUDN1NldITEsyampHTFc5WlI3UyJ9; ssxmod_itna=YqROD5DKYK4fEDl4iu3UD9ibGkFAEEhXAx5tUdD/FC+DnqD=GFDK40EAgopReue5BARr4DuC2hrQftGO4dzqWgx84ao+B40aDbqGkK5COQGGUxBYDQxAYDGDDPDoZPD1D3qDkD72=1lgx5Dbxi3UxiaDGeDegK8DY5DhxDC2nPDwx0CUhhroB9+1ZB1HFvrdU04UxG1O40HtBSvT/8jony+vI3hfGKDXgdDvpy1/ZcpDBbCVE5hpDcDTerFYAPdK60xeQ2rNa455eU5zI+reBnqqA/PrGxMoDDWd00PFQ+DD; ssxmod_itna2=YqROD5DKYK4fEDl4iu3UD9ibGkFAEEhXAx5ttG9bcDBqqdx7pEq4gP54r+9PgOdlxeyiD6lTBXG6I2l5R+dpbC02m6KYdf0OC5SeCrvRjtag9sIo+IEHj8wUt842DIEOcLWsRzVls0MjZ8LjlSd3xcq3ceq6euMLxv8=ybTKPMkKD2WjSlbLQ=mb2j+jSYZ=/A22YkmWK=Wc3O=cdvAnCaarwnfvE0wQTXmysCBY60BiOtFaCapqm2Ed+Wz011aIzDP5rEzujq/Rq+WdRoTCYaaOUHBT+byBjyzd6FilOtIUtv6pZ1ysvh1HbOrorqYPD7jx7ve76s0hoBDOewsADsQwYtqQjDcQDWx2oj2t3qtnwKf=o+q40xOCD7n4Mlw1QhatryhdyrrrGoMWReBislqQ0TMBT4YAlrGqGEFFh5Rjp9nUO6QIq87WCWqWe=bShothjRhqDGcDG71gqqYK=EwmLwIro5iiI8DgnD46o5B6siiEPGd0K/AU70QeBHI3qdc5t0x4D===; queryKey=6CLR08O66P6")
                .get();
        Element root = doc.getElementById("root");
        Elements home_content4_images = root.getElementsByClass("search_result_asset_link");

        home_content4_images.forEach(item -> {
            Elements img = item.getElementsByTag("img");
            img.forEach(item2 -> {
                String attr = item2.attr("data-src");
                String attr2 = item2.attr("alt");
                //保存到本地
                String url = "http:" + attr;
                try {
                    URL url1 = new URL(url);
                    URLConnection uri = url1.openConnection();
                    InputStream inputStream = uri.getInputStream();
                    //名字
                    String name = attr2 + attr.substring(attr.lastIndexOf("."));
                    OutputStream os = new FileOutputStream(new File("F:/test/", name));

                    byte[] buf = new byte[1024];
                    int p = 0;
                    while ((p = inputStream.read(buf)) != -1) {
                        os.write(buf, 0, p);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println(attr2 + "--->" + url);
                }
            });
        });
    }
}
