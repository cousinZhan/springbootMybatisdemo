package com.doak.springbootMybatisdemo.thread.houseRacing;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @author ：zhanyiqun
 * @date ：Created in 2020/2/6 15:26
 * @description：赛马比赛
 */
public class HouseRacingGame {

    private static final int competitorNum = 6;

    private static CyclicBarrier cyclicBarrier;

    private ExecutorService exec = new ThreadPoolExecutor(6, 10, 5000, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>());

    private static final int END_TRACK = 100;

    private static final int FINISH_LINE = 75;

    private static List<House> houses = new ArrayList<>();

    @Autowired
    private HouseFactory houseFactory;

    public void run() {
        cyclicBarrier = new CyclicBarrier(competitorNum, () -> {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < FINISH_LINE; i++) {
                sb.append("=");
            }
            System.out.println(sb);
            for (House house : houses) {
                System.out.println(house.getTrack());
            }
            for (House horse : houses) {
                if (horse.getTrack()>=FINISH_LINE) {
                    System.out.println(horse+" won ");
                    exec.shutdownNow();
                    return ;
                }
            }

        });


    }

    public void addHouse(int size) {
        for (int i = 0; i < size; i++) {
            House House = new House(i);
            exec.execute(House);
        }

    }


}

class House implements Runnable {
    private int i;

    private int track = 0;

    private static Random random = new Random(37);

    public House(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            synchronized (this) {
                track += random.nextInt(3);
            }
        }
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getTrack() {
        return track;
    }

    public void setTrack(int track) {
        this.track = track;
    }
}