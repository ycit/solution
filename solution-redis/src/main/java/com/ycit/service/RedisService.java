package com.ycit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

/**
 * Created by xlch on 2017/1/8.
 */
@Service
public class RedisService {

    @Autowired
    private Jedis jedis;

    public void insert() {
        jedis.set("email", "xlch@163.com");
        String email = jedis.get("email");
        System.out.println("email===" + email);
    }

}
