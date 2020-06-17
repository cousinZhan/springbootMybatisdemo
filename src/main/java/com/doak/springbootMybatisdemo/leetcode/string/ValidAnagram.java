package com.doak.springbootMybatisdemo.leetcode.string;

/**
 * @author ：zhanyiqun
 * @date ：Created in 2020/6/7 18:57
 * @description：两个字符串包含的字符是否完全相同
 */
public class ValidAnagram {

    /**
     * 限制：字符串只包含小写字符
     * 使用26长度的数组，表示26个英文字母的坐标，通过对英文字母的计数加减，来判断是否出现相同个数的字母
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        int[] cnts = new int[26];
        for (char c : s.toCharArray()) {
            cnts[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            cnts[c - 'a']--;
        }
        for (int cnt : cnts) {
            if (cnt != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
