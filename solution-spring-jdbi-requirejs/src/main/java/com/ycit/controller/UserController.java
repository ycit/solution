package com.ycit.controller;

import com.ycit.api.ApiResponse;
import com.ycit.beans.User;
import com.ycit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by xlch on 2016/12/4.
 */
@RestController
@RequestMapping("/api")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public ApiResponse<User> home() {
        List<User> users = userService.findName();
        return success(users.size(),users);
    }
}
