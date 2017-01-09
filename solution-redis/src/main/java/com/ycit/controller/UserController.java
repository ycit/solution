package com.ycit.controller;

import com.ycit.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xlch on 2017/1/8.
 */
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private RedisService redisService;

    @RequestMapping("/test")
    public void test() {
        redisService.insert();
    }

}
