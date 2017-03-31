package com.ycit.config;

import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.IDBI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.sql.DataSource;

/**
 * Created by xlch on 2016/12/1.
 */
@Configuration
@ComponentScan(basePackages = {"com.ycit.service"})
@Import(DataSourceConfig.class)
@EnableScheduling
@EnableTransactionManagement(proxyTargetClass = true)
@PropertySource({"classpath:params.properties"})
public class AppConfig {

    private String name;

    @Value("${weChatChannelUrl}")
    public void setName(String name) {
        System.out.println(name);
        this.name = name;
    }

    @Autowired
    private DataSource dataSource;

    @Bean
    public TransactionAwareDataSourceProxy dataSourceProxy() {
        TransactionAwareDataSourceProxy dataSourceProxy = new TransactionAwareDataSourceProxy(dataSource);
        return dataSourceProxy;
    }

    @Bean
    public DataSourceTransactionManager transactionManager() {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSourceProxy());
        return transactionManager;
    }

    @Bean
    public IDBI dbi() {
        IDBI idbi = new DBI(dataSourceProxy());
        return idbi;
    }


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

//    @Bean(name = "dbi")
//    public IDBI dbi() {
//        IDBI dbi = new DBI(dataSource);
//        return dbi;
//    }

//    @Bean
//    public ObjectMapper objectMapper() {
//        ObjectMapper objMapper = new ObjectMapper();
//        objMapper.enable(SerializationFeature.INDENT_OUTPUT);
//        return objMapper;
//    }
//
//    @Bean
//    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
//        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
//        mappingJackson2HttpMessageConverter.setObjectMapper(objectMapper());
//        return mappingJackson2HttpMessageConverter;
//    }

}
