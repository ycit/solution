package com.ycit.config;

import com.ycit.service.UserService;
import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.IDBI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.sql.DataSource;

/**
 * Created by xlch on 2016/12/1.
 */
@Configuration
@ComponentScan(basePackages = {"com.ycit.service"})
public class AppConfig {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserService userService;

    /**
     * spring 处理文件上传
     * @return
     */
    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(50000000);
        multipartResolver.setDefaultEncoding("UTF-8");
        return multipartResolver;
    }

    @Bean(name = "dbi")
    public IDBI dbi() {
        IDBI dbi = new DBI(dataSource);
        return dbi;
    }

}
