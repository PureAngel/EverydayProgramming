package oj681NextClosestTime;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a time represented in the format "HH:MM", form the next closest time by reusing the current digits. There is no limit on how many times a digit can be reused.
 *
 * You may assume the given input string is always valid. For example, "01:34", "12:09" are all valid. "1:34", "12:9" are all invalid.
 *
 * Example 1:
 *
 * Input: "19:34"
 * Output: "19:39"
 * Explanation: The next closest time choosing from digits 1, 9, 3, 4, is 19:39, which occurs 5 minutes later.  It is not 19:33, because this occurs 23 hours and 59 minutes later.
 * Example 2:
 *
 * Input: "23:59"
 * Output: "22:22"
 * Explanation: The next closest time choosing from digits 2, 3, 5, 9, is 22:22. It may be assumed that the returned time is next day's time since it is smaller than the input time numerically.
 */

public class NextClosestTime {
    public String nextClosestTime(String time) {
        int curTime = Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3));
        Set<Character> set = new HashSet<>();
        for(char c: time.toCharArray()) {
            if(c != ':') {
                set.add(c);
            }
        }
        for(int t = 1; t < 60 * 24; t++) {
            int newTime = curTime + t;
            int hour = newTime / 60;
            int minute = newTime % 60;
            String newTimeStr = "";
            if(minute >= 60) {
                minute -= 60;
                hour += 1;
            }
            if(hour > 24) {
                hour -= 24;
            }
            if(hour < 10) {
                newTimeStr += "0" + Integer.toString(hour) + ":";
            } else {
                newTimeStr += Integer.toString(hour) + ":";
            }
            if(minute < 10) {
                newTimeStr += "0" + Integer.toString(minute);
            } else {
                newTimeStr += Integer.toString(minute);
            }
            int i = 0;
            for(; i < 5; i++) {
                if(i != 2 && !set.contains(newTimeStr.charAt(i))) {
                    break;
                }
            }
            if(i == 5) {
                return newTimeStr;
            }
        }
        return time;
    }

    public static void main(String args[]) {
        String time = "19:34";
        NextClosestTime nextClosestTime = new NextClosestTime();
        System.out.println(nextClosestTime.nextClosestTime(time));
    }
}
