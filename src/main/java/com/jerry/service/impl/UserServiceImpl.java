package com.jerry.service.impl;

import com.jerry.dao.IUserDao;
import com.jerry.entity.User;
import com.jerry.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * created by jerry on 2021-12-12
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    IUserDao userDao;
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<User> select() {
        return userDao.select();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public User selectById(Integer id) {
        return userDao.selectById(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void add(User user) throws Exception {
        userDao.add(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void update(User user) throws Exception {
        userDao.update(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(User user) throws Exception {
        userDao.delete(user);
    }
}
