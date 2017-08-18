package com.ycit.controller;

import com.ycit.beans.User;
import com.ycit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by xlch on 2016/12/4.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public String home(Model model, HttpServletRequest request, HttpServletResponse response) {
        Cookie [] cookie = request.getCookies();
        HttpSession session = request.getSession();
        session.invalidate();
        String result = request.getHeader("Cookie");
        response.addCookie(new Cookie("xlch", "28"));
        List<User> users = userService.find();
        model.addAttribute("users",users);
        return "home";
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public void insert(User user) {
        userService.insert(user);
    }

    @RequestMapping(value = "/users", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    public void update(@RequestBody User user, HttpServletRequest request, HttpServletResponse response) {
        System.out.println(user.getName());
        System.out.println(user.getEmail());
    }


}
