package com.braisedpanda;

import com.braisedpanda.bean.User;
import com.braisedpanda.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JdbcApplicationTests {
    @Autowired
    UserMapper userMapper;
    @Autowired
    DataSource dataSource;

//    @Autowired
//    StringRedisTemplate stringRedisTemplate;
//
//    @Autowired
//    RedisTemplate redisTemplate;
//
//    @Autowired
//    RedisTemplate<Object, Object> myRedisTemplate;
//
//    @Autowired
//    JavaMailSenderImpl mailSender;
//    @Test
//    public void testRedis(){
//        User user = userMapper.getUserById(2);
//        myRedisTemplate.opsForValue().set("user",user);
//    }
//
//    @Test
//    public void testRedis2(){
//
//       Object user =  myRedisTemplate.opsForValue().get("user");
//       System.out.println(user);
//    }

    @Test
    public void contextLoads() throws SQLException {
        System.out.println("==============dataSource===============");
        System.out.println(dataSource.getClass());
        Connection connection = dataSource.getConnection();
        System.out.println("==============connection===============");
        System.out.println(connection);
        connection.close();
    }



}
