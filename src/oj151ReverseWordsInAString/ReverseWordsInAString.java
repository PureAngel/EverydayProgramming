package oj151ReverseWordsInAString;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an input string, reverse the string word by word.
 *
 * Example:
 *
 * Input: "the sky is blue",
 * Output: "blue is sky the".
 * Note:
 *
 * A word is defined as a sequence of non-space characters.
 * Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
 * You need to reduce multiple spaces between two words to a single space in the reversed string.
 */

public class ReverseWordsInAString {
    public String reverseWords(String s) {
        if(s.length() < 1) {
            return s;
        }
        s = s.trim();
        int len = s.length();
        int start = len - 1;
        int end = len;
        List<String> list = new ArrayList<>();
        String reverseS = "";
        while (start >= 0) {
            if(start > 0 && s.charAt(start - 1) != ' ') {
                start--;
            } else {
                list.add(s.substring(start, end));
                end = start - 1;
                start -= 2;
            }
        }
        if(list.size() == 0) {
            return reverseS;
        }
        for(int i = 0; i < list.size() - 1; i++) {
            if(!list.get(i).trim().equals("")) {
                reverseS += list.get(i).trim() + " ";
            }
        }
        reverseS += list.get(list.size() - 1);
        return reverseS;
    }

    public static void main(String args[]) {
        ReverseWordsInAString reverseWordsInAString = new ReverseWordsInAString();
        String s = "   a   b  c d   e  ";
        System.out.println(reverseWordsInAString.reverseWords(s));
    }
}
