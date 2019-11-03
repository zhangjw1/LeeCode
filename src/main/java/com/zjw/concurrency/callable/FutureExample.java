package com.zjw.concurrency.callable;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * future通过线程池创建线程
 * */
public class FutureExample {

    private static final Logger log = LoggerFactory.getLogger(FutureExample.class);

    public static void main(String[] args) throws InterruptedException {
        Callable<String> callable = new Callable() {
            @Override
            public String call() throws Exception {
                log.info("do something in callable");
                Thread.sleep(5000);
                return "Done";
            }
        };
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<String> future = executor.submit(callable);
        Thread.sleep(1000);
        if(future.isDone()){
            System.out.println("线程执行完!");
        }
    }
}
