package com.lexue.study.other;


import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.sun.jmx.remote.internal.ArrayQueue;
import org.apache.commons.collections4.Get;
import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class HelloWorld {

    class A{

    }

    private static final int COUNT_BITS = Integer.SIZE - 3;

    private static final int RUNNING    = -1 << COUNT_BITS;

    private static final int SHUTDOWN   =  0 << COUNT_BITS;

    private static final int CAPACITY   = (1 << COUNT_BITS) - 1;

    private static int workerCountOf(int c)  { return c & CAPACITY; }



    public static void main(String[] args) throws InterruptedException {

        System.out.println((RUNNING < SHUTDOWN));
        System.out.println(RUNNING);


//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 10, 0, TimeUnit.SECONDS, new ArrayBlockingQueue<>(20));
//        for (int j = 0; j < 100; j++) {
//            int i = j;
//            threadPoolExecutor.execute(() -> {
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(i);
//                System.out.println("threadPoolExecutor.getQueue().size() = " + threadPoolExecutor.getQueue().size());
//                System.out.println("===========================");
//            });
//        }
//        ArrayBlockingQueue<Object> objects = new ArrayBlockingQueue<>(20);
//        new Thread(()->{
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            objects.add(1);
//        }).start();
//        Object poll = objects.poll(2, TimeUnit.SECONDS);
//        System.out.println(poll);

        ReentrantLock lock = new ReentrantLock();
        try {
            lock.lock();
            Condition condition = lock.newCondition();
            long l = TimeUnit.SECONDS.toNanos(1);
            condition.await(1,TimeUnit.SECONDS);
            System.out.println(1);
        }finally {
            lock.unlock();
        }

    }

}
