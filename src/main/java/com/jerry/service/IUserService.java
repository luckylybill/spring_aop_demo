package com.jerry.service;

import com.jerry.entity.User;

public interface IUserService {
    User select();
    void add(User user) throws Exception;
    void update(User user) throws Exception;
    void delete(User user) throws Exception;
}
