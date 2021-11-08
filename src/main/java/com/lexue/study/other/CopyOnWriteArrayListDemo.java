package com.lexue.study.other;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListDemo {

    public static void main(String[] args) {
        List<Message> messages = new CopyOnWriteArrayList<>();
        Message message = new Message("zs");
        messages.add(message);
        message.setMsg("ls");
        System.out.println(messages);

    }

    @Data
    @AllArgsConstructor
    public static class Message {
        private String msg;
    }

}
