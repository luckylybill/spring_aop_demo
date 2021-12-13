package com.jerry.service.impl;

import com.jerry.dao.IUserDao;
import com.jerry.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * created by jerry on 2021-12-12
 */
@Service
public class UserServiceWithoutImpl {
    @Autowired
    IUserDao userDao;


    public User select() {
        return null;
    }

    public void add(User user) throws Exception {
        userDao.add(user);
    }

    public void update(User user) throws Exception {
        userDao.update(user);
    }

    public void delete(User user) throws Exception {
        userDao.delete(user);
    }
}
