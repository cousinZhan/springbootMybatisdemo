package com.doak.springbootMybatisdemo.thread.lock;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ：zhanyiqun
 * @date ：Created in 2020/2/23 10:28
 * @description：锁教程1
 */
public class ReentranLockLesson1 {



    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock(true);
       /* lock.lock();

        lock.tryLock();
        lock.tryLock(1000L, TimeUnit.DAYS);

        lock.lockInterruptibly();*/

        lock.unlock();

    }
}
