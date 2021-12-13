package com.jerry.service;

import com.alibaba.druid.pool.DruidDataSource;
import com.jerry.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserServiceImplTest {
    ClassPathXmlApplicationContext ioc;
    @Before
    public void before(){
        ioc=new ClassPathXmlApplicationContext("spring_ioc.xml");
    }
    @Test
    public void test01()
    {
        DruidDataSource bean = ioc.getBean(DruidDataSource.class);
        System.out.println(bean);
    }
    @Test
    public void test02()
    {
        JdbcTemplate jdbcTemplate = ioc.getBean(JdbcTemplate.class);
        System.out.println(jdbcTemplate);
        Long aLong = jdbcTemplate.queryForObject("select count(*) from user",Long.class);
        System.out.println(aLong);
    }

    @Test
    public void test03()
    {
        JdbcTemplate jdbcTemplate = ioc.getBean(JdbcTemplate.class);
        System.out.println(jdbcTemplate);
        User user = jdbcTemplate.queryForObject("select * from user where id =1 ",new BeanPropertyRowMapper<>(User.class));
        System.out.println(user);
    }
    @Test
    public void test04()
    {
        JdbcTemplate jdbcTemplate = ioc.getBean(JdbcTemplate.class);
        System.out.println(jdbcTemplate);
        User user = jdbcTemplate.queryForObject("select * from user where id =1 ",(resultSet,i)->{
            User o=new User();
            o.setId(resultSet.getInt("id"));
            o.setRealName(resultSet.getString("realName"));
            o.setCardNo(resultSet.getString("cardNo"));
            o.setBalance(resultSet.getInt("balance"));
            return o;
        });
        System.out.println(user);
    }
    @Test
    public void test05()
    {
        JdbcTemplate jdbcTemplate = ioc.getBean(JdbcTemplate.class);
        System.out.println(jdbcTemplate);
        List<User> user = jdbcTemplate.query("select * from user ",(resultSet, i)->{
            User o=new User();
            o.setId(resultSet.getInt("id"));
            o.setRealName(resultSet.getString("realName"));
            o.setCardNo(resultSet.getString("cardNo"));
            o.setBalance(resultSet.getInt("balance"));
            return o;
        });
        System.out.println(user);
    }
}
