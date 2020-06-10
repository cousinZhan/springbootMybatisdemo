package com.doak.springbootMybatisdemo.thread.volatileStudy;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ：zhanyiqun
 * @date ：Created in 2020/6/7 11:01
 * @description：数绵羊
 */
public class CountSheep implements Runnable{

    private volatile boolean finish;

    private AtomicInteger num = new AtomicInteger(0);

    public static void main(String[] args) {
       /* CountSheep countSheep = new CountSheep();
        Thread thread1 = new Thread(countSheep);
        thread1.setName("thread1");

        Thread thread2 = new Thread(countSheep);
        thread2.setName("thread2");

        Thread thread3 = new Thread(countSheep);
        thread3.setName("thread3");

        thread1.start();
        thread2.start();
        thread3.start();*/
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " in");
        while (num.get() < 100) {
            num.addAndGet(1);
        }
        finish = true;
        if (finish) {
            System.out.println("done");
        }
        System.out.println(Thread.currentThread().getName() + " out");
    }
}
