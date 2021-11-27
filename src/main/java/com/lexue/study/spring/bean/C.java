package com.lexue.study.spring.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class C {

    @Resource
    private D d;

}
