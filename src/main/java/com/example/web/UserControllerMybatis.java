package com.example.web;

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

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<User> getAccounts() {
        return userServiceMybatis.findAccountList();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getAccountById(@PathVariable("id") int id) {
        return userServiceMybatis.findAccount(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String updateAccount(@PathVariable("id") int id, @RequestParam(value = "username", required = true) String username,
                                @RequestParam(value = "password", required = true) String password) {
        int t= userServiceMybatis.update(username,password,id);
        if(t==1) {
            return "success";
        }else {
            return "fail";
        }

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable(value = "id")int id) {
        int t= userServiceMybatis.delete(id);
        if(t==1) {
            return "success";
        }else {
            return "fail";
        }

    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String postAccount(@RequestParam(value = "username") String username,
                              @RequestParam(value = "password") String password) {

        int t= userServiceMybatis.add(username,password);
        if(t==1) {
            return "success";
        }else {
            return "fail";
        }

    }

}
