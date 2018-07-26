package oj084LargestRectangleInHistogram;

/**
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1,
 * find the area of largest rectangle in the histogram.
 *
 * Example:
 *
 * Input: [2,1,5,6,2,3]
 * Output: 10
 */

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        return getArea(heights, 0, heights.length - 1);
    }

    private int getArea(int[] heights, int start, int end) {
        if(start > end) {
            return 0;
        }
        int minIndex = start;
        for(int i = start; i <= end; i++) {
            if(heights[i] < heights[minIndex]) {
                minIndex = i;
            }
        }
        return Math.max(heights[minIndex] * (end - start + 1), Math.max(getArea(heights, start, minIndex - 1), getArea(heights, minIndex + 1, end)));
    }
}
