package oj030SubstringWithConcatenationOfAllWords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
 *
 * Example 1:
 *
 * Input:
 *   s = "barfoothefoobarman",
 *   words = ["foo","bar"]
 * Output: [0,9]
 * Explanation: Substrings starting at index 0 and 9 are "barfoor" and "foobar" respectively.
 * The output order does not matter, returning [9,0] is fine too.
 * Example 2:
 *
 * Input:
 *   s = "wordgoodstudentgoodword",
 *   words = ["word","student"]
 * Output: []
 */

public class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        if(words == null || words.length == 0) {
            return list;
        }
        int len = words[0].length();
        Map<String, Integer> map = new HashMap<>();
        for(String w: words) {
            if(!map.containsKey(w)) {
                map.put(w, 1);
            } else {
                map.put(w, map.get(w) + 1);
            }
        }
        for(int i = 0; i + len * words.length <= s.length(); i++) {
            if(map.containsKey(s.substring(i, i + len))) {
                Map<String, Integer> curMap = new HashMap<>();
                for(int j = 0; j < words.length; j++) {
                    String word = s.substring(i + len * j, i + (j + 1) * len);
                    if(!curMap.containsKey(word)) {
                        curMap.put(word, 1);
                    } else {
                        curMap.put(word, curMap.get(word) + 1);
                    }
                }
                if(curMap.equals(map)) {
                    list.add(i);
                }
            }
        }
        return list;
    }
}
