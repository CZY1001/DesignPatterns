/**
 * Copyright © 2022 国网信通产业集团有限公司. All rights reserved.
 *
 * @title: test
 * @project: demo
 * @package: com.example.demo
 * @date: 2023/4/8
 * @version: V1.0
 */
package com.example.demo;

import com.alibaba.fastjson.JSON;


import com.example.demo.test.pojo;

import org.apache.http.HttpHost;

import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import java.io.IOException;
import java.util.*;

import static com.example.demo.test.changliang.STR;

/**
 * test
 *
 * @author czy
 * @date 2023/4/8
 */
@SpringBootTest
public class test1 {

    private RestHighLevelClient client;

    /**
     * 创建索引库
     * @throws IOException
     */
    @Test
    void test1() throws IOException {
        CreateIndexRequest test11 = new CreateIndexRequest("test11");

        test11.source(STR, XContentType.JSON);

        client.indices().create(test11, RequestOptions.DEFAULT);
    }

    /**
     *删除索引库
     * @throws IOException
     */
    @Test
    void test2() throws IOException {
        DeleteIndexRequest test11 = new DeleteIndexRequest("test11");

        client.indices().delete(test11,RequestOptions.DEFAULT);
    }

    /**
     * 查询索引库
     */
    @Test
    void test3() throws IOException {
        GetIndexRequest test11 = new GetIndexRequest("test11");

        System.out.println(client.indices().exists(test11,RequestOptions.DEFAULT)+"---------------------------------");

    }


    /**
     * 添加数据到索引库
     *
     */
    @Test
    void test4() throws IOException {
        IndexRequest test11 = new IndexRequest("test11").id("42");

        pojo pao = new pojo();
        pao.setInfo("测试一下es的高亮显示czy@163.com");
        pao.setEmail("czy@163.com");
        pao.setSex("女");
        test11.source(JSON.toJSONString(pao),XContentType.JSON);
        client.index(test11,RequestOptions.DEFAULT);
    }

    /**
     * 批量添加数据到索引库
     *
     */
    @Test
    void test8() throws IOException {
        //创建bulk
        BulkRequest bulkRequest = new BulkRequest();
        //添加

        for(int i=1; i<8;i++){
            pojo pao = new pojo();
            pao.setInfo("今天"+i+"天玩了"+i+"游戏");
            pao.setEmail(i+"@qq.com");
            pao.setSex("女");
            bulkRequest.add(new IndexRequest("test11").id("1"+i).source(JSON.toJSONString(pao),XContentType.JSON));
        }
        client.bulk(bulkRequest,RequestOptions.DEFAULT);

    }

    /**
     * 从索引库查询数据
     */
    @Test
    void test5() throws IOException {
        GetRequest test11 = new GetRequest("test", "4");
        GetResponse documentFields = client.get(test11, RequestOptions.DEFAULT);
        String sourceAsString = documentFields.getSourceAsString();

        System.out.println(sourceAsString);

    }

    /**
     * 更新索引库里面的数据           局部修改，只修改指定字段
     */
    @Test
    void test6() throws IOException {
        UpdateRequest test11 = new UpdateRequest("test11", "2");
        test11.doc("info","今天吃了两碗饭","email","test@czy.com");
        client.update(test11,RequestOptions.DEFAULT);
    }
    /**
     * 删除索引库里的指定内容
     */
    @Test
    void test7() throws IOException {
        DeleteRequest test11 = new DeleteRequest("test11", "2");
        client.delete(test11, RequestOptions.DEFAULT);
    }

    /**
     * 查询所有的数据
     */
    @Test
    void test9() throws IOException {
        SearchRequest request = new SearchRequest("test");
        SearchSourceBuilder size = request.source().from(3).size(3);
        size.query(QueryBuilders.matchQuery("info","玩了"));
        /*高亮查询*/
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.preTags("<em>");
        highlightBuilder.postTags("</em>");
        highlightBuilder.field("info");
        highlightBuilder.requireFieldMatch(false);
        /*需要highlightBuilder，前面创建好*/
        size.highlighter(highlightBuilder);
        request.source(size);
        SearchResponse search = client.search(request, RequestOptions.DEFAULT);
        SearchHit[] hits = search.getHits().getHits();
        for (SearchHit hit : hits) {
            String sourceAsString = hit.getSourceAsString();
            Text[] emails = hit.getHighlightFields().get("info").getFragments();
            for (Text s:
                 emails) {
                System.out.println("-------------------------------->"+s);
            }
            pojo pojo = JSON.parseObject(sourceAsString, pojo.class);
            System.out.println(pojo.toString());
        }
    }





    @BeforeEach
    void setup(){
        this.client= new RestHighLevelClient(RestClient.builder(
           HttpHost.create("http://192.168.0.155:9200")
        ));
    }
    @AfterEach
    void tearDown() throws IOException {
        this.client.close();
    }
}
