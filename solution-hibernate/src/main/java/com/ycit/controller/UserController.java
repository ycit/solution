package com.ycit.controller;

import com.ycit.bean.entity.User;
import com.ycit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by xlch on 2017/2/27.
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("/user/list")
    public List<User> find() {
        List<User> users = userService.find();
        return users;
    }

}
