package com.ycit.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by xlch on 2017/2/25.
 */
@Configuration
@ComponentScan(basePackages = {"com.ycit.dao.impl","com.ycit.service.impl"})
@Import({DevConfig.class})
public class AppConfig {





}
