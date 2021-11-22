package com.lexue.study.other;


import com.alibaba.fastjson.JSON;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

import java.lang.reflect.Method;
import java.net.MalformedURLException;

public class HelloWorld {


    static class A {
        @Override
        public String toString() {
            return "A";
        }
    }

    static class B extends A {

    }


    private static final int COUNT_BITS = Integer.SIZE - 3;

    private static final int RUNNING = -1 << COUNT_BITS;

    private static final int SHUTDOWN = 0 << COUNT_BITS;

    private static final int CAPACITY = (1 << COUNT_BITS) - 1;

    private static int workerCountOf(int c) {
        return c & CAPACITY;
    }


    public static void main(String[] args) throws InterruptedException, MalformedURLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        String s1 = new String("1");
        String s2 = s1.intern();
        System.out.println(s1 == s2);

        String s3 = new String("1") + new String("1");
        String s4 = s3.intern();
        System.out.println(s3 == s4);
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        Class[] classes = {CircleTest.class};



//        System.out.println((RUNNING < SHUTDOWN));
//        System.out.println(RUNNING);
//
//        B a = new B();
//        System.out.println(a.toString());
//        while (true) {
//
//        }

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

//        ReentrantLock lock = new ReentrantLock();
//        try {
//            lock.lock();
//            Condition condition = lock.newCondition();
//            long l = TimeUnit.SECONDS.toNanos(1);
//            condition.await(1,TimeUnit.SECONDS);
//            System.out.println(1);
//        }finally {
//            lock.unlock();
//        }
//        MyClassLoader classLoader = new MyClassLoader(new URL[]{
//                new URL("file:/Users/wtai/work/idea/personal/demo/target/classes/")
//        });
//        Class<?> aClass = classLoader.loadClass("com.example.demo.controller.TestController");
//        Object o = aClass.newInstance();
//        System.out.println("o.getClass().getClassLoader() = " + o.getClass().getClassLoader());
//        System.out.println("o.getClass().getClassLoader() = " + HelloWorld.class.getClassLoader());
    }

}
