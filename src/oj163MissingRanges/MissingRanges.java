package oj163MissingRanges;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted integer array nums, where the range of elements are in the inclusive range [lower, upper], return its missing ranges.
 *
 * Example:
 *
 * Input: nums = [0, 1, 3, 50, 75], lower = 0 and upper = 99,
 * Output: ["2", "4->49", "51->74", "76->99"]
 */

public class MissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> missintRanges = new ArrayList<>();
        int start = lower;
        for(int i = 0; i < nums.length; i++) {
            if(lower == Integer.MAX_VALUE) {
                return missintRanges;
            }
            if(nums[i] < start) {
                continue;
            }
            if(nums[i] == start) {
                start++;
                continue;
            }
            if(start == nums[i] - 1) {
                missintRanges.add(start + "");
            } else {
                missintRanges.add(start + "->" + (nums[i] - 1));
            }
            if(nums[i] == Integer.MAX_VALUE) {
                return missintRanges;
            }
            start = nums[i] + 1;
        }
        if(start < upper) {
            missintRanges.add(start + "->" + upper);
        } else if(start == upper) {
            missintRanges.add(start + "");
        }
        return missintRanges;
    }
}
