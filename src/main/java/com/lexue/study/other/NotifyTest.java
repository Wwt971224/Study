package com.lexue.study.other;

import java.nio.file.Watchable;

public class NotifyTest {


    private final Object flag = new Object();

    public static void main(String[] args) {
        NotifyTest threadTest = new NotifyTest();


        // 输出奇数
        new Thread(() -> {
            synchronized (threadTest.flag) {
                for (int i = 1; i < 100; i += 2) {
                    threadTest.flag.notify();
                    System.out.println(i);
                    try {
                        threadTest.flag.wait(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(()->{
            synchronized (threadTest.flag) {
                for (int i = 2; i <= 100; i += 2) {
                    threadTest.flag.notify();
                    System.out.println(i);
                    if (i < 100) {
                        try {
                            threadTest.flag.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();
    }


}
