package oj290WordPattern;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a pattern and a string str, find if str follows the same pattern.
 *
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
 *
 * Example 1:
 *
 * Input: pattern = "abba", str = "dog cat cat dog"
 * Output: true
 * Example 2:
 *
 * Input:pattern = "abba", str = "dog cat cat fish"
 * Output: false
 * Example 3:
 *
 * Input: pattern = "aaaa", str = "dog cat cat dog"
 * Output: false
 * Example 4:
 *
 * Input: pattern = "abba", str = "dog dog dog dog"
 * Output: false
 * Notes:
 * You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
 */

public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        String[] strings = str.split(" ");
        Map<Character, String> characterStringMap = new HashMap<>();
        Map<String, Character> stringCharacterMap = new HashMap<>();

        if(pattern.length() != strings.length) {
            return false;
        }

        for(int i = 0; i < pattern.length(); i++) {
            Character c = pattern.charAt(i);
            String string = strings[i];
            if (!characterStringMap.containsKey(c)) {
                if(!stringCharacterMap.containsKey(string)) {
                    characterStringMap.put(c, string);
                    stringCharacterMap.put(string, c);
                } else {
                    return false;
                }
            } else {
                if(!characterStringMap.get(c).equals(string)) {
                    return false;
                }
            }
        }

        return true;
    }
}
