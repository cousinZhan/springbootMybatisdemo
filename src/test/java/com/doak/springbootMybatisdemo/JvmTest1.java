package com.doak.springbootMybatisdemo;

import org.junit.Test;

/**
 * @author ：zhanyiqun
 * @date ：Created in 2019/12/23 7:06
 * @description：
 */
public class JvmTest1 {

    public interface  Interface0 extends Interface1{
        int a = 0 ;
    }

    public interface Interface1 {
         int a = 2;
    }

    static class  TestClass1 implements Interface0 {
        static int a  =  3;
    }

    static class TestClass2 extends TestClass1 implements Interface1 {
        static  int a  = 4;

        public void testForwardRef(){
            System.out.println(c);
        }

        public int c = 0;

        static {
            System.out.println(a);
        }
    }

    public static void main(String[] args) {
        System.out.println("jjjj");
        System.out.println(TestClass2.a);
        TestClass2 testClass2 = new TestClass2();
        testClass2.testForwardRef();

    }
}
