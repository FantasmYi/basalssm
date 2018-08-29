
package com.Lynn.ssm.dao;

import com.mongodb.*;




import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * Created by FantasmYii on 2018/8/27
 */

@RunWith(SpringJUnit4ClassRunner.class)
//使注解引入多个配置文件
@ContextConfiguration("classpath:spring/spring-mongodb.xml")
public class MongoDBTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void test() {
        try {
            DBCollection mycol2 = mongoTemplate.getCollection("mycol2");
            DBCursor dbObjects = mycol2.find();
            Iterator<DBObject> iterator = dbObjects.iterator();
            while (iterator.hasNext()){
                System.out.println(iterator.next());
            }

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

}

