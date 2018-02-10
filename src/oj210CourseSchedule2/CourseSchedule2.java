package oj210CourseSchedule2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * There are a total of n courses you have to take, labeled from 0 to n - 1.

 Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

 Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

 There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

 For example:

 2, [[1,0]]
 There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1]

 4, [[1,0],[2,0],[3,1],[3,2]]
 There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. So one correct course order is [0,1,2,3]. Another correct ordering is[0,2,1,3].

 Note:
 The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
 You may assume that there are no duplicate edges in the input prerequisites.
 click to show more hints.

 Hints:
 This problem is equivalent to finding the topological order in a directed graph. If a cycle exists, no topological ordering exists and therefore it will be impossible to take all courses.
 Topological Sort via DFS - A great video tutorial (21 minutes) on Coursera explaining the basic concepts of Topological Sort.
 Topological sort could also be done via BFS.

 * Created by xueyingbai on 2/8/18.
 */
public class CourseSchedule2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(numCourses == 0) {
            return new int[0];
        }
        int[] indegree = new int[numCourses];
        for(int i = 0; i < prerequisites.length; i++) {
            indegree[prerequisites[i][0]]++;
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(int i = 0; i < indegree.length; i++) {
            if(indegree[i] == 0) {
                queue.offer(i);
                res.add(i);
            }
        }
        while(!queue.isEmpty()) {
            int x = queue.poll();
            for(int i = 0; i < prerequisites.length; i++) {
                if(prerequisites[i][1] == x) {
                    indegree[prerequisites[i][0]]--;
                    if(indegree[prerequisites[i][0]] == 0) {
                        queue.offer(prerequisites[i][0]);
                        res.add(prerequisites[i][0]);
                    }
                }
            }
        }
        for(int i = 0; i < indegree.length; i++) {
            if(indegree[i] != 0) {
                return new int[0];
            }
        }
        int size = res.size();
        System.out.println(size);
        int[] result = new int[size];
        for(int i = 0; i < size; i++) {
            result[i] = res.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        CourseSchedule2 courseSchedule2 = new CourseSchedule2();
        int[][] prerequisites = new int[1][2];
        prerequisites[0][0] = 1;
        prerequisites[0][1] = 0;
        int[] result = courseSchedule2.findOrder(2, prerequisites);
        for(int i = 0; i < result.length; i++) {
            System.out.println(i+":"+result[i]);
        }

    }
}
