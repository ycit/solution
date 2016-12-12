package com.ycit.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xlch on 2016/12/4.
 */
@RestController
@RequestMapping("/api")
public class UserController extends BaseController {

    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public String home() {
        return "home";
    }
}
