package oj179LargestNumber;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Given a list of non negative integers, arrange them such that they form the largest number.
 *
 * Example 1:
 *
 * Input: [10,2]
 * Output: "210"
 * Example 2:
 *
 * Input: [3,30,34,5,9]
 * Output: "9534330"
 * Note: The result may be very large, so you need to return a string instead of an integer.
 */

public class LargestNumber{
    public String largestNumber(int[] nums) {
        String[] str_nums = new String[nums.length];
        for(int i = 0; i < str_nums.length; i++) {
            str_nums[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(str_nums, new LargestNumberComparator());

        if(str_nums[0].equals("0")) {
            return "0";
        }

        String largestNumber = "";
        for(int i = 0; i < str_nums.length; i++) {
            largestNumber += str_nums[i];
        }

        return largestNumber;
    }

    private class LargestNumberComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            String order1 = o1 + o2;
            String order2 = o2 + o1;
            return order2.compareTo(order1);
        }
    }
}
