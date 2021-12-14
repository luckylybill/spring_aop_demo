package com.jerry.service;

import com.alibaba.druid.pool.DruidDataSource;
import com.jerry.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserServiceImplTest {
    ClassPathXmlApplicationContext ioc;
    @Before
    public void before(){
        ioc=new ClassPathXmlApplicationContext("spring.xml");
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
        Long aLong = jdbcTemplate.queryForObject("select count(*) from t_user",Long.class);
        System.out.println(aLong);
    }

    @Test
    public void test03()
    {
        JdbcTemplate jdbcTemplate = ioc.getBean(JdbcTemplate.class);
        System.out.println(jdbcTemplate);
        User user = jdbcTemplate.queryForObject("select * from t_user where id =1 ",new BeanPropertyRowMapper<>(User.class));
        System.out.println(user);
    }
    @Test
    public void test04()
    {
        JdbcTemplate jdbcTemplate = ioc.getBean(JdbcTemplate.class);
        System.out.println(jdbcTemplate);
        User user = jdbcTemplate.queryForObject("select * from t_user where id =1 ",(resultSet,i)->{
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
        List<User> user = jdbcTemplate.query("select * from t_user ",(resultSet, i)->{
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
    public void test06()
    {
        JdbcTemplate jdbcTemplate = ioc.getBean(JdbcTemplate.class);
        System.out.println(jdbcTemplate);
        Integer result = jdbcTemplate.update("insert into t_user(realName,cardNo,balance) values(?,?,?)","andy","1000009",200);
        System.out.println(result);
    }

    @Test
    public void test07()
    {
        JdbcTemplate jdbcTemplate = ioc.getBean(JdbcTemplate.class);
        System.out.println(jdbcTemplate);
        Integer result = jdbcTemplate.update("update t_user set balance=balance+100 where id=?",4);
        System.out.println(result);
    }

    @Test
    public void test08()
    {
        JdbcTemplate jdbcTemplate = ioc.getBean(JdbcTemplate.class);
        System.out.println(jdbcTemplate);
        Integer result = jdbcTemplate.update("delete from t_user where id=?",4);
        System.out.println(result);
    }

    @Test
    public void test09()
    {
        NamedParameterJdbcTemplate jdbcTemplate = ioc.getBean(NamedParameterJdbcTemplate.class);
        System.out.println(jdbcTemplate);
        Map<String,Object> map = new HashMap<>();
        map.put("id",5);
        Integer result = jdbcTemplate.update("delete from t_user where id=:id",map);
        System.out.println(result);
    }
}
