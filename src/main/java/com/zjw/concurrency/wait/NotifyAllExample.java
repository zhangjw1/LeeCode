package com.zjw.concurrency.wait;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 知识点
 * 多个线程调用wait()方法后，notify()只随机唤醒一个线程，notifyAll()唤醒所有线程
 * */
public class NotifyAllExample {

    private static final Logger log = LoggerFactory.getLogger(WaitExample.class);

    static final Object object = new Object();

    public static void main(String[] args) throws InterruptedException {

        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();
        Thread3 thread3 = new Thread3();

        thread1.start();
        thread2.start();
        Thread.sleep(200);
        thread3.start();

    }

    static class Thread1 extends Thread {

        @Override
        public void run() {
            synchronized (object) {
                log.info("线程{}", Thread.currentThread().getName() + "开始运行!");
                try {
                    object.wait();
                    //object.wait(3000);//若wait设置参数，则在对应休眠时间结束后马上去竞争获取锁，不需要notify去唤醒，若notify在wait设置的时间之前执行，则提前唤醒线程
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("哦豁,线程{}", Thread.currentThread().getName() + "被唤醒了,重新获得锁!");
            }
        }
    }

    static class Thread2 extends Thread {

        @Override
        public void run() {
            synchronized (object) {
                log.info("线程{}", Thread.currentThread().getName() + "开始运行!");
                try {
                    object.wait();
                    //object.wait(3000);//若wait设置参数，则在对应休眠时间结束后马上去竞争获取锁，不需要notify去唤醒，若notify在wait设置的时间之前执行，则提前唤醒线程
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("哦豁,线程{}", Thread.currentThread().getName() + "被唤醒了,重新获得锁!");
            }
        }
    }

    static class Thread3 extends Thread {

        @Override
        public void run() {
            synchronized (object) {
                object.notifyAll();
                log.info( Thread.currentThread().getName() + "唤醒了其他线程!");
            }
        }
    }
}
