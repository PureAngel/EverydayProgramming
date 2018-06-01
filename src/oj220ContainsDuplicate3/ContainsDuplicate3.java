package oj220ContainsDuplicate3;

import java.util.TreeSet;

/**
 * Given an array of integers, find out whether there are two distinct indices i and j in the array such that the absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.
 *
 * Example 1:
 *
 * Input: [1,2,3,1], k = 4, t = 0
 * Output: true
 * Example 2:
 *
 * Input: [1,0,1,1], k = 1, t = 0
 * Output: true
 * Example 3:
 *
 * Input: [4,2], k = 2, t = 1
 * Output: false
 */

public class ContainsDuplicate3 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for(int i = 0; i < nums.length; i++) {
            Long top = set.ceiling((long)nums[i]);
            if(top != null && top <= nums[i] + t) {
                return true;
            }

            Long bottom = set.floor((long)nums[i]);
            if(bottom != null && nums[i] <= bottom + t) {
                return true;
            }

            set.add((long)nums[i]);
            if(set.size() > k) {
                set.remove((long)nums[i - k]);
            }
        }
        return false;
    }

    public static void main(String args[]) {
        ContainsDuplicate3 containsDuplicate3 = new ContainsDuplicate3();
        //int[] nums = {1,5,9,1,5,9};
        int[] nums = {-2147483648,-2147483647};
        System.out.println(containsDuplicate3.containsNearbyAlmostDuplicate(nums,3,3));
    }
}
