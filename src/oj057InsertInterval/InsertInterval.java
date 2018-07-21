package oj057InsertInterval;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 *
 * You may assume that the intervals were initially sorted according to their start times.
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 * Example 2:
 *
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 */

public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if(intervals.size() == 0) {
            intervals.add(newInterval);
            return intervals;
        }
        // sort by start
        sort(intervals);
        for(int i = 0; i < intervals.size(); i++) {
            if(newInterval.start > intervals.get(i).end) {
                continue;
            }
            if(newInterval.end < intervals.get(i).start) {
                intervals.add(newInterval);
                sort(intervals);
                return intervals;
            }
            if(newInterval.end <= intervals.get(i).end) {
                if(newInterval.start >= intervals.get(i).start) {
                    sort(intervals);
                    return intervals;
                } else {
                    Interval interval = intervals.remove(i);
                    newInterval.end = interval.end;
                }
            } else {
                newInterval.start = newInterval.start < intervals.get(i).start ? newInterval.start : intervals.get(i).start;
                intervals.remove(i);
                for(int j = i; j < intervals.size(); j++) {
                    if(newInterval.end < intervals.get(j).start) {
                        intervals.add(newInterval);
                        sort(intervals);
                        return intervals;
                    }
                    if(newInterval.end >= intervals.get(j).end) {
                        intervals.remove(j);
                        j--;
                    } else {
                        newInterval.end = intervals.get(j).end;
                        intervals.remove(j);
                        intervals.add(newInterval);
                        sort(intervals);
                        return intervals;
                    }
                }
            }
        }
        intervals.add(newInterval);
        sort(intervals);
        return intervals;
    }

    private void sort(List<Interval> intervals) {
        // sort by start
        Collections.sort(intervals, new Comparator<Interval>() {
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
    }
}
