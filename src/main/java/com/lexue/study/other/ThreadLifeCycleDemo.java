package com.lexue.study.other;

public class ThreadLifeCycleDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(15000);

        long begin = System.currentTimeMillis();
//        for (int i = 0; i < 1000; i++) {
//            new Thread(() -> {
//                try {
//                        Thread.sleep(10000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getId() + " run");
//            }).start();
//        }
//        System.out.println(System.currentTimeMillis() - begin);
//
//        for (int i = 0; i < 1000; i++) {
//            new Thread(() -> {
//                synchronized (ThreadLifeCycleDemo.class) {
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getId() + " run");
//                }
//            }).start();
//        }
//        System.out.println(System.currentTimeMillis() - begin);


//        for (int i = 0; i < 10; i++) {
//            Thread thread = new Thread(() -> {
//                try {
//                    Thread.sleep(1000);
//                    System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getId() + " run");
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            });
//            thread.start();
//            thread.join();
//        }
//        System.out.println(System.currentTimeMillis() - begin);

        for (int i = 0; i < 1000000000; i++) {
            Integer integer = i;
            System.out.println(integer);
        }
        while (true) {

        }
    }

}
