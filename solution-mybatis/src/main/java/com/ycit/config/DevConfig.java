package com.ycit.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by xlch on 2017/3/31.
 */
@Configuration
public class DevConfig {

    private static final Logger logger = LoggerFactory.getLogger(DevConfig.class);

    @Bean
    public DataSource dataSource() throws SQLException {
        logger.debug("create bean  dataSource  ..............");
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        dataSource.setUrl("jdbc:mysql://localhost:3306/xlch?useSSL=false&serverTimezone=UTC");
        dataSource.setMaxActive(20);
        dataSource.setMaxWait(2000);
        dataSource.setFilters("stat,wall");
        return dataSource;
    }

}
