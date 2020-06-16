package com.doak.springbootMybatisdemo.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

/**
 * @author ：zhanyiqun
 * @date ：Created in 2020/6/9 0:07
 * @description：
 */
public class Solution {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{i, map.get(complement)};
            }
        }
        throw new RuntimeException("no such element");
    }

    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<Character, Character>(3) {
            {
                put('(', ')');
                put('{', '}');
                put('[', ']');
            }
        };

        LinkedList<Character> stack = new LinkedList<>();
        char[] str = s.toCharArray();
        for (int i = 0; i < str.length; i++) {
            if (map.containsKey(str[i])) {
                stack.addLast(str[i]);
            } else if (!stack.isEmpty() && map.get(stack.getLast()) == str[i]) {
                stack.removeLast();
            } else {
                return false;
            }
        }
        return stack.size() == 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        solution.twoSum(new int[]{2, 7, 11, 15}, 9);
        boolean valid = solution.isValid("[]]");
        System.out.println(valid);
    }

}
