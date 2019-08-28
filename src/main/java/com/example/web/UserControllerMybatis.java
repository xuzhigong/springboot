package com.example.web;

import com.example.dao.RedisDAO;
import com.example.entity.User;
import com.example.service.UserServiceMybatis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by xuzhigong on 2019/8/27.
 */
@RestController
@RequestMapping("/account")
public class UserControllerMybatis {
    @Autowired
    UserServiceMybatis userServiceMybatis;

    //列表全部
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<User> getAccounts() {
        return userServiceMybatis.findAccountList();
    }

    //单例查询
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getAccountById(@PathVariable("id") int id) {
        return userServiceMybatis.findAccount(id);
    }

    //更新
    @RequestMapping(value = "/1/{id}", method = RequestMethod.GET)
    public String updateAccount(@PathVariable("id") int id, @RequestParam(value = "username", required = true) String username,
                                @RequestParam(value = "password", required = true) String password) {
        int t= userServiceMybatis.update(username,password,id);
        if(t==1) {
            return "success";
        }else {
            return "fail";
        }

    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable(value = "id")int id) {
        int t= userServiceMybatis.delete(id);
        if(t==1) {
            return "success";
        }else {
            return "fail";
        }

    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String postAccount(@RequestParam(value = "username") String username,
                              @RequestParam(value = "password") String password) {

        int t= userServiceMybatis.add(username,password);
        if(t==1) {
            return "success";
        }else {
            return "fail";
        }

    }

    @Autowired
    RedisDAO redisDao;
    @RequestMapping(value="/redis")
    public String testRedis(){
        redisDao.setKey("name","xuzhigong");
        redisDao.setKey("age","23");
        System.out.println("-------分界线o0------------");
        System.out.println(redisDao.getValue("name"));
        return "redis test: "+redisDao.getValue("name");
    }

}
