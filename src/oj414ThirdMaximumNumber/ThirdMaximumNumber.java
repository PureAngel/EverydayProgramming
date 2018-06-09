package oj414ThirdMaximumNumber;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).
 *
 * Example 1:
 * Input: [3, 2, 1]
 *
 * Output: 1
 *
 * Explanation: The third maximum is 1.
 * Example 2:
 * Input: [1, 2]
 *
 * Output: 2
 *
 * Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
 * Example 3:
 * Input: [2, 2, 3, 1]
 *
 * Output: 1
 *
 * Explanation: Note that the third maximum here means the third maximum distinct number.
 * Both numbers with value 2 are both considered as second maximum.
 */

public class ThirdMaximumNumber {
    public int thirdMax(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        boolean hasSecondMax = false;
        boolean hasThirdMax = false;
        int len = nums.length;
        if(len == 1) {
            return nums[0];
        }
        if(len == 2) {
            return Math.max(nums[0], nums[1]);
        }
        max1 = nums[0];
        for(int i = 1; i < len; i++) {
            if(nums[i] > max1) {
                if(hasSecondMax) {
                    max3 = max2;
                    hasThirdMax = true;
                }
                max2 = max1;
                max1 = nums[i];
                hasSecondMax = true;
            } else if(nums[i] < max1) {
                if(!hasSecondMax || nums[i] > max2) {
                    if(hasSecondMax && nums[i] > max2) {
                        max3 = max2;
                        hasThirdMax = true;
                    }
                    max2 = nums[i];
                    hasSecondMax = true;
                } else if(nums[i] < max2 && (nums[i] > max3 || !hasThirdMax)) {
                    max3 = nums[i];
                    hasThirdMax = true;
                }
            }
        }
        if(hasThirdMax) {
            return max3;
        }
        return max1;
    }

    public static void main(String args[]) {
        int[] nums = {5,2,2};
        ThirdMaximumNumber thirdMaximumNumber = new ThirdMaximumNumber();
        System.out.println(thirdMaximumNumber.thirdMax(nums));
    }
}
