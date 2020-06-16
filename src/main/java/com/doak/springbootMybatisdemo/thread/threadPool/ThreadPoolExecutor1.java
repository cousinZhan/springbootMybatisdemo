package com.doak.springbootMybatisdemo.thread.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author ：zhanyiqun
 * @date ：Created in 2020/4/30 20:59
 * @description：
 */
public class ThreadPoolExecutor1 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
    }
}
