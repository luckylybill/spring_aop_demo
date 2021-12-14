package com.jerry.service.impl;

import com.jerry.dao.IUserDao;
import com.jerry.entity.User;
import com.jerry.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * created by jerry on 2021-12-12
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    IUserDao userDao;

    @Override
    public List<User> select() {
        return null;
    }

    @Override
    public void add(User user) throws Exception {
        userDao.add(user);
    }

    @Override
    public void update(User user) throws Exception {
        userDao.update(user);
    }

    @Override
    public void delete(User user) throws Exception {
        userDao.delete(user);
    }
}
