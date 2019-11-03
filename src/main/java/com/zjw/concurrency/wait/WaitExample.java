package com.zjw.concurrency.wait;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 知识点
 * wait()方法，会让出锁，若不加时间参数，则必须等待其他线程去唤醒，加时间参数，则在指定时间内唤醒，被唤醒后不一定立刻获得锁，需要去竞争锁
 * 在synchronized里，唤醒了其他线程，代码没执行完，会一直执行，不会让出锁
 * */
public class WaitExample {

    private static final Logger log = LoggerFactory.getLogger(WaitExample.class);

    static final Object object = new Object();

    public static void main(String[] args) throws InterruptedException {

        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();
        thread1.start();
        //thread1.join();
        Thread.sleep(2000);
        thread2.start();

    }

    static class Thread1 extends Thread {

        @Override
        public void run() {
            synchronized (object) {
                log.info("线程{}", Thread.currentThread().getName() + "开始运行!");
                try {
                    object.wait(3000);
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
                object.notify();
                log.info("线程{}", Thread.currentThread().getName() + "唤醒线程!");
            }
        }
    }


}
