package com.lexue.study.other;

public class DeadlockDemo {


    public static void main(String[] args) {
        testDeadLine();
    }

    public static void testDeadLine() {
        String s1 = "1";
        String s2 = "2";
        new Thread(() -> {
            System.out.println("Lock1 is running");
            while (true) {
                try {
                    synchronized (s1) {
                        System.out.println("Lock1 is lock s1");
                        Thread.sleep(3000);
                        synchronized (s2) {
                            System.out.println("Lock1 is lock s2");
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            System.out.println("Lock2 is running");
            while (true) {
                try {
                    synchronized (s2) {
                        System.out.println("Lock2 is lock s2");
                        Thread.sleep(3000);
                        synchronized (s1) {
                            System.out.println("Lock2 is lock s1");
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


}
