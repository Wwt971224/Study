package com.lexue.study.other;


import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class StringTest {
    static int a = 0;

    static int b;

    static volatile boolean flag;

    static volatile int num = 1;


    public static void main(String[] args) {
//        test0();
//        test1();
//        test2();
//        test3();
//        test4();
//        test5();
    }

    public static void test0() {
        Object object = new Object();
        // 输出奇数
        new Thread(() -> {
            synchronized (object) {
                while (a < 100) {
                    System.out.println(a++);
                    object.notify();
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();

        new Thread(() -> {
            synchronized (object) {
                while (a < 100) {
                    System.out.println(Thread.currentThread().getName() + " " + a++);
                    object.notify();
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }

    public static void test1() {
        ReentrantLock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();
        new Thread(() -> {
            lock.lock();
            try {
                if (a % 2 == 0) {
                    condition2.await();
                }
                for (int i = a; i < 100; i++) {
                    System.out.println(Thread.currentThread().getName() + " " + a++);
                    condition1.signal();
                    condition2.await();
                }
//                condition1.signalAll();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();

        new Thread(() -> {
            lock.lock();
            try {
                if (a % 2 != 0) {
                    condition1.wait();
                }
                for (int i = a; i < 100; i++) {

                    System.out.println(a++);
                    condition2.signal();
                    condition1.await();
                }
//                condition2.signalAll();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();
    }

    public static void test2() {
        new Thread(() -> {
            while (b < 100) {
                if (flag) {
                    System.out.println(Thread.currentThread().getName() + " " + b++);
//                    try {
//                        Thread.sleep(300);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    flag = false;
                }
            }
        }).start();
        new Thread(() -> {
            while (b < 100) {
                if (!flag) {
                    System.out.println(b++);
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    flag = true;
//                    try {
//                        Thread.sleep(10000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }

                }
            }
        }).start();
    }

    public static void test3() {
        ReentrantLock lock = new ReentrantLock();
        Condition conditionA = lock.newCondition();
        Condition conditionB = lock.newCondition();
        Condition conditionC = lock.newCondition();
        new Thread(() -> {
            lock.lock();
            try {
                if (num != 1) {
                    conditionA.await();
                }
                for (int i = 0; i < 20; i++) {
                    num = 2;
                    System.out.println("A");
                    conditionB.signal();
                    conditionA.await();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();
        new Thread(() -> {
            lock.lock();
            try {
                if (num != 2) {
                    conditionB.await();
                }
                for (int i = 0; i < 20; i++) {
                    num = 3;
                    System.out.println("B");
                    conditionC.signal();
                    conditionB.await();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();
        new Thread(() -> {
            lock.lock();
            try {
                if (num != 3) {
                    conditionC.await();
                }
                for (int i = 0; i < 20; i++) {
                    System.out.println("C");
                    num = 1;
                    conditionA.signal();
                    conditionC.await();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();

    }

    public static void test4() {
        Object o1 = new Object();
        Object o2 = new Object();
        Object o3 = new Object();
        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                synchronized (o3) {
                    synchronized (o1) {
                        System.out.println("A");
                        o1.notifyAll();
                    }
                    try {
                        if (i < 19) {
                            o3.wait();
                        } else {
                            o3.notifyAll();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                synchronized (o1) {
                    synchronized (o2) {
                        System.out.println("B");
                        o2.notifyAll();
                    }
                    try {
                        if (i < 19) {
                            o1.wait();
                        } else {
                            o1.notifyAll();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                synchronized (o2) {
                    synchronized (o3) {
                        System.out.println("C");
                        o3.notifyAll();
                    }
                    try {
                        if (i < 19) {
                            o2.wait();
                        } else {
                            o2.notifyAll();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public static void test5() {
        Semaphore semaphoreA = new Semaphore(1);
        Semaphore semaphoreB = new Semaphore(0);
        Semaphore semaphoreC = new Semaphore(0);
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    semaphoreA.acquire();
                    System.out.println("A");
                    semaphoreB.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    semaphoreB.acquire();
                    System.out.println("B");
                    semaphoreC.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    semaphoreC.acquire();
                    System.out.println("C");
                    semaphoreA.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


}
