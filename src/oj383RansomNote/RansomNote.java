package oj383RansomNote;


import java.util.Arrays;

/**
 * Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
 *
 * Each letter in the magazine string can only be used once in your ransom note.
 *
 * Note:
 * You may assume that both strings contain only lowercase letters.
 *
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 */

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] dictionary = new int[26];
        for(char c: magazine.toCharArray()) {
            dictionary[c - 'a']++;
        }
        for(char c: ransomNote.toCharArray()) {
            dictionary[c - 'a']--;
        }
        for(int i = 0; i < 26; i++) {
            if(dictionary[i] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        String ransomNote = "a";
        String magazine = "b";
        RansomNote r = new RansomNote();
        System.out.println(r.canConstruct(ransomNote, magazine));
    }
}
