package oj029_2nd;

/**
 * Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
 *
 * Return the quotient after dividing dividend by divisor.
 *
 * The integer division should truncate toward zero.
 *
 * Example 1:
 *
 * Input: dividend = 10, divisor = 3
 * Output: 3
 * Example 2:
 *
 * Input: dividend = 7, divisor = -3
 * Output: -2
 * Note:
 *
 * Both dividend and divisor will be 32-bit signed integers.
 * The divisor will never be 0.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 231 − 1 when the division result overflows.
 */

public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        boolean isPositive = false;
        if(dividend > 0 && divisor > 0 || dividend < 0 && divisor < 0) {
            isPositive = true;
        }
        long ldividend = Math.abs((long)dividend);
        long ldivisor = Math.abs((long)divisor);

        if(ldivisor == 0) {
            return Integer.MAX_VALUE;
        }
        if(ldividend == 0 || ldividend < ldivisor) {
            return 0;
        }

        long res = ldivide(ldividend, ldivisor);
        if(res > Integer.MAX_VALUE) {
            if(isPositive) {
                res = Integer.MAX_VALUE;
            } else {
                res = Integer.MIN_VALUE;
            }
        } else {
            if(!isPositive) {
                res = -res;
            }
        }
        return (int)res;
    }

    private long ldivide(long ldividend, long ldivisor) {
        if(ldividend < ldivisor) {
            return 0;
        }
        // find the largest multiple, ldivisor * multiple == ldividend
        long multiple = 1;
        long sum = ldivisor;
        while ((sum + sum) <= ldividend) {
            sum += sum;
            multiple += multiple;
        }
        return multiple + ldivide(ldividend - sum, ldivisor);
    }
}
