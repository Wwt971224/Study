package com.lexue.study.spring.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mysql.cj.jdbc.JdbcConnection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Import(MyImportBeanDefinitionRegistrar.class)
@EnableTransactionManagement
@ComponentScan("com.lexue.study.spring")
@Configuration
public class TxConfig {

    @Bean
    public DataSource dataSource() throws Exception{
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://39.97.233.123:3306/wwt?autoReconnect=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&serverTimezone=Asia/Shanghai");
        comboPooledDataSource.setUser("root");
        comboPooledDataSource.setPassword("root");
        return comboPooledDataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() throws Exception {
        return new JdbcTemplate(dataSource());
    }

    @Bean
    public PlatformTransactionManager transactionManager() throws Exception {
        return new DataSourceTransactionManager(dataSource());
    }


}
