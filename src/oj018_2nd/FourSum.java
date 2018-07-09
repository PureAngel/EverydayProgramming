package oj018_2nd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 *
 * Note:
 *
 * The solution set must not contain duplicate quadruplets.
 *
 * Example:
 *
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 *
 * A solution set is:
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 */

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        if(nums == null || nums.length < 4) {
            return lists;
        }
        Arrays.sort(nums);
        if(nums[0] * 4 > target || nums[nums.length - 1] * 4 < target) {
            return lists;
        }
        int max = nums[nums.length - 1];
        for(int i = 0; i < nums.length; i++) {
            // duplicate
            if(i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            // too small
            if(nums[i] + 3 * max < target) {
                continue;
            }
            // too big
            if(nums[i] * 4 > target) {
                break;
            }
            if(nums[i] * 4 == target) {
                if(i < nums.length - 3 && nums[i + 3] == nums[i]) {
                    if(!lists.contains(Arrays.asList(nums[i], nums[i], nums[i], nums[i]))) {
                        lists.add(Arrays.asList(nums[i], nums[i], nums[i], nums[i]));
                    }
                }
                break;
            }
            threeSum(nums, target - nums[i], i + 1, nums.length - 1, lists, nums[i]);
        }
        return lists;
    }

    private void threeSum(int[] nums, int target, int start, int end, List<List<Integer>> lists, int num) {
        if(start >= end - 1) {
            return;
        }
        int max = nums[end];
        if(3 * nums[start] > target || 3 * max < target) {
            return;
        }
        for(int i = start; i < end - 1; i++) {
            if(i > start && nums[i - 1] == nums[i]) {
                continue;
            }
            if(nums[i] + 2 * max < target) {
                continue;
            }
            if(3 * nums[i] > target) {
                break;
            }
            if(3 * nums[i] == target) {
                if(i < end - 1 && nums[i + 2] == nums[i]) {
                    if(!lists.contains(Arrays.asList(num, nums[i], nums[i], nums[i]))) {
                        lists.add(Arrays.asList(num, nums[i], nums[i], nums[i]));
                    }
                }
                break;
            }
            twoSum(nums, target - nums[i], i + 1, end, lists, num, nums[i]);
        }
    }

    private void twoSum(int[] nums, int target, int start, int end, List<List<Integer>> lists, int num1, int num2) {
        if(start >= end) {
            return;
        }
        if(2 * nums[start] > target || 2 * nums[end] < target) {
            return;
        }
        int i = start, j = end;
        while (i < j) {
            if(nums[i] + nums[j] > target) {
                j--;
            } else if(nums[i] + nums[j] < target) {
                i++;
            } else {
                if(!lists.contains(Arrays.asList(num1, num2, nums[i], nums[j]))) {
                    lists.add(Arrays.asList(num1, num2, nums[i], nums[j]));
                }

                int x = nums[i];
                while (++i < j &&  x == nums[j]) ;

                x = nums[j];
                while (i < --j && x == nums[i]) ;
            }
        }
    }
}
