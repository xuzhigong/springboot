package com.example.web;

import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by xuzhigong on 2019/8/27.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/hello")
     public List<User> getStuList(){
                 return userService.findAccountList();
           }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<User> getAccounts(){
        return userService.findAccountList();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public  User getAccountById(@PathVariable("id") int id){
        return userService.findAccountById(id);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public  String updateUser(@PathVariable("id")int id , @RequestParam(value = "username",required = true)String username,
                                 @RequestParam(value = "password" ,required = true)String password){
        User user=new User();
        user.setPassword(password);
        user.setUsername(username);
        user.setId(id);
        int t=userService.update(user);
        if(t==1){
            return user.toString();
        }else {
            return "fail";
        }
    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    public  String postUser( @RequestParam(value = "username")String username,
                                @RequestParam(value = "password" )String password){
        User user=new User();
        user.setPassword(password);
        user.setUsername(username);
        int t= userService.add(user);
        if(t==1){
            return user.toString();
        }else {
            return "fail";
        }

    }

}
