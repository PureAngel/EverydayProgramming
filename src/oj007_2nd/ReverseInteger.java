package oj007_2nd;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Example 1:
 *
 * Input: 123
 * Output: 321
 * Example 2:
 *
 * Input: -123
 * Output: -321
 * Example 3:
 *
 * Input: 120
 * Output: 21
 * Note:
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1].
 * For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 */

public class ReverseInteger {
    public int reverse(int x) {
        if(x == 0) return 0;
        long res = 0;
        boolean isPositive = x > 0 ? true : false;

        if(!isPositive) {
            x = -x;
        }
        while (x > 0) {
            res *= 10;
            res += x % 10;
            x /= 10;
        }
        if(res > Integer.MAX_VALUE) {
            return 0;
        }
        return isPositive ? (int)res : -(int)res;
    }
}
