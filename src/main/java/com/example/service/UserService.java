package com.example.service;

import com.example.entity.User;

import java.util.List;

/**
 * Created by xuzhigong on 2019/8/27.
 */
public interface UserService {
    int add(User user);

    int update(User user);

    int delete(int id);

    User findAccountById(int id);

    List<User> findAccountList();
}
