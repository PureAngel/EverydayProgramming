package oj267PalindromePermutationII;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    Set<String> set = new HashSet<>();
    public List<String> generatePalindromes(String s) {
        int[] map = new int[128];
        char[] st = new char[s.length() / 2];
        if(!canPalindrome(s, map)) {
            return new ArrayList<>();
        }
        char c = 0;
        int k = 0;
        for(int i = 0; i < map.length; i++) {
            if(map[i] % 2 == 1) {
                c = (char)i;
            }
            for(int j = 0; j < map[i] / 2; j++) {
                st[k++] = (char)i;
            }
        }
        permute(st, 0, c);
        return new ArrayList<>(set);
    }

    private void permute(char[] s, int len, char c) {
        if(s.length == len) {
            set.add(new String(s) + (c == 0 ? "" : c) + new StringBuffer(new String(s)).reverse());
        } else {
            for(int i = len; i < s.length; i++) {
                if(s[i] != s[len] || i == len) {
                    swap(s, i, len);
                    permute(s, len + 1, c);
                    swap(s, i, len);
                }
            }
        }
    }

    private boolean canPalindrome(String s, int[] map) {
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            map[s.charAt(i)]++;
            if(map[s.charAt(i)] % 2 != 0) {
                count++;
            } else {
                count--;
            }
        }
        return count <= 1;
    }

    private void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

    public static void main(String[] args) {
        String s = "aabb";
        PalindromePermutationII palindromePermutationII = new PalindromePermutationII();
        List<String> list = palindromePermutationII.generatePalindromes(s);
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
