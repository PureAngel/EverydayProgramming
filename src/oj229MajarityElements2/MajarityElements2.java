package oj229MajarityElements2;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 *
 * Note: The algorithm should run in linear time and in O(1) space.
 *
 * Example 1:
 *
 * Input: [3,2,3]
 * Output: [3]
 * Example 2:
 *
 * Input: [1,1,1,3,3,2,2,2]
 * Output: [1,2]
 */

public class MajarityElements2 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int len = nums.length;
        if(len == 0) {
            return list;
        }
        if(len < 3) {
            for(int i = 0; i < len; i++) {
                if(!list.contains(nums[i])) {
                    list.add(nums[i]);
                }
            }
            return list;
        }
        int first_num = 0, count1 = 0, second_num = 0, count2 = 0;
        for(int i = 0; i < len; i++) {
            if(nums[i] == first_num) {
                count1++;
                continue;
            } else if(nums[i] == second_num) {
                count2++;
                continue;
            }

            if(count1 == 0) {
                first_num = nums[i];
                count1++;
                continue;
            } else if(count2 == 0) {
                second_num = nums[i];
                count2++;
                continue;
            }

            if(count1 > 0 && nums[i] != first_num) {
                count1--;
            }
            if(count2 > 0 && nums[i] != second_num) {
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        if(first_num == second_num) {
            for(int i = 0; i < len; i++) {
                if(nums[i] == first_num) {
                    count1++;
                }
            }
            if(count1 > len / 3) {
                list.add(first_num);
            }
        } else {
            for(int i = 0; i < len; i++) {
                if(nums[i] == first_num) {
                    count1++;
                } else if(nums[i] == second_num) {
                    count2++;
                }
            }
            if(count1 > len / 3) {
                list.add(first_num);
            }
            if(count2 > len / 3) {
                list.add(second_num);
            }
        }
        return list;
    }

    public static void main(String args[]) {
        MajarityElements2 majarityElements2 = new MajarityElements2();
        int[] nums = {2, 2, 1, 3};
        System.out.println(majarityElements2.majorityElement(nums));
    }
}
