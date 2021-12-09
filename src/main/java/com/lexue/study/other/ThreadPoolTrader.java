package com.lexue.study.other;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolTrader implements Executor {

    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int CAPACITY   = (1 << COUNT_BITS) - 1;

    // runState is stored in the high-order bits
    private static final int RUNNING    = -1 << COUNT_BITS;
    private static final int SHUTDOWN   =  0 << COUNT_BITS;
    private static final int STOP       =  1 << COUNT_BITS;
    private static final int TIDYING    =  2 << COUNT_BITS;
    private static final int TERMINATED =  3 << COUNT_BITS;

    // 线程中活跃的线程数
    private AtomicInteger ctl = new AtomicInteger(0);

    private int corePoolSize;

    private int maximumPoolSize;

    private BlockingQueue<Runnable> workQueue;


    public ThreadPoolTrader(int corePoolSize, int maximumPoolSize, BlockingQueue<Runnable> workQueue) {
        this.corePoolSize = corePoolSize;
        this.maximumPoolSize = maximumPoolSize;
        this.workQueue = workQueue;
    }

    @Override
    public void execute(Runnable command) {
        if (ctl.get() <= corePoolSize) {
            if (addWorker(command, true)) {
                return;
            }
        }
        if (!workQueue.offer(command)) {
            if (!addWorker(command, false)) {
                reject();
            }
        }
    }

    public void reject() {
        throw new RuntimeException("Error! maximumPoolSize = " + maximumPoolSize + " workQueue.size() = " + workQueue.size());
    }

    public boolean addWorker(Runnable runnable, boolean core) {
        if (ctl.get() >= (core ? corePoolSize : maximumPoolSize)) {
            return false;
        }
        // 往线程池去添加线程
        Worker worker = new Worker(runnable);
        worker.thread.start();
        ctl.incrementAndGet();
        return true;
    }

    public Runnable getTask() {
        for (; ; ) {
            if (!workQueue.isEmpty() || ctl.get() <= corePoolSize) {
                try {
                    return workQueue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                return null;
            }
        }
    }

    public void runWork(Worker worker) {
        Runnable runnable = worker.firstTask;
        try {
            while (runnable != null || (runnable = getTask()) != null) {
                runnable.run();
                runnable = null;
            }
        } finally {
            ctl.decrementAndGet();
        }
    }

    public class Worker implements Runnable {

        private Thread thread;
        private Runnable firstTask;

        public Worker(Runnable firstTask) {
            this.thread = new Thread(this);
            this.firstTask = firstTask;
        }

        @Override
        public void run() {
            runWork(this);
        }
    }


    public static void main(String[] args) throws InterruptedException {
//        ThreadPoolTrader threadPoolTrader = new ThreadPoolTrader(2, 10, new ArrayBlockingQueue<>(29));
//        for (int i = 0; i < 40; i++) {
//
//            int finalI = i;
//            threadPoolTrader.execute(() -> {
//                System.out.println("工作编号" + finalI + " 正在执行");
////                try {
////                    Thread.sleep(2000);
////                } catch (InterruptedException e) {
////                    e.printStackTrace();
////                }
//            });
//        }
        Runnable runnable = new Runnable() {
            @Override
            public void run() {

            }
        };
        runnable.run();
        Thread thread = new Thread();
        thread.start();
        thread.run();
    }
}
