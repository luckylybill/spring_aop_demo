package com.jerry.service;

import com.jerry.entity.User;
import com.jerry.service.impl.UserServiceWithoutImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * created by jerry on 2021-12-12
 */
public class UserServiceImplTest {
    ClassPathXmlApplicationContext ioc;
    JdbcTemplate jdbcTemplate;

    @Before
    public void before()
    {
        ioc=new ClassPathXmlApplicationContext("classpath:/spring.xml");
        jdbcTemplate = ioc.getBean(JdbcTemplate.class);
    }
    @Test
    public void test01(){
        IUserService userService=ioc.getBean(IUserService.class);
        User user=new User();
        user.setName("张三");
        user.setAge(22);
        try {
            userService.add(user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void test02(){
        User user1 = jdbcTemplate.queryForObject("select id,name,age from t_user where id=1;", (resultSet,i) -> {
            User user = new User();
            user.setID(resultSet.getInt("id"));
            user.setName(resultSet.getString("name"));
            user.setAge(resultSet.getInt("age"));
            return user;
        });
        System.out.println(user1);
    }
}
