/*
package com.example.demo.jimmer;




import com.example.demo.jimmer.Entity.userTestBook;

import com.example.demo.jimmer.Entity.userTestBookDraft;
import com.example.demo.jimmer.Entity.userTestCzy;
import com.example.demo.jimmer.Entity.userTestCzyDraft;
import com.example.demo.jimmer.Entity.userTestCzyFetcher;
import com.example.demo.jimmer.Entity.userTestCzyTable;
import org.babyfish.jimmer.sql.JSqlClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


*/
/**
 * @author czy
 * @summary demo
 * @date 2023-12-27 18:06
 *//*

@RestController
@RequestMapping("xfs")
public class testJimmer {
    @Autowired
    JSqlClient sqlClient;


    @GetMapping("/getBankInfo")
    public void getBankInfo() {
        userTestCzy czyy = userTestCzyDraft.$.produce(draft -> {
            draft.setAge(12);
            draft.setName("易伙伴科技").setSex("1288").setAddRess("珠海");
        });

        userTestBook book = userTestBookDraft.$.produce(draft -> {
            draft.setBookName("java基础");
            draft.setCzyId(sqlClient.insert(czyy).getModifiedEntity().id());
        });
        sqlClient.insert(book);
    }
    @GetMapping("/getBankInfo2")
    public String getBankInfo2() {
        userTestCzyTable czyy= userTestCzyTable.$;

        List<userTestCzy> execute = sqlClient.createQuery(czyy)
                .where(czyy.id().eq(5))
                .select(czyy.fetch(userTestCzyFetcher.$.age().name()))
                .execute();
        System.out.println("----------打印-----------");
        execute.forEach(System.out::println);
        return execute.toString();
    }
}
*/
