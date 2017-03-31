package com.ycit.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by xlch on 2017/2/26.
 */
@Configuration
@Import({DevConfig.class})
@EnableTransactionManagement(proxyTargetClass = true)
public class DaoConfig {

    private static final Logger logger = LoggerFactory.getLogger(DaoConfig.class);

    @Autowired
    private DataSource dataSource;

    @Bean(name = "sessionFactory")
    public LocalSessionFactoryBean sessionFactoryBean() {
        logger.debug("create bean LocalSessionFactoryBean   .....");
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        String [] packages = new String[]{"com.ycit.bean.entity"};
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect","org.hibernate.dialect.MySQLInnoDBDialect");
        properties.setProperty("hibernate.show_sql","true");
        properties.setProperty("hibernate.format_sql","true");
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setPackagesToScan(packages);
        sessionFactoryBean.setHibernateProperties(properties);
        return sessionFactoryBean;
    }

    @Bean(name = "transactionManager")
    public HibernateTransactionManager transactionManager() {
        logger.debug("create bean HibernateTransactionManager ...............");
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactoryBean().getObject());
        return transactionManager;
    }


}
