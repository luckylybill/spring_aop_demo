package com.jerry.dao.impl;

import com.jerry.dao.IUserDao;
import com.jerry.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.jws.soap.SOAPBinding;
import javax.sql.DataSource;
import java.util.List;

/**
 * created by jerry on 2021-12-12
 */
@Repository
public class UserDaoImpl implements IUserDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public List<User> select() {
        return jdbcTemplate.query("select * from t_user", new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public void add(User user) throws Exception {
        if (user == null)
            throw new Exception("用户不能为空");
        System.out.println("添加用户");
    }

    @Override
    public void update(User user) throws Exception {
        if (user == null)
            throw new Exception("用户不能为空");
        System.out.println("修改用户");
    }

    @Override
    public void delete(User user) throws Exception {
        if (user == null)
            throw new Exception("用户不能为空");
        System.out.println("删除用户");
    }

    @Override
    public User selectById(Integer id) {
        return jdbcTemplate.queryForObject("select * from t_user where id=?", (resultSet,i)->{
            User user=new User();
            user.setId(resultSet.getInt("Id"));
            user.setRealName(resultSet.getString("realName"));
            user.setCardNo(resultSet.getString("cardNo"));
            user.setBalance(resultSet.getInt("balance"));
            return user;
        },id);
    }
}
