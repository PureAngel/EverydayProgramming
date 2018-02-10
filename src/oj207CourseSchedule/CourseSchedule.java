package oj207CourseSchedule;

import java.util.LinkedList;
import java.util.Queue;

/**
 * There are a total of n courses you have to take, labeled from 0 to n - 1.

 Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

 Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

 For example:

 2, [[1,0]]
 There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

 2, [[1,0],[0,1]]
 There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

 Note:
 The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
 You may assume that there are no duplicate edges in the input prerequisites.
 click to show more hints.

 Hints:
 This problem is equivalent to finding if a cycle exists in a directed graph. If a cycle exists, no topological ordering exists and therefore it will be impossible to take all courses.
 Topological Sort via DFS - A great video tutorial (21 minutes) on Coursera explaining the basic concepts of Topological Sort.
 Topological sort could also be done via BFS.

 * Created by xueyingbai on 2/8/18.
 */
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0) {
            return false;
        }
        int[] indegree = new int[numCourses];
        for(int i = 0; i < prerequisites.length; i++) {
            indegree[prerequisites[i][1]]++;
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i = 0; i < indegree.length; i++) {
            if(indegree[i] == 0) {
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()) {
            int x = queue.poll();
            for(int i = 0; i < prerequisites.length; i++) {
                if(prerequisites[i][0] == x) {
                    indegree[prerequisites[i][1]]--;
                    if(indegree[prerequisites[i][1]] == 0) {
                        queue.offer(prerequisites[i][1]);
                    }
                }
            }
        }
        for(int i = 0; i < indegree.length; i++) {
            if(indegree[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
