package com.lexue.study.other;

import java.util.ArrayList;
import java.util.List;

public class Deadlock2Demo {

    public static void main(String[] args) {
        Account a = new Account();
        Account b = new Account();
        new Thread(() -> a.transfer(b, 100));
        new Thread(() -> b.transfer(a, 200));
        while (true) {

        }
    }

    public static class Allocator {
        private List<Object> als = new ArrayList<>();

        synchronized boolean apply(Object from, Object to) {
            if (als.contains(from) || als.contains(to)) {
                return false;
            } else {
                als.add(from);
                als.add(to);
            }
            return true;
        }

        synchronized void clean(Object from, Object to) {
            als.remove(from);
            als.remove(to);
        }
    }

    public static class Account {
        private Allocator actr = getInstance();

        private int balance;

        public void transfer(Account target, int amt) {
            while (!actr.apply(this, target)) {
                try {
                    synchronized (this) {
                        System.out.println(this.toString() + " lock obj1");
                        synchronized (target) {
                            System.out.println(this.toString() + " lock obj2");
                            if (this.balance > amt) {
                                this.balance -= amt;
                                target.balance += amt;
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    //执行完后，再释放持有的资源
                    actr.clean(this, target);
                }
            }
        }
    }

    private static class SingleTonHoler{
        private static final Allocator INSTANCE = new Allocator();
    }

    public static Allocator getInstance() {
        return SingleTonHoler.INSTANCE;
    }
}
