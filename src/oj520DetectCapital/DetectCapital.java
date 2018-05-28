package oj520DetectCapital;

/**
 * Given a word, you need to judge whether the usage of capitals in it is right or not.
 *
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 *
 * All letters in this word are capitals, like "USA".
 * All letters in this word are not capitals, like "leetcode".
 * Only the first letter in this word is capital if it has more than one letter, like "Google".
 * Otherwise, we define that this word doesn't use capitals in a right way.
 * Example 1:
 * Input: "USA"
 * Output: True
 * Example 2:
 * Input: "FlaG"
 * Output: False
 * Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.
 */

public class DetectCapital {
    public boolean detectCapitalUse(String word) {
        if(word.length() <= 1) {
            return true;
        }
        char first_capital = word.charAt(0);
        int len = word.length();
        if(first_capital >= 'a' && first_capital <= 'z') {
            for(int i = 1; i < len; i++) {
                if(word.charAt(i) < 'a') {
                    return false;
                }
            }
        } else {
            char second_capital = word.charAt(1);
            if(second_capital >= 'a' && second_capital <= 'z') {
                for(int i = 2; i < len; i++) {
                    if(word.charAt(i) < 'a') {
                        return false;
                    }
                }
            } else {
                for(int i = 2; i < len; i++) {
                    if(word.charAt(i) > 'Z') {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
