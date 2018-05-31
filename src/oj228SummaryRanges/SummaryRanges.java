package oj228SummaryRanges;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted integer array without duplicates, return the summary of its ranges.
 *
 * Example 1:
 *
 * Input:  [0,1,2,4,5,7]
 * Output: ["0->2","4->5","7"]
 * Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.
 * Example 2:
 *
 * Input:  [0,2,3,4,6,8,9]
 * Output: ["0","2->4","6","8->9"]
 * Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.
 */

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if(nums.length == 0) return list;
        if(nums.length == 1) {
            list.add(nums[0]+"");
            return list;
        }
        int start = nums[0];
        int prev = start;
        int index = 0;
        int end;
        while(index < nums.length - 1) {
            if(nums[index + 1] == prev + 1) {
                index++;
                prev = nums[index];
                if(index == nums.length - 1) {
                    end = prev;
                    list.add(start+"->"+end);
                }
            } else {
                end = prev;
                if(end != start) {
                    list.add(start+"->"+end);
                } else {
                    list.add(start+"");
                }
                start = nums[index + 1];
                prev = start;
                index++;
                if(index == nums.length - 1) {
                    list.add(start+"");
                }
            }
        }
        return list;
    }
    public static void main(String args[]) {
        SummaryRanges summaryRanges = new SummaryRanges();
        int[] nums = {0,2,3,4,6,8,9};
        System.out.println(summaryRanges.summaryRanges(nums));
    }
}
