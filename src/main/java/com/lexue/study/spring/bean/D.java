package com.lexue.study.spring.bean;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class D {

    @Resource
    private C c;

    public void say() {

    }

}
