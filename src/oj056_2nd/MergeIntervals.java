package oj056_2nd;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * Example 1:
 *
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 *
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considerred overlapping.
 */

public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> list = new ArrayList<>();
        if(intervals.size() == 0) {
            return list;
        }
        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if(o1.start < o2.start) {
                    return -1;
                } else if(o1.start > o2.start) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for(Interval interval: intervals) {
            if(interval.start <= end) {
                end = Math.max(end, interval.end);
            } else {
                list.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        list.add(new Interval(start, end));
        return list;
    }
}
