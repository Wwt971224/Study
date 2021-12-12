package com.lexue.study.spring.bean;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class C {

    @Resource
    private D d;

    public void say() {

    }

    public D getD() {
        return d;
    }

}
