package com.doak.springbootMybatisdemo.leetcode.string;

/**
 * @author ：zhanyiqun
 * @description：翻转元音字母
 * @date ：Created in 2020/6/17
 *
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。 从左开始，遇到最近的两个元音字母就进行翻转
 *
 * 示例 1:
 *
 * 输入: "hello"
 * 输出: "holle"
 * 示例 2:
 *
 * 输入: "leetcode"
 * 输出: "leotcede"
 * 说明:
 * 元音字母不包含字母"y"。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-vowels-of-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseVowels {

    public static String reverseVowels(String s) {

        char[] chars = s.toCharArray();
        int firstVowel = -1;
        for (int i = 0; i < s.length(); i++) {
            if (isVowel(chars[i])) {
                if (firstVowel == -1 || chars[i] == chars[firstVowel]) {
                    firstVowel = i;
                } else {
                    char temp = chars[firstVowel];
                    chars[firstVowel] = chars[i];
                    chars[i] = temp;
                    firstVowel = -1;
                }
            }
        }
        return new String(chars);
    }

    private static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
                ||ch=='A'|| ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }

    public static void main(String[] args) {
        System.out.println(ReverseVowels.reverseVowels("leetcode"));
    }


}
