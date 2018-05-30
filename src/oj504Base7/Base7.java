package oj504Base7;

/**
 * Given an integer, return its base 7 string representation.
 *
 * Example 1:
 * Input: 100
 * Output: "202"
 * Example 2:
 * Input: -7
 * Output: "-10"
 * Note: The input will be in range of [-1e7, 1e7].
 */

public class Base7 {
    public String convertToBase7(int num) {
        String num_7 = "";
        boolean isNeg = false;
        if(num < 0) {
            isNeg = true;
            num = -num;
        }
        while(num >= 7) {
            num_7 = num % 7 + num_7;
            num /= 7;
        }
        num_7 = num + num_7;
        if(isNeg) {
            num_7 = "-" + num_7;
        }
        return num_7;
    }
}
