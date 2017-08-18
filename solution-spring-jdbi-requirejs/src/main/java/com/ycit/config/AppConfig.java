package com.ycit.config;

import com.ycit.security.MyRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.IDBI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.sql.DataSource;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

    @Bean
    public ShiroFilterFactoryBean shiroFilter()throws IOException {
        Resource resource = new ClassPathResource("auth.properties");
        String authConfig = FileCopyUtils.copyToString(new FileReader(resource.getFile()));
        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
        shiroFilter.setSecurityManager(securityManager());
        shiroFilter.setFilterChainDefinitions(authConfig);
        return shiroFilter;
    }

    @Bean
    public DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        List<Realm> realms = new ArrayList<>();
        realms.add(myRealm());
        securityManager.setRealms(realms);
        return securityManager;
    }

    public Realm myRealm() {
        MyRealm realm = new MyRealm();
        return realm;
    }

}
