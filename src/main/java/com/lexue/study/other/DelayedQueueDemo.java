package com.lexue.study.other;

import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

@Slf4j
public class DelayedQueueDemo {

    @ToString
    static class TestDelayed implements Delayed {

        private String string;

        private long time;

        public TestDelayed(String string, Long time, TimeUnit unit) {
            this.string = string;
            this.time = System.currentTimeMillis() + (time > 0 ? unit.toMillis(time) : 0);
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return time - System.currentTimeMillis();
        }

        @Override
        public int compareTo(Delayed o) {
            TestDelayed work = (TestDelayed) o;
            long diff = this.time - work.time;
            if (diff <= 0) {
                return -1;
            } else {
                return 1;
            }
        }

        public String getString() {
            return string;
        }
    }

    static void test_delayed() throws InterruptedException {
        DelayQueue<TestDelayed> delayQueue = new DelayQueue<>();
        delayQueue.offer(new TestDelayed("aaa", 9L, TimeUnit.SECONDS));
        delayQueue.offer(new TestDelayed("bbb", 8L, TimeUnit.SECONDS));
        delayQueue.offer(new TestDelayed("ccc", 7L, TimeUnit.SECONDS));
        delayQueue.offer(new TestDelayed("ddd", 6L, TimeUnit.SECONDS));
        delayQueue.offer(new TestDelayed("eee", 5L, TimeUnit.SECONDS));
        delayQueue.offer(new TestDelayed("fff", 4L, TimeUnit.SECONDS));
        delayQueue.offer(new TestDelayed("ggg", 3L, TimeUnit.SECONDS));
//        delayQueue.offer(new TestDelayed("hhh", 2L, TimeUnit.SECONDS));
        System.out.println(delayQueue);
        log.info(delayQueue.take().getString());
        log.info(delayQueue.take().getString());
        log.info(delayQueue.take().getString());
        log.info(delayQueue.take().getString());
        log.info(delayQueue.take().getString());
        log.info(delayQueue.take().getString());
        log.info(delayQueue.take().getString());
//        log.info(delayQueue.take().getString());

    }

    public static void main(String[] args) throws InterruptedException {
        test_delayed();
    }


}
