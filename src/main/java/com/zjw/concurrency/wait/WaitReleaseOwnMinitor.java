package com.zjw.concurrency.wait;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 描述：     证明wait只释放当前的那把锁
 */
public class WaitReleaseOwnMinitor {

    private static volatile Object resourceA = new Object();
    private static volatile Object resourceB = new Object();
    private static volatile Object resourceC = new Object();

    private static final Logger log = LoggerFactory.getLogger(WaitExample.class);

    static final Object object = new Object();

    public static void main(String[] args) throws InterruptedException {

        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();
        Thread3 thread3 = new Thread3();

        thread1.start();
        Thread.sleep(100);
        thread2.start();
        Thread.sleep(100);
      //  thread3.start();
    }

    static class Thread1 extends Thread{
        @Override
        public void run() {
            log.info("进入线程A");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (resourceA) {
                log.info("ThreadA got resourceA lock.");
                log.info("ThreadA tries to resourceB lock.");

                synchronized (resourceB) {
                    log.info("ThreadA got resourceB lock.");
                    try {
                        resourceA.wait();//
                        log.info("resourceA被释放掉了");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    };

   static class Thread2 extends Thread{
       @Override
       public void run() {
           log.info("进入线程B");
           try {
               Thread.sleep(1000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           synchronized (resourceA) {
               log.info("ThreadB got resourceA lock.");
               log.info("ThreadB tries to resourceB lock.");

               synchronized (resourceB) {
                   log.info("ThreadB got resourceB lock.");
               }
           }
       }
   };

    static class Thread3 extends Thread {

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (resourceC) {
                resourceC.notifyAll();
                log.info( Thread.currentThread().getName() + "唤醒了其他线程!");
            }
        }
    }
}
