package oj812LargestTriangleArea;

/**
 * You have a list of points in the plane. Return the area of the largest triangle that can be formed by any 3 of the points.
 *
 * Example:
 * Input: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
 * Output: 2
 * Explanation:
 * The five points are show in the figure below. The red triangle is the largest.
 *
 * Notes:
 *
 * 3 <= points.length <= 50.
 * No points will be duplicated.
 *  -50 <= points[i][j] <= 50.
 * Answers within 10^-6 of the true value will be accepted as correct.
 */

public class LargestTriangleArea {
    public double largestTriangleArea(int[][] points) {
        double area = 0;
        for(int i = 0; i < points.length - 2; i++) {
            for(int j = i + 1; j < points.length - 1; j++) {
                for(int k = j + 1; k < points.length; k++) {
                    area = Math.max(area, area(points[i], points[j], points[k]));
                }
            }
        }
        return area;
    }

    private double area(int[] P, int[] Q, int[] R) { // (px,py), (qx,qy), (rx,ry) --> (px-rx,py-ry), (qx-rx,qy-ry), (0,0)
        return 0.5 * Math.abs(P[0]*Q[1] + Q[0]*R[1] + R[0]*P[1] -P[1]*Q[0] - Q[1]*R[0] - R[1]*P[0]);
    }
}
