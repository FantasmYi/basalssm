
package com.Lynn.ssm.dao;

import com.mongodb.*;



import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.*;
import org.bson.Document;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by FantasmYii on 2018/8/27
 */

//@RunWith(SpringJUnit4ClassRunner.class)
//使注解引入多个配置文件
//@ContextConfiguration("classpath:spring/spring-mongodb.xml")
public class MongoDBTest {

  //  @Autowired
 //   private MongoTemplate mongoTemplate;

    @Test
    public void test() {
        try {
            // To connect to mongodb server
            MongoClient mongoClient = new MongoClient("192.168.200.131", 27017);
            // Now connect to your databases
            MongoDatabase database = mongoClient.getDatabase("mycol");
            System.out.println("Collection created successfully");
            MongoCollection<Document> mycol = database.getCollection("mycol2");
            System.out.println("集合mycol2选择成功");

            FindIterable<Document> findIterable = mycol.find();
            MongoCursor<Document> mongoCursor = findIterable.iterator();
            while(mongoCursor.hasNext()) {
                System.out.println(mongoCursor.next());
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }



}

