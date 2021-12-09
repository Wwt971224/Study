package com.lexue.study.spring.controller;

import com.lexue.study.spring.bean.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/user1")
    public User getUser1() throws InterruptedException {
        Thread.sleep(10000);
        System.out.println("/user1的Thread.id = " + Thread.currentThread().getId());

        return new User("1", "1", "1");
    }

    @GetMapping("/user2")
    public User getUser2() {
        System.out.println("/user2的Thread.id = " + Thread.currentThread().getId());
        return new User("2", "2", "2");
    }

}


