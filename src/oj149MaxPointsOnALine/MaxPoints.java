package oj149MaxPointsOnALine;

import java.util.HashMap;
import java.util.Map;

/**
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 *
 * Example 1:
 *
 * Input: [[1,1],[2,2],[3,3]]
 * Output: 3
 * Explanation:
 * ^
 * |
 * |        o
 * |     o
 * |  o
 * +------------->
 * 0  1  2  3  4
 * Example 2:
 *
 * Input: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * Output: 4
 * Explanation:
 * ^
 * |
 * |  o
 * |     o        o
 * |        o
 * |  o        o
 * +------------------->
 * 0  1  2  3  4  5  6
 */
public class MaxPoints {
    public int maxPoints(Point[] points) {
        int max = 0, n = points.length;
        for (int i = 0; i < n; i++) {
            Map<String, Integer> map = new HashMap<String, Integer>();
            int dup = 0, local = 0;
            for (int j = i + 1; j < n; j++) {
                int x = points[j].x - points[i].x;
                int y = points[j].y - points[i].y;
                int d = gcd(x, y);
                if (d == 0) {
                    dup++;
                } else {
                    String slope = (x / d) + "_" + (y / d);
                    map.put(slope, map.getOrDefault(slope, 0) + 1);
                    local = Math.max(local, map.get(slope));
                }
            }
            max = Math.max(max, local + dup + 1);
        }
        return max;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
