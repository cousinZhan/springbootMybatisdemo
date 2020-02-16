package com.doak.springbootMybatisdemo.Thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author ：zhanyiqun
 * @description：一个简单的多线程赛马游戏
 * @date ：Created in 2020/2/13
 * <p>
 * <p>
 * 每一个马都是一个线程
 * 1.每个线程的run方法是一个while（循环），里面调用barrier.await方法，还有每次随机增加步数
 * 2.每一个马有自己的踪迹
 * 3.每一个马，即每个线程，有自己的编号
 * <p>
 * 有个运行线程，拿来初始化线程池
 * 1.打印栅栏，每匹马的踪迹，如果哪个马先大于或等于终点，就在后面加个win
 * 2.防止程序运行太快，加个主线程睡眠
 * 3.当某个马到达终点后，就用ExecutorService.shutdownNow,  给每匹马发送 Interrupted请求，中断每个马的线程。
 */
public class HorseRacing {

    private static final int end = 100;

    private static final int COMPETITOR_AMOUNT = 6;

    /**
     * 跑道栅栏
     */
    private static String FENCE;

    private static String winnerNum;

    private static boolean gameOver;

    private static final String logo = "🐎";

    private static ExecutorService es = Executors.newFixedThreadPool(COMPETITOR_AMOUNT);

    private static List<Horse> horses = new ArrayList<>(COMPETITOR_AMOUNT);

    private static CyclicBarrier barrier = new CyclicBarrier(COMPETITOR_AMOUNT, () -> {

        //先打印栅栏
        System.out.println(FENCE);

        //遍历马群，打印踪迹
        for (Horse horse : horses) {
            String trace = horse.getTrace();
            if (trace.length() >= end) {
                System.out.println(trace.substring(0, 99).concat(logo).concat(horse.getName()).concat("win"));
                winnerNum = horse.getName();
                gameOver = true;
            } else {
                System.out.println(trace.concat(logo).concat(horse.getName()));
            }
        }

        if (gameOver) {
            System.out.println("horse".concat(winnerNum.concat(" won!!! Congratulations!!!")));
            gameOver = false;
            es.shutdownNow();
        }

        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
//            e.printStackTrace();
        }

    });

    static {
        for (int i = 0; i < COMPETITOR_AMOUNT; i++) {
            Horse horse = new Horse(barrier, String.valueOf(i));
            horses.add(horse);
            es.execute(horse);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < end; i++) {
            sb.append("=");
        }
        FENCE = sb.toString();
    }


    public static void main(String[] args) {
        //执行这个main方法就启动赛马游戏了。🐎
    }

}

class Horse implements Runnable {

    private static final Random RANDOM = new Random(47);

    private CyclicBarrier barrier;

    private String name;

    private StringBuilder trace = new StringBuilder();

    private static final String FOOT_PRINT = "*";

    public Horse(CyclicBarrier b, String name) {
        this.barrier = b;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    for (int i = 0; i < RANDOM.nextInt(3); i++) {
                        trace.append(FOOT_PRINT);
                    }
                }
                barrier.await();
            }
        } catch (InterruptedException e) {
//            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public String getTrace() {
        return trace.toString();
    }

    public String getName() {
        return name;
    }
}
