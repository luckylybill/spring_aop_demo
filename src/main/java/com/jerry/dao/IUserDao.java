package com.jerry.dao;

import com.jerry.entity.User;

import java.util.List;

public interface IUserDao {
    List<User> select();
    void add(User user) throws Exception;
    void update(User user) throws Exception;
    void delete(User user) throws Exception;
}
