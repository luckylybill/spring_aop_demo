package com.jerry.service;

import com.jerry.entity.User;

import java.util.List;

public interface IUserService {
    List<User> select();
    User selectById(Integer id);
    void add(User user) throws Exception;
    void update(User user) throws Exception;
    void delete(User user) throws Exception;
}
