package com.ycit.controller.api;

import com.ycit.api.ApiResponse;
import com.ycit.beans.User;
import com.ycit.controller.BaseController;
import com.ycit.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by xlch on 2017/1/5.
 */
@RestController(value = "UserApiController")
@RequestMapping("/api")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public ApiResponse<User> home() {
        Subject user = SecurityUtils.getSubject();
        List<User> users = userService.find();
        return success(users.size(),users);
    }

//    @RequestMapping(value = "/users", method = RequestMethod.POST)
//    public ApiResponse<User> insert(User user) {
//        User result = userService.insertR(user);
//        return success(1, ImmutableList.of(result));
//    }

}
