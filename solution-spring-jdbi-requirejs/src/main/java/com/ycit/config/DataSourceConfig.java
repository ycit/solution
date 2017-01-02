package com.ycit.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by xlch on 2016/12/27.
 */
@Configuration
@PropertySource({"classpath:db.properties"})
public class DataSourceConfig {

    @Value("${db.username}")
    String username;

    @Value("${db.password}")
    String password;

    @Value("${db.url}")
    String url;

    @Bean(name = "dataSource")
    public DataSource dataSource()throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setMaxActive(20);
        dataSource.setMaxWait(2000);
        dataSource.setFilters("stat,wall");
        return dataSource;
    }

//    @Bean
//    public DataSource dataSource() throws SQLException {
//        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setUrl("jdbc:oracle:thin:@10.15.100.104:1521:orcl");
//        dataSource.setUsername("perp");
//        dataSource.setPassword("perp");
//
//        dataSource.setMaxActive(20);
//        dataSource.setMaxWait(2000);
//        dataSource.setFilters("stat,wall");
//        return dataSource;
//    }

}
