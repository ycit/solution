package com.ycit.controller;

import com.ycit.beans.User;
import com.ycit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by xlch on 2016/12/4.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public String home(Model model) {
        List<User> users = userService.find();
        model.addAttribute("users",users);
        return "home";
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public void insert(User user) {
        userService.insert(user);
    }


}
