package com.example;

import com.example.dao.RedisDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo1ApplicationTests {


	@Test
	public void contextLoads() {
	}

//	public static Logger logger= LoggerFactory.getLogger(Demo1ApplicationTests.class);
//	@Autowired
//	RedisDAO redisDao;
//	@Test
//	public void testRedis(){
//		redisDao.setKey("name","xuzhigong");
//		redisDao.setKey("age","23");
//		System.out.println("-------分界线------------");
//		System.out.println(redisDao.getValue("name"));
//		logger.info(redisDao.getValue("name"));
//		logger.info(redisDao.getValue("age"));
//	}

}
