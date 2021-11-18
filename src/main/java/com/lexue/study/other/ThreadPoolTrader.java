package com.lexue.study.other;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolTrader implements Executor {

    private final AtomicInteger ctl = new AtomicInteger(0);

    private volatile int corePoolSize;
    private volatile int maximumPoolSize;

    private final BlockingQueue<Runnable> workQueue;

    public ThreadPoolTrader(int corePoolSize, int maximumPoolSize, BlockingQueue<Runnable> workQueue) {
        this.corePoolSize = corePoolSize;
        this.maximumPoolSize = maximumPoolSize;
        this.workQueue = workQueue;
    }

    @Override
    public void execute(Runnable command) {
        int c = ctl.get();
        if (c < corePoolSize) {
            if (!addWorker(command, true)) {
                reject();
            }
            return;
        }
        if (!workQueue.offer(command)) {
            if (!addWorker(command, false)) {
                reject();
            }
        }
    }

    private boolean addWorker(Runnable firstTask,boolean core) {
        if (ctl.get() >= (core ? corePoolSize : maximumPoolSize)) {
            return false;
        }
        Worker worker = new Worker(firstTask);
        worker.thread.start();
        ctl.incrementAndGet();
        return true;
    }

    private void reject() {
        throw new RuntimeException("Error！ctl.count：" + ctl.get() + " workQueue.size：" + workQueue.size());
    }

    private Runnable getTask() {
        for (; ; ) {
            try {
                System.out.println("workQueue.size：" + workQueue.size());
                if (!workQueue.isEmpty() || ctl.get() <= corePoolSize) {
                    return workQueue.take();
                } else {
                    return null;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void runWorker(Worker w) {
        Runnable task = w.firstTask;
        try {
            while (task != null || (task = getTask()) != null) {
                task.run();
                task = null;
            }
        } finally {
            ctl.decrementAndGet();
        }
    }

    private final class Worker implements Runnable {

        final Thread thread;

        Runnable firstTask;

        private Worker(Runnable firstTask) {
            this.thread = new Thread(this);
            this.firstTask = firstTask;
        }

        @Override
        public void run() {
            runWorker(this);
        }

    }

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolTrader threadPoolTrader = new ThreadPoolTrader(2, 10, new ArrayBlockingQueue<>(10));

        for (int i = 0; i < 40; i++) {
            int finalI = i;
            threadPoolTrader.execute(() -> {
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("任务编号：" + finalI);
            });
        }

        Thread.sleep(10000);
        System.out.println("===========================");
        System.out.println(threadPoolTrader.corePoolSize);
        System.out.println(threadPoolTrader.maximumPoolSize);
        System.out.println(threadPoolTrader.ctl.get());
    }

}
