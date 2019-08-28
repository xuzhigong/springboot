package com.example.impl;

import com.example.dao.UserDAO;
import com.example.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by xuzhigong on 2019/8/27.
 */
@Repository
public class UserDaoImpl implements UserDAO{

    @Autowired
    private JdbcTemplate jdbcTemplate;

//    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }


    @Override
    public int add(User user) {
        return jdbcTemplate.update("insert into user(username, password) values(?, ?)",
                user.getUsername(), user.getPassword());
    }

    @Override
    public int update(User user) {
        return jdbcTemplate.update("UPDATE user SET username=?, password=? WHERE id=?",
                user.getUsername(),user.getPassword(),user.getId());
    }

    @Override
    public int delete(int id) {
        return jdbcTemplate.update("DELETE from TABLE user WHERE id=?",id);
    }

    @Override
    public User findAccountById(int id) {
        List<User> list = jdbcTemplate.query("select * from user where id = ?", new Object[]{id}, new BeanPropertyRowMapper(User.class));
        if(list!=null && list.size()>0){
            User user = list.get(0);
            return user;
        }else{
            return null;
        }

    }

    @Override
    public List<User> findAccountList() {
        List<User> list = jdbcTemplate.query("select * from user ", new Object[]{}, new BeanPropertyRowMapper(User.class));
        if(list!=null && list.size()>0){
            User user = list.get(0);
            return list;
        }else{
            return null;
        }
    }




}
