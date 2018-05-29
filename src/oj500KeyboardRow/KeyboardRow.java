package oj500KeyboardRow;

import java.util.*;

/**
 * Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.
 * Example 1:
 * Input: ["Hello", "Alaska", "Dad", "Peace"]
 * Output: ["Alaska", "Dad"]
 * Note:
 * You may use one character in the keyboard more than once.
 * You may assume the input string will only contain letters of alphabet.
 */

public class KeyboardRow {
    public String[] findWords(String[] words) {
        List<String> list = new ArrayList<>();
        for(String word: words) {
            if(isValid(word)) {
                list.add(word);
            }
        }
        String[] result = new String[list.size()];
        for(int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private boolean isValid(String word) {
        Set<Character> set1 = new HashSet<>(Arrays.asList('q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'));
        Set<Character> set2 = new HashSet<>(Arrays.asList('a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'));
        Set<Character> set3 = new HashSet<>(Arrays.asList('z', 'x', 'c', 'v', 'b', 'n', 'm'));
        boolean[] flag = new boolean[3];
        for(int i = 0; i < 3; i++) {
            flag[i] = true;
        }
        for(char c: word.toLowerCase().toCharArray()) {
            if(!set1.contains(c)) {
                flag[0] = false;
            }
            if(!set2.contains(c)) {
                flag[1] = false;
            }
            if(!set3.contains(c)) {
                flag[2] = false;
            }
        }
        return flag[0] || flag[1] || flag[2];
    }
}
