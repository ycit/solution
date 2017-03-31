package com.ycit.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by xlch on 2017/2/26.
 */
@Configuration
@Profile("pro")
public class ProductConfig {

    @Bean
    public DataSource dataSource()throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUsername("analysis");
        dataSource.setPassword("ana");
        dataSource.setUrl("jdbc:oracle:thin:@172.16.60.104:1521:orcl");
        dataSource.setMaxActive(20);
        dataSource.setMaxWait(2000);
        dataSource.setFilters("stat,wall");
        return dataSource;
    }

}
