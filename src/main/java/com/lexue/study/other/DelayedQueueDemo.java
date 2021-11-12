package com.lexue.study.other;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

@Slf4j
public class DelayedQueueDemo {

    public static class TestDelay implements Delayed {

        private final String str;

        private final long time;

        public TestDelay(String str, long time, TimeUnit timeUnit) {
            this.str = str;
            this.time = System.currentTimeMillis() + (time > 0 ? timeUnit.toMillis(time) : 0);
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return time - System.currentTimeMillis();
        }

        @Override
        public int compareTo(Delayed o) {
            TestDelay work = (TestDelay) o;
            if (this.time - work.time <= 0) {
                return -1;
            } else {
                return 1;
            }
        }

        public String getStr() {
            return str;
        }

    }

    public static void test_DelayQueue() throws InterruptedException {
        DelayQueue<TestDelay> delayQueue = new DelayQueue<>();
        delayQueue.offer(new TestDelay("aaa", 5, TimeUnit.SECONDS));
        delayQueue.offer(new TestDelay("bbb", 1, TimeUnit.SECONDS));
        delayQueue.offer(new TestDelay("ccc", 3, TimeUnit.SECONDS));
        log.info(delayQueue.take().getStr());
        log.info(delayQueue.take().getStr());
        log.info(delayQueue.take().getStr());
    }

    public static void main(String[] args) throws InterruptedException {
        test_DelayQueue();
    }

}
