package oj565ArrayNesting;

/**
 * A zero-indexed array A of length N contains all integers from 0 to N-1. Find and return the longest length of set S, where S[i] = {A[i], A[A[i]], A[A[A[i]]], ... } subjected to the rule below.
 *
 * Suppose the first element in S starts with the selection of element A[i] of index = i, the next element in S should be A[A[i]], and then A[A[A[i]]]… By that analogy, we stop adding right before a duplicate element occurs in S.
 *
 * Example 1:
 * Input: A = [5,4,0,3,1,6,2]
 * Output: 4
 * Explanation:
 * A[0] = 5, A[1] = 4, A[2] = 0, A[3] = 3, A[4] = 1, A[5] = 6, A[6] = 2.
 *
 * One of the longest S[K]:
 * S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}
 * Note:
 * N is an integer within the range [1, 20,000].
 * The elements of A are all distinct.
 * Each element of A is an integer within the range [0, N-1].
 */

public class ArrayNesting {
    public int arrayNesting(int[] nums) {
//        if(nums.length <= 1) {
//            return nums.length;
//        }
//        int[] results = new int[nums.length];
//        for(int i = 0; i < nums.length; i++) {
//            int index = i;
//            int current = nums[index];
//            int count = 1;
//            while(current != i) {
//                count++;
//                index = current;
//                current = nums[index];
//            }
//            results[i] = count;
//        }
//        int max = results[0];
//        for(int i = 1; i < results.length; i++) {
//            if(results[i] > max) {
//                max = results[i];
//            }
//        }
//        return max;
        boolean[] visited = new boolean[nums.length];
        int max = 0;
        for(int i = 0; i < nums.length; i++) {
            if(!visited[i]) {
                int count = 0;
                int current = nums[i];
                do {
                    current = nums[current];
                    count++;
                    visited[current] = true;
                } while (current != nums[i]);
                max = Math.max(max, count);
            }
        }
        return max;
    }
}
