package com.example.dao;

import com.example.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by xuzhigong on 2019/8/27.
 */
@Mapper
public interface UserMapper {
    @Insert("insert into user(name, password) values(#{name}, #{password})")
    int add(@Param("username") String username, @Param("password") String password);

    @Update("update user set username = #{username}, password = #{password} where id = #{id}")
    int update(@Param("username") String username, @Param("password") String password, @Param("id") int  id);

    @Delete("delete from user where id = #{id}")
    int delete(int id);

    @Select("select id, username as username, password as password from user where id = #{id}")
    User findAccount(@Param("id") int id);

    @Select("select id, username as username, password as password from user")
    List<User> findAccountList();

}
