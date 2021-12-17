package com.jerry.dao.impl;

import com.jerry.dao.IBalanceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

/**
 * created by jerry on 2021-12-16
 */
@Repository
public class BalanceDaoImpl implements IBalanceDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public void change(Integer id, Integer balance) {
       jdbcTemplate.update("update t_user set balance=balance+? where id=?",balance,id);
    }
}
