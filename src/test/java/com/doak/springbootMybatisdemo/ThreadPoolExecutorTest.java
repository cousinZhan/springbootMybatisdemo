package com.doak.springbootMybatisdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author ：zhanyiqun
 * @date ：Created in 2020/1/31 10:51
 * @description：线程池测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ThreadPoolExecutorTest {

    @Test
    public void createThreadTest() {
        ThreadPoolTaskExecutor executor = buildExecutor();
        executor.execute(() -> System.out.println("execute"));
    }

    private static ThreadPoolTaskExecutor buildExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setThreadNamePrefix("doak's thread");
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(10);
        executor.setQueueCapacity(1000);
        executor.setKeepAliveSeconds(30);
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        return executor;
    }
}
