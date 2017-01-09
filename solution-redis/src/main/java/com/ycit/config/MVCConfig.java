package com.ycit.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by xlch on 2017/1/8.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.ycit.controller"})
public class MVCConfig extends WebMvcConfigurerAdapter {
}
