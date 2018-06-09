package oj415AddStrings;

/**
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
 *
 * Note:
 *
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */

public class AddStrings {
    public String addStrings(String num1, String num2) {
        if(num1 == null || num1.length() == 0) {
            return num2;
        }
        if(num2 == null || num2.length() == 0) {
            return num1;
        }
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for(int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry == 1; i--, j--) {
            int num_1 = 0;
            int num_2 = 0;
            if(i >= 0) {
                num_1 = num1.charAt(i) - '0';
            }
            if(j >= 0) {
                num_2 = num2.charAt(j) - '0';
            }
            sb.append((num_1 + num_2 + carry) % 10);
            carry = (num_1 + num_2 + carry) / 10;
        }
        return sb.reverse().toString();
    }
}
