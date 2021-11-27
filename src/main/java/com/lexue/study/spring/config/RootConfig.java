package com.lexue.study.spring.config;

import com.lexue.study.spring.bean.B;
import com.lexue.study.spring.aop.LogAspect;
import com.lexue.study.spring.aop.LogAspectV2;
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
    public LogAspect logAspect() {
        return new LogAspect();
    }

    @Bean
    public LogAspectV2 logAspectV2() {
        return new LogAspectV2();
    }

}
