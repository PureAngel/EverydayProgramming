package oj291WordPatternII;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a pattern and a string str, find if str follows the same pattern.
 *
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty substring in str.
 *
 * Example 1:
 *
 * Input: pattern = "abab", str = "redblueredblue"
 * Output: true
 * Example 2:
 *
 * Input: pattern = pattern = "aaaa", str = "asdasdasdasd"
 * Output: true
 * Example 3:
 *
 * Input: pattern = "aabb", str = "xyzabcxzyabc"
 * Output: false
 * Notes:
 * You may assume both pattern and str contains only lowercase letters.
 */

public class WordPatternII {
    public boolean wordPatternMatch(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        return isMatch(str, 0, pattern, 0, map, set);
    }

    private boolean isMatch(String str, int i, String pattern, int j, Map<Character, String> map, Set<String> set) {
        if(i == str.length() && j == pattern.length()) {
            return true;
        }
        if(i == str.length() || j == pattern.length()) {
            return false;
        }

        char c = pattern.charAt(j);
        if(map.containsKey(c)) {
            String s = map.get(c);
            if(!str.startsWith(s, i)) {
                return false;
            }
            return isMatch(str, i + s.length(), pattern, j + 1, map, set);
        }

        for(int k = i; k < str.length(); k++) {
            String string = str.substring(i, k + 1);
            if(set.contains(string)) {
                continue;
            }
            map.put(c, string);
            set.add(string);

            if(isMatch(str, k + 1, pattern, j + 1, map, set)) {
                return true;
            }

            map.remove(c);
            set.remove(string);
        }
        return false;
    }
}
