package com.example.service;

import com.example.dao.UserMapper;
import com.example.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xuzhigong on 2019/8/27.
 */
@Service
public class UserServiceMybatis {
    @Autowired
    private UserMapper userMapper;

    public int add(String username, String password) {
        return userMapper.add(username, password);
    }
    public int update(String username, String password, int id) {
        return userMapper.update(username, password, id);
    }
    public int delete(int id) {
        return userMapper.delete(id);
    }
    public User findAccount(int id) {
        return userMapper.findAccount(id);
    }
    public List<User> findAccountList() {
        return userMapper.findAccountList();
    }


}
