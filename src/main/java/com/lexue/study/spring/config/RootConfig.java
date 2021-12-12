package com.lexue.study.spring.config;

import com.lexue.study.spring.bean.B;
import com.lexue.study.spring.aop.LogAspect;
import com.lexue.study.spring.aop.LogAspectV2;
import com.lexue.study.spring.bean.C;
import com.lexue.study.spring.bean.D;
import com.lexue.study.spring.listener.MyListener;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.*;

@EnableAspectJAutoProxy()
//@ComponentScan("com.lexue.study.spring")
//@Configuration
public class RootConfig {

    @Bean
    public B b() {
        return new B();
    }

    @Bean
    public C c() {
        return new C();
    }

    @Bean
    public D d() {
        return new D();
    }

    @Bean
    public ApplicationListener<ApplicationEvent> applicationListener() {
        return new MyListener();
    }

    @Bean
    public LogAspect logAspect() {
        return new LogAspect();
    }

    @Bean
    public LogAspectV2 logAspectV2() {
        return new LogAspectV2();
    }

}
