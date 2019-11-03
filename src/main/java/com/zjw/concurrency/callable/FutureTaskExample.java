package com.zjw.concurrency.callable;

import java.util.concurrent.*;


/**
 * futureTask通过线程池创建线程
 * */
public class FutureTaskExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {


        Callable<String> callable = new Callable() {
            @Override
            public String call() throws Exception {
                return "FutureTask";
            }
        };

        ExecutorService executorService = Executors.newCachedThreadPool();
        FutureTask<String> futureTask = new FutureTask<>(callable);
        Future s = executorService.submit(futureTask);
        String result = futureTask.get();
        executorService.shutdown();
        System.out.println(result);
        System.out.println("s:"+s.get());
    }


}
