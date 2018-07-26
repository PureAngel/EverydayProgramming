package oj140WordBreakII;

import java.util.*;

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.
 *
 * Note:
 *
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * Example 1:
 *
 * Input:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * Output:
 * [
 *   "cats and dog",
 *   "cat sand dog"
 * ]
 * Example 2:
 *
 * Input:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * Output:
 * [
 *   "pine apple pen apple",
 *   "pineapple pen apple",
 *   "pine applepen apple"
 * ]
 * Explanation: Note that you are allowed to reuse a dictionary word.
 * Example 3:
 *
 * Input:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output:
 * []
 */

public class WordBreakII {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        return word_break(s, wordSet, 0);
    }

    Map<Integer, List<String>> map = new HashMap<>();

    private List<String> word_break(String s, Set<String> wordSet, int start) {
        if(map.containsKey(start)) {
            return map.get(start);
        }
        List<String> res = new ArrayList<>();
        if(start == s.length()) {
            res.add("");
        }
        for(int end = start + 1; end <= s.length(); end++) {
            if(wordSet.contains(s.substring(start, end))) {
                List<String> list = word_break(s, wordSet, end);
                for(String string: list) {
                    if(string.equals("")) {
                        res.add(s.substring(start, end));
                    } else {
                        res.add(s.substring(start, end) + " " + string);
                    }
                }
            }
        }
        map.put(start, res);
        return res;
    }
}
