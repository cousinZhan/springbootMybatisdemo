package com.doak.springbootMybatisdemo.demo;

/**
 * @author ：zhanyiqun
 * @description：拆装箱测试
 * @date ：Created in 2020/3/2
 */
public class UnBoxingTest {

    public void test1() {
        Integer a = null;
        int b = 237;
        if (b == a) {

        }
    }

    public static void main(String[] args) {
        UnBoxingTest test = new UnBoxingTest();
        test.test1();
    }
}
