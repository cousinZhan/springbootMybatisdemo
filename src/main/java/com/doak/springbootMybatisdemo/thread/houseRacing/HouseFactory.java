package com.doak.springbootMybatisdemo.thread.houseRacing;


import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author ：zhanyiqun
 * @date ：Created in 2020/2/6 15:31
 * @description：赛马工厂类
 */
@Service
public class HouseFactory {

    private static final Random random = new Random(37);

    private static final Map<Integer, House> stable = new HashMap<>();

    public House create(String name) {
        int num = random.nextInt(100);
        if (stable.containsKey(num)) {
            return stable.get(num);
        } else {
//            House newHouse = new House(num, name);
            House newHouse = null;
            stable.put(num, newHouse);
            return newHouse;
        }
    }
}
