package oj067_2nd;

/**
 * Given two binary strings, return their sum (also a binary string).
 *
 * The input strings are both non-empty and contains only characters 1 or 0.
 *
 * Example 1:
 *
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 *
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 */

public class AddBinary {
    public String addBinary(String a, String b) {
        int i = a.length() - 1, j = b.length() - 1;
        int carry = 0;
        StringBuffer stringBuffer = new StringBuffer();
        while(i >= 0 || j >= 0) {
            int sum = carry;
            if(i >= 0) {
                sum += a.charAt(i--) - '0';
            }
            if(j >= 0) {
                sum += b.charAt(j--) - '0';
            }
            carry = sum / 2;
            sum %= 2;
            stringBuffer.append(sum);
        }
        if(carry != 0) {
            stringBuffer.append(carry);
        }
        return stringBuffer.reverse().toString();
    }
}
