package com.jerry.dao.impl;

import com.jerry.dao.IUserDao;
import com.jerry.entity.User;
import org.springframework.stereotype.Repository;

/**
 * created by jerry on 2021-12-12
 */
@Repository
public class UserDaoImpl implements IUserDao {
    @Override
    public User select() {
        return null;
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
}
