package com.projectNanuram.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;


import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@PropertySource("classpath:datasource.properties")
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.projectNanuram"})
public class AppContext {

    @Autowired
    private Environment environment;


    @Bean
    public LocalSessionFactoryBean factoryBean(){
        LocalSessionFactoryBean sessionBean = new LocalSessionFactoryBean();
        sessionBean.setDataSource(dataSource());
        sessionBean.setPackagesToScan("com.projectNanuram.entity");
        sessionBean.setHibernateProperties(hibernateProperties());


        return sessionBean;
    }



    @Bean
    public DataSource dataSource(){

        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.DriverClassName"));
        dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
        dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
        dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));

        return dataSource;
    }

    private Properties hibernateProperties() {

        Properties properties = new Properties();
        properties.put("hibernate.dialect" , environment.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql" , environment.getRequiredProperty("hibernate.show_sql"));
        properties.put("hibernate.format_sql" , environment.getRequiredProperty("hibernate.format_sql"));
        properties.put("hibernate.hbm2ddl.auto" , environment.getRequiredProperty("hibernate.hbm2ddl.auto"));

        //c3p0 properties

        properties.put("C3P0_MIN_SIZE" , environment.getRequiredProperty("C3P0_MIN_SIZE"));
        properties.put("C3P0_MAX_SIZE" , environment.getRequiredProperty("C3P0_MAX_SIZE"));
        properties.put("C3P0_ACQUIRE_INCREMENT" , environment.getRequiredProperty("C3P0_ACQUIRE_INCREMENT"));
        properties.put("C3P0_TIMEOUT" , environment.getRequiredProperty("C3P0_TIMEOUT"));
        properties.put("C3P0_MAX_STATEMENTS" , environment.getRequiredProperty("C3P0_MAX_STATEMENTS"));
        properties.put("C3P0_INITIAL_POOL_SIZE" , environment.getRequiredProperty("C3P0_INITIAL_POOL_SIZE"));

        return properties;
    }


    @Bean
    public HibernateTransactionManager getTransactionManager(){

        HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
        hibernateTransactionManager.setSessionFactory(factoryBean().getObject());
        return hibernateTransactionManager;

    }




}
