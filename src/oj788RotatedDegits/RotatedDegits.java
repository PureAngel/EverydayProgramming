package oj788RotatedDegits;

import java.util.HashMap;
import java.util.Map;

/**
 * X is a good number if after rotating each digit individually by 180 degrees, we get a valid number that is different from X.  Each digit must be rotated - we cannot choose to leave it alone.
 *
 * A number is valid if each digit remains a digit after rotation. 0, 1, and 8 rotate to themselves; 2 and 5 rotate to each other; 6 and 9 rotate to each other, and the rest of the numbers do not rotate to any other number and become invalid.
 *
 * Now given a positive number N, how many numbers X from 1 to N are good?
 *
 * Example:
 * Input: 10
 * Output: 4
 * Explanation:
 * There are four good numbers in the range [1, 10] : 2, 5, 6, 9.
 * Note that 1 and 10 are not good numbers, since they remain unchanged after rotating.
 * Note:
 *
 * N  will be in range [1, 10000].
 */

public class RotatedDegits {
    Map<Integer, Integer> map = new HashMap<>();
    public int rotatedDigits(int N) {
        map.put(1, 1);
        map.put(2, 5);
        map.put(5, 2);
        map.put(6, 9);
        map.put(8, 8);
        map.put(9, 6);
        map.put(0, 0);
        int[] res = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            if(isGood(i)) {
                res[i] = res[i - 1] + 1;
            } else {
                res[i] = res[i - 1];
            }
        }
        return res[N];
    }

    private boolean isGood(int N) {
        int res = 0;
        int n = N;
        while(n > 0) {
            if(!map.containsKey(n % 10)) {
                return false;
            }
            res = 10 * res + map.get(n % 10);
            n /= 10;
        }
        String s_res = String.valueOf(res);
        String s_n = String.valueOf(N);
        int len = s_res.length();
        for(int i = 0; i < len; i++) {
            if(s_res.charAt(i) != s_n.charAt(len - i - 1)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int N = 10;
        RotatedDegits rotatedDegits = new RotatedDegits();
        System.out.println(rotatedDegits.rotatedDigits(N));
    }
}
