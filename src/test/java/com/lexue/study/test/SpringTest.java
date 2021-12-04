package com.lexue.study.test;

import com.alibaba.fastjson.JSON;
import com.lexue.study.spring.bean.B;
import com.lexue.study.spring.bean.E;
import com.lexue.study.spring.bean.EFactoryBean;
import com.lexue.study.spring.config.RootConfig;
import com.lexue.study.spring.config.TxConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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
    public void test2() throws Exception {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(TxConfig.class);
//        UserServiceImpl userService = applicationContext.getBean(UserServiceImpl.class);
//        userService.insertUser();
//        applicationContext.publishEvent(new ApplicationEvent("我发布的事件") {
//        });
        E bean = applicationContext.getBean(E.class);
        System.out.println(bean);
        E bean1 = applicationContext.getBean(E.class);
        System.out.println(bean1);

        System.out.println(bean==bean1);
    }


}
