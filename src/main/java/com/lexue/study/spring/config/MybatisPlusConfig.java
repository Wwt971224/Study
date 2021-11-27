package com.lexue.study.spring.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
//@EnableTransactionManagement
//@MapperScan(basePackages = "com.lexue.study.spring.dao.repository")
//@Configuration
public class MybatisPlusConfig {

}
