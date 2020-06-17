package com.doak.springbootMybatisdemo.Thread.Thread.AQSLesson1;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ：zhanyiqun
 * @description：
 * @date ：Created in 2020/2/24
 */
public class CASLesson1 {

    public static void main(String[] args) {

        CASLesson1 casLesson1 = new CASLesson1();
//        int result = casLesson1.romanToInt("MCMXCIV");
//        System.out.println(result);
//        int lastWordLength = casLesson1.lastWordLength("hdeyehY uej ");
        boolean palindrome = casLesson1.isPalindrome2("race a car");
//        System.out.println(lastWordLength);
        System.out.println(palindrome);
    }


    public static int romanToInt(String s) {
        String I = "1";
        String V = "5";
        String X = "10";
        String L = "50";
        String C = "100";
        String D = "500";
        String M = "1000";

        String four = "IV"; //4
        String nine = "IX"; //9
        String forty = "XL"; //40
        String ninty = "XC"; //90
        String fourH = "CD"; //400
        String nineH = "CM"; //900

        HashMap<String, Integer> romanMap = new HashMap<>();
        romanMap.put("I", 1);
        romanMap.put("V", 5);
        romanMap.put("X", 10);
        romanMap.put("L", 50);
        romanMap.put("C", 100);
        romanMap.put("D", 500);
        romanMap.put("M", 1000);
        romanMap.put("IV", 4);
        romanMap.put("IX", 9);
        romanMap.put("XL", 40);
        romanMap.put("XC", 90);
        romanMap.put("CD", 400);
        romanMap.put("CM", 900);

        char[] chars = s.toCharArray();
        StringBuilder sb;
        int result = 0;
        for (int i = 0; i < chars.length; i++) {
            sb = new StringBuilder();
            sb.append(chars[i]);
            if (i != chars.length - 1) {
                sb.append(chars[i + 1]);
            }
            String str = sb.toString();
            int n;
            if (romanMap.containsKey(str)) {
                n = romanMap.get(str);
                i++;
            } else {
                n = romanMap.get(String.valueOf(chars[i]));
            }
            result = result + n;
        }
        return result;

    }

    public int lastWordLength(String s) {
        int strLength = s.length();
        int lastWordLength = 0;
        int i = strLength - 1;
        while (i >= 0) {
            if (s.charAt(i--) != ' '){
                lastWordLength++;
            } else
            if (lastWordLength > 0) {
                return lastWordLength;
            }
        }
        return lastWordLength;
    }

    /**
     * 使用双指针，当两边都是right>=left时，一直比较，都相同就是回文
     * @param s
     * @return
     */
    public boolean isPalindrome2(String s) {
        int sLength = s.length(), left = 0, right = sLength - 1;
        char[] chars = s.toLowerCase().toCharArray();
        while (right >= left) {
            if (!('0' <= chars[left] && chars[left] <= '9') && !('a' <= chars[left] && chars[right] <= 'z')) {
                left++;
                continue;
            }

            if (!('0' <= chars[right] && chars[right] <= '9') && !('a' <= chars[right] && chars[right] <= 'z')) {
                right--;
                continue;
            }

            if (chars[left] == chars[right]) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }

}
