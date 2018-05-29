package oj476NumberComplement;

/**
 * Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.
 *
 * Note:
 * The given integer is guaranteed to fit within the range of a 32-bit signed integer.
 * You could assume no leading zero bit in the integer’s binary representation.
 * Example 1:
 * Input: 5
 * Output: 2
 * Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
 * Example 2:
 * Input: 1
 * Output: 0
 * Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.
 */

public class NumberComplement {
    public int findComplement(int num) {
        String binaryNum = decimal2binary(num);
        String reverse_binaryNum = "";
        for(int i = 0; i < binaryNum.length(); i++) {
            if(binaryNum.charAt(i) == '1') {
                reverse_binaryNum += "0";
            } else {
                reverse_binaryNum += "1";
            }
        }
        System.out.println("reverse:"+reverse_binaryNum);
        return binary2decimal(reverse_binaryNum);
    }

    private String decimal2binary(int num) {
        String binaryNum = "";
        while(num >= 2) {
            binaryNum = num % 2 + binaryNum;
            num /= 2;
        }
        binaryNum = 1 + binaryNum;
        return binaryNum;
    }

    private int binary2decimal(String binaryNum) {
        int len = binaryNum.length();
        int num = 0;
        for(int i = 0; i < binaryNum.length(); i++) {
            num *= 2;
            num += Integer.valueOf(binaryNum.substring(i, i + 1));
        }
        return num;
    }

    public static void main(String args[]) {
        NumberComplement numberComplement = new NumberComplement();
        System.out.println(numberComplement.decimal2binary(9));
        System.out.println(numberComplement.binary2decimal("1000"));
        System.out.println(numberComplement.findComplement(2));
    }
}
