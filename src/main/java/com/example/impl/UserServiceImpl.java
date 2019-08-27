package com.example.impl;

import com.example.dao.UserDAO;
import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xuzhigong on 2019/8/27.
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserDAO userDAO;
    @Override
    public int add(User user) {
        return userDAO.add(user);
    }

    @Override
    public int update(User user) {
        return userDAO.update(user);
    }

    @Override
    public int delete(int id) {
        return userDAO.delete(id);
    }

    @Override
    public User findAccountById(int id) {
        return userDAO.findAccountById(id);
    }

    @Override
    public List<User> findAccountList() {
        return userDAO.findAccountList();
    }
}
