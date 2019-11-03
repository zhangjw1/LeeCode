package com.zjw.concurrency.atomic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * Semaphore 信号量(控制线程并发数)
 * CountDownLatch  程序计数器，它允许一个或多个线程一直等待，直到其他线程执行完后再执行。
 * AtomicInteger 多线程环境下安全的整数类型
 * */
public class CountExampleIncre {

    static Logger log = LoggerFactory.getLogger(CountExampleIncre.class);

    private static final int clientTotal = 500;
    private static final int threadTotal = 200;
    private static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) throws Exception {

        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);

        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(()->{
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (Exception e) {
                    log.error("Exception" + e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("count:" + count);
    }

    public static void add() {
        count.incrementAndGet() ;
    }
}
