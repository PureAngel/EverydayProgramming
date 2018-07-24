package oj447NumberOfBoomerangs;

import java.util.HashMap;
import java.util.Map;

/**
 * Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k) such that the distance between i and j equals the distance between i and k (the order of the tuple matters).
 *
 * Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points are all in the range [-10000, 10000] (inclusive).
 *
 * Example:
 * Input:
 * [[0,0],[1,0],[2,0]]
 *
 * Output:
 * 2
 *
 * Explanation:
 * The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
 */

public class NumberOfBoomerangs {
    public int numberOfBoomerangs(int[][] points) {
        if(points == null || points.length == 0 || points[0].length < 2) {
            return 0;
        }
        int num = points.length;
        int count = 0;
        for(int i = 0; i < num; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for(int j = 0; j < num; j++) {
                if(i == j) {
                    continue;
                }
                int dist = dist(points[i], points[j]);
                if(map.containsKey(dist)) {
                    map.put(dist, map.get(dist) + 1);
                } else {
                    map.put(dist, 1);
                }
            }
            for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
                if(entry.getValue() > 1) {
                    int n = entry.getValue();
                    count += n * (n - 1);
                }
            }
        }
        return count;
    }

    private int dist(int[] a, int[] b) {
        return (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
    }
}
