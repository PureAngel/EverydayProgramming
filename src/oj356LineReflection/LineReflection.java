package oj356LineReflection;

import java.util.HashSet;
import java.util.Set;

/**
 * Given n points on a 2D plane, find if there is such a line parallel to y-axis that reflect the given points.
 *
 * Example 1:
 * Given points = [[1,1],[-1,1]], return true.
 *
 * Example 2:
 * Given points = [[1,1],[-1,-1]], return false.
 *
 * Follow up:
 * Could you do better than O(n2)?
 *
 * Credits:
 * Special thanks to @memoryless for adding this problem and creating all test cases.
 */

public class LineReflection {
    public boolean isReflected(int[][] points) {
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int sum;

        Set<String> set = new HashSet<>();
        for(int[] point: points) {
            minX = Math.min(minX, point[0]);
            maxX = Math.max(maxX, point[0]);
            set.add(point[0] + "," + point[1]);
        }

        sum = maxX + minX;
        for(int[] point: points) {
            String s = (sum - point[0]) + "," + point[1];
            if(!set.contains(s)) {
                return false;
            }
        }
        return true;
    }
}
