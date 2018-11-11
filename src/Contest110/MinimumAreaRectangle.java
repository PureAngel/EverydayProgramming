package Contest110;

import java.util.*;

/**
 * Given a set of points in the xy-plane, determine the minimum area of a rectangle formed from these points, with sides parallel to the x and y axes.
 *
 * If there isn't any rectangle, return 0.
 *
 *
 *
 * Example 1:
 *
 * Input: [[1,1],[1,3],[3,1],[3,3],[2,2]]
 * Output: 4
 * Example 2:
 *
 * Input: [[1,1],[1,3],[3,1],[3,3],[4,1],[4,3]]
 * Output: 2
 *
 *
 * Note:
 *
 * 1 <= points.length <= 500
 * 0 <= points[i][0] <= 40000
 * 0 <= points[i][1] <= 40000
 * All points are distinct.
 */

public class MinimumAreaRectangle {
    public int minAreaRect(int[][] points) {
        int area = Integer.MAX_VALUE;
//        Arrays.sort(points, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                if(o1[0] < o2[0]) {
//                    return -1;
//                } else if(o1[0] > o2[0]) {
//                    return 1;
//                } else {
//                    return o1[1] - o2[1];
//                }
//            }
//        });
//        int[] point1, point2, point3, point4;
//        point1 = point2 = point3 = point4 = new int[]{-1, -1};
//
//        for(int i = 0; i < points.length - 1; i++) {
//            point1 = points[i];
//            for(int j = i + 1; j < points.length; j++) {
//                if(points[j][0] == point1[0] && points[j][1] != point1[1]) {
//                    point2 = points[j];
//                    for(int m = 0; m < points.length; m++) {
//                        if(m != i && m != j) {
//                            if(points[m][0] != point1[0] && points[m][1] == point1[1]) {
//                                point3 = points[m];
//                            } else if(points[m][0] != point1[0] && points[m][1] == point2[1]) {
//                                point4 = points[m];
//                            }
//                        }
//                    }
//                }
//
//                if(point2[0] != -1 && point3[0] != -1 && point4[0] != -1) {
//                    int width = Math.abs(point3[0] - point1[0]), height = Math.abs(point2[1] - point1[1]);
//                    area = Math.min(area, width * height);
//                }
//                point1 = point2 = point3 = point4 = new int[]{-1, -1};
//            }
//        }

        Set<Integer> points_set = new HashSet<>();
        for(int i = 0; i < points.length; i++) {
            points_set.add(40001 * points[i][0] + points[i][1]);
        }

        for(int i = 0; i < points.length - 1; i++) {
            for(int j = i + 1; j < points.length; j++) {
                if(points[i][0] != points[j][0] && points[i][1] != points[j][1]) {
                    if(points_set.contains(40001 * points[i][0] + points[j][1]) && points_set.contains(40001 * points[j][0] + points[i][1])) {
                        area = Math.min(area, Math.abs(points[i][0] - points[j][0]) * Math.abs(points[i][1] - points[j][1]));
                    }
                }
            }
        }

        if(area == Integer.MAX_VALUE) {
            area = 0;
        }

        return area;
    }

    public static void main(String[] args) {
        int[][] points = new int[][]{{1,1},{1,3},{3,1},{3,3},{2,2}};
        MinimumAreaRectangle minimumAreaRectangle = new MinimumAreaRectangle();
        System.out.println(minimumAreaRectangle.minAreaRect(points));
    }
}
