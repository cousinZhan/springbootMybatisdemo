package com.doak.springbootMybatisdemo.leetcode.string;

/**
 * @author ：zhanyiqun
 * @description：字符串中的第一个唯一字符
 * @date ：Created in 2020/6/17
 *
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 *  
 *
 * 示例：
 *
 * s = "leetcode"
 * 返回 0
 *
 * s = "loveleetcode"
 * 返回 2
 *
 * 提示：你可以假定该字符串只包含小写字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FirstUniqChar {

    public static int firstUniqChar(String s) {
//        char c = s.charAt(0);
//        int cur = 0;
        int[] letters = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (letters[c - 'a'] == -1) {
                continue;
            }
            int index = s.indexOf(c, i + 1);
            if (index >= 0) {
                letters[c - 'a'] = -1;
            } else {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int index = FirstUniqChar.firstUniqChar("loveleetcode");
        System.out.println(index);
    }
}
