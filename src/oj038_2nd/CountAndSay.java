package oj038_2nd;

/**
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth term of the count-and-say sequence.
 *
 * Note: Each term of the sequence of integers will be represented as a string.
 *
 * Example 1:
 *
 * Input: 1
 * Output: "1"
 * Example 2:
 *
 * Input: 4
 * Output: "1211"
 */

public class CountAndSay {
    public String countAndSay(int n) {
        if(n == 0) return "";
        String res = "1";
        for(int i = 1; i < n; i++) {
            String tempStr = "";
            for(int j = 0; j < res.length(); j++) {
                int count = 1;
                while (j < res.length() - 1 && res.charAt(j) == res.charAt(j + 1)) {
                    count++;
                    j++;
                }
                tempStr += Integer.toString(count) + res.charAt(j);
            }
            res = tempStr;
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 4;
        CountAndSay countAndSay = new CountAndSay();
        System.out.println(countAndSay.countAndSay(n));
    }
}
