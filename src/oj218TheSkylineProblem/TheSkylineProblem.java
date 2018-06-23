package oj218TheSkylineProblem;

import java.util.*;

/**
 * https://leetcode.com/problems/the-skyline-problem/description/
 */

public class TheSkylineProblem {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<>();
        List<int[]> height = new ArrayList<>();
        for(int[] b: buildings) {
            height.add(new int[]{b[0], -b[2]}); // record left and right
            height.add(new int[]{b[1], b[2]});
        }

        Collections.sort(height, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        priorityQueue.offer(0);
        int prev = 0;
        for(int[] h: height) {
            if(h[1] < 0) {
                priorityQueue.offer(-h[1]);
            } else {
                priorityQueue.remove(h[1]);
            }
            int curr = priorityQueue.peek();
            if(prev != curr) {
                result.add(new int[]{h[0], curr});
                prev = curr;
            }
        }
        return result;
    }
}
