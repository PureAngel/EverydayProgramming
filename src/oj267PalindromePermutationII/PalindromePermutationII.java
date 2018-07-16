package oj267PalindromePermutationII;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, return all the palindromic permutations (without duplicates) of it. Return an empty list if no palindromic permutation could be form.
 *
 * Example 1:
 *
 * Input: "aabb"
 * Output: ["abba", "baab"]
 * Example 2:
 *
 * Input: "abc"
 * Output: []
 */

public class PalindromePermutationII {
    public List<String> generatePalindromes(String s) {
        List<String> list = new ArrayList<>();
        
    }

    private boolean isPalindrom(String s) {
        if(s.length() <= 1) {
            return true;
        }
        int start = 0, end = s.length() - 1;
        while (start < end) {
            if(s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
