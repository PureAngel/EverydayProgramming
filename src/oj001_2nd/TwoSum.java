package oj001_2nd;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                if(i != map.get(target - nums[i])) {
                    return new int[]{i, map.get(target - nums[i])};
                }
            }
        }
        return new int[]{0, 0};
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        TwoSum twoSum = new TwoSum();
        int[] res = twoSum.twoSum(nums, 6);
        for(int i = 0; i < 2; i++) {
            System.out.println(res[i]);
        }
    }
}
