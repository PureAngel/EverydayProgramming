package oj015_2nd;

import java.util.*;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 *
 * The solution set must not contain duplicate triplets.
 *
 * Example:
 *
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);

        // record the index of each num
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(!map.containsKey(num)) {
                map.put(num, new ArrayList<>());
                map.get(num).add(i);
            } else {
                map.get(num).add(i);
            }
        }

        for(int i = 0; i < nums.length - 2; i++) {
            if(nums[i] > 0) {
                break;
            }
            // no duplicate
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            for(int j = i + 1; j < nums.length - 1; j++) {
                if(j > i + 1 && nums[j - 1] == nums[j]) {
                    continue;
                }
                int finalNum = -nums[i]-nums[j];
                if(finalNum < nums[j]) {
                    break;
                }
                if(!map.containsKey(finalNum)) {
                    continue;
                }
                for(Integer integer: map.get(finalNum)) {
                    if(integer != i && integer != j) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[integer]);
                        lists.add(list);
                        break;
                    }
                }
            }
        }
        return lists;
    }
}
