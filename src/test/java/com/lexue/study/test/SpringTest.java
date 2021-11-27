package com.lexue.study.test;

import com.alibaba.fastjson.JSON;
import com.lexue.study.spring.bean.B;
import com.lexue.study.spring.config.MybatisPlusConfig;
import com.lexue.study.spring.config.RootConfig;
import com.lexue.study.spring.config.TxConfig;
import com.lexue.study.spring.dao.entity.UserEntity;
import com.lexue.study.spring.service.IUserService;
import com.lexue.study.spring.service.impl.UserServiceImpl;
import lombok.*;
import org.junit.Test;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class SpringTest {

    @Test
    public void test1() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(RootConfig.class);
        B bean = applicationContext.getBean(B.class);
        int div = bean.div(1, 1);
        System.out.println(div);
        applicationContext.getApplicationName();
    }

    @Test
    public void test2() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(TxConfig.class);
//        UserServiceImpl userService = applicationContext.getBean(UserServiceImpl.class);
//        userService.insertUser();
        applicationContext.publishEvent(new ApplicationEvent("我发布的事件") {
        });
    }


}
