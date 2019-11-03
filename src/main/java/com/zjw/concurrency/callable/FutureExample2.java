package com.zjw.concurrency.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * futureTask创建线程
 * */
public class FutureExample2 {

   static Callable<String> callable = new Callable() {
        @Override
        public String call() throws Exception {
            return "FutureTask";
        }
    };



    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //new Thread(callable).start();
        FutureTask<String> futureTask = new FutureTask<>(callable);
        Thread thread = new Thread(futureTask);
        thread.start();
        thread.join();
        new Thread(new runner()).start();
        System.out.println(futureTask.get());
    }

    static class runner implements Runnable{
        @Override
        public void run() {

            System.out.println("runnable");
        }
    };

}
