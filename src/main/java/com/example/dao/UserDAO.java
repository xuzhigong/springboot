package com.example.dao;

import com.example.entity.User;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

/**
 * Created by xuzhigong on 2019/8/27.
 */
@Mapper
public interface UserDAO {
    int add(User user);

    int update(User user);

    int delete(int id);

    User findAccountById(int id);

    List<User> findAccountList();


}
