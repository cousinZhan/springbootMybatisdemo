package com.doak.springbootMybatisdemo.study;

import java.util.Date;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ：zhanyiqun
 * @description：重排序测试
 * @date ：Created in 2020/3/15
 */
public class NoVisibility {

    private static boolean ready;
    private static int number;
    private static ReentrantLock lock = new ReentrantLock();

    private static class ReaderThread extends Thread {
        @Override
        public void run() {
            while (!ready)
                Thread.yield();
            System.out.println(number);

        }
    }

    public static void createThread() {
        try {
            if (lock.tryLock(500, TimeUnit.MILLISECONDS)) {
                TimeUnit.MILLISECONDS.sleep(150);
                System.out.println("延迟");
                lock.unlock();
            }
            System.out.println("生成订单" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {

        }
    }

    public static void main(String[] args) {
//        System.out.println("start");
//        new ReaderThread().start();
//        number = 42;
//        ready = true;
        Executor executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            executor.execute(NoVisibility::createThread);
        }

    }



}
