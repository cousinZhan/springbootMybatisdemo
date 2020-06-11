package com.doak.springbootMybatisdemo.leetcode;

/**
 * @author ：zhanyiqun
 * @date ：Created in 2020/6/10 21:38
 * @description：是否是回文数 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 121
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 * <p>
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 * <p>
 * 你能不将整数转为字符串来解决这个问题吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsPalindrome {

    /**
     * 暴力法
     *
     * @param x
     * @return
     */
    public boolean isPalindrome1(int x) {
        String str = String.valueOf(x);
        char[] a = str.toCharArray();
        char[] b = new char[a.length];
        int j = 0;
        for (int i = a.length - 1; i >= 0; i--) {
            b[j] = a[i];
            j++;
        }
        if (new String(a).equals(new String(b))) {
            return true;
        }
        return false;
    }

    /**
     * 使用双指针，一个从头，一个从尾，往中间读数，如果遇到不同的，说明就不是回文
     * @param x
     * @return
     */
    public boolean isPalindrome2(int x) {
        String str = String.valueOf(x);
        char[] a = str.toCharArray();
        int h = 0;
        int t = a.length - 1;
        while (h != t) {
            if (a[h] != a[t]) {
                return false;
            }
            h++;
            t--;
        }
        return true;
    }

    /**
     * 使用翻转一半数字的方法
     *
     * 算法
     *
     * 首先，我们应该处理一些临界情况。所有负数都不可能是回文，例如：-123 不是回文，因为 - 不等于 3。
     * 所以我们可以对所有负数返回 false。除了 0 以外，所有个位是 0 的数字不可能是回文，因为最高位不等于 0。
     * 所以我们可以对所有大于 0 且个位是 0 的数字返回 false。
     *
     * 现在，让我们来考虑如何反转后半部分的数字。
     *
     * 对于数字 1221，如果执行 1221 % 10，我们将得到最后一位数字 1，要得到倒数第二位数字，
     * 我们可以先通过除以 10 把最后一位数字从 1221 中移除，1221 / 10 = 122，再求出上一步结果除以 10 的余数，
     * 122 % 10 = 2，就可以得到倒数第二位数字。如果我们把最后一位数字乘以 10，再加上倒数第二位数字，1 * 10 + 2 = 12，
     * 就得到了我们想要的反转后的数字。如果继续这个过程，我们将得到更多位数的反转数字。
     *
     * 现在的问题是，我们如何知道反转数字的位数已经达到原始数字位数的一半？
     *
     * 由于整个过程我们不断将原始数字除以 10，然后给反转后的数字乘上 10，所以，当原始数字小于或等于反转后的数字时，就意味着我们已经处理了一半位数的数字了。
     *
     *
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/palindrome-number/solution/hui-wen-shu-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if (x % 10 == 0 || (x % 10 == 0 && x < 0)) {
            return false;
        }
        int revertNum = 0;
        while (revertNum <= x) {
            revertNum = revertNum * 10 + x % 10;
            x /= 10;
        }
        if (revertNum == x || revertNum / 10 == x) {
            return true;
        }
        return false;
    }


}
