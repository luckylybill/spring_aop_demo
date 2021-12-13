package com.jerry.dao;

import com.jerry.entity.User;

public interface IUserDao {
    User select();
    void add(User user) throws Exception;
    void update(User user) throws Exception;
    void delete(User user) throws Exception;
}
