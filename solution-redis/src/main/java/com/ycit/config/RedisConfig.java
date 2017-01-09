package com.ycit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by xlch on 2017/1/8.
 */
@Configuration
public class RedisConfig {

    @Bean
    public Jedis jedis() {
        JedisPool pool = new JedisPool(new JedisPoolConfig(), "127.0.0.1");
        return  pool.getResource();
    }

}
