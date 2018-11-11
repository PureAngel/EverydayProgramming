package Contest110;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * You have an array of logs.  Each log is a space delimited string of words.
 *
 * For each log, the first word in each log is an alphanumeric identifier.  Then, either:
 *
 * Each word after the identifier will consist only of lowercase letters, or;
 * Each word after the identifier will consist only of digits.
 * We will call these two varieties of logs letter-logs and digit-logs.  It is guaranteed that each log has at least one word after its identifier.
 *
 * Reorder the logs so that all of the letter-logs come before any digit-log.  The letter-logs are ordered lexicographically ignoring identifier, with the identifier used in case of ties.  The digit-logs should be put in their original order.
 *
 * Return the final order of the logs.
 *
 *
 *
 * Example 1:
 *
 * Input: ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
 * Output: ["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
 *
 *
 * Note:
 *
 * 0 <= logs.length <= 100
 * 3 <= logs[i].length <= 100
 * logs[i] is guaranteed to have an identifier, and a word after the identifier.
 */

public class ReorderLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        List<String> logs_nums = new ArrayList<>();
        List<String> logs_letters = new ArrayList<>();
        for(int i = 0; i < logs.length; i++) {
            String[] logs_array = logs[i].split(" ");
            if(logs_array[1].charAt(0) >= 'a' && logs_array[1].charAt(0) <= 'z') {
                logs_letters.add(logs[i]);
            } else {
                logs_nums.add(logs[i]);
            }
        }
        Collections.sort(logs_letters, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] o1_array = o1.split(" ");
                String[] o2_array = o2.split(" ");
                int len1 = o1_array.length, len2 = o2_array.length;
                if(len1 <= len2) {
                    for(int i = 1; i < len1; i++) {
                        if(o1_array[i].compareTo(o2_array[i]) < 0) {
                            return -1;
                        } else if(o1_array[i].compareTo(o2_array[i]) > 0) {
                            return 1;
                        }
                    }
                    if(len2 > len1) {
                        return -1;
                    } else {
                        return 0;
                    }
                } else {
                    for(int i = 1; i < len2; i++) {
                        if(o1_array[i].compareTo(o2_array[i]) < 0) {
                            return -1;
                        } else if(o1_array[i].compareTo(o2_array[i]) > 0) {
                            return 1;
                        }
                    }
                    return 1;
                }
            }
        });

        String[] result = new String[logs.length];
        int i = 0;
        for(; i < logs_letters.size(); i++) {
            result[i] = logs_letters.get(i);
        }
        for(int j = 0; j < logs_nums.size(); j++) {
            result[i++] = logs_nums.get(j);
        }
        return result;
    }
}
