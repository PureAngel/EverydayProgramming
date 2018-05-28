package oj264UglyNumber2;


/**
 * Write a program to find the n-th ugly number.
 *
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 *
 * Example:
 *
 * Input: n = 10
 * Output: 12
 * Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 * Note:
 *
 * 1 is typically treated as an ugly number.
 * n does not exceed 1690.
 */

public class UglyNumber2 {
    public int nthUglyNumber(int n) {
        if(n <= 6) {
            return n;
        }
        int[] primes = {2, 3, 5};
        int prime_len = primes.length;
        int[] uglyNum = new int[prime_len];
        int[] indices = new int[prime_len];
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < prime_len; j++) {
                uglyNum[j] = dp[indices[j]] * primes[j];
            }
            int min = minNum(uglyNum);
            dp[i] = min;
            for(int j = 0; j < prime_len; j++) {
                if(min == uglyNum[j]) {
                    indices[j]++;
                }
            }
        }
        return dp[n - 1];
    }

    private int minNum(int[] primes) {
        int min = primes[0];
        for(int i = 1; i < primes.length; i++) {
            if(primes[i] < min) {
                min = primes[i];
            }
        }
        return min;
    }
}
