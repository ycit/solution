package com.ycit.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by xlch on 2016/12/27.
 */
@Configuration
//@PropertySource({"classpath:db.properties"})
public class DataSourceConfig {

//    @Value("${db.username}")
//    String username;
//
//    @Value("${db.password}")
//    String password;
//
//    @Value("${db.url}")
//    String url;

//    @Bean(name = "dataSource")
//    public DataSource dataSource()throws SQLException {
//        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setUrl(url);
//        dataSource.setUsername(username);
//        dataSource.setPassword(password);
//        dataSource.setMaxActive(20);
//        dataSource.setMaxWait(2000);
//        dataSource.setFilters("stat,wall");
//        return dataSource;
//    }

    @Bean(name = "dataSource")
    public DataSource dataSource()throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/xlch?useSSL=false&serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        dataSource.setMaxActive(20);
        dataSource.setMaxWait(2000);
        dataSource.setFilters("stat,wall");
        return dataSource;
    }

    /**
     * JestClient 为 单例
     * @return
     */
    @Bean(name = "jestClient")
    public JestClient jestClient() {
        Gson gson =
                new GsonBuilder()
                        .setDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX")
                        .create();

        JestClientFactory factory = new JestClientFactory();
        factory.setHttpClientConfig(
                new HttpClientConfig
                        .Builder("http://172.16.60.249:9200")
                        .multiThreaded(true)
                        .gson(gson)
                        .build()
        );
        return factory.getObject();
    }

}
