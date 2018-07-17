package oj186ReverseWordsInAStringII;

/**
 * Given an input string , reverse the string word by word.
 *
 * Example:
 *
 * Input:  ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
 * Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
 * Note:
 *
 * A word is defined as a sequence of non-space characters.
 * The input string does not contain leading or trailing spaces.
 * The words are always separated by a single space.
 * Follow up: Could you do it in-place without allocating extra space?
 */

public class ReverseWordsInAStringII {
    public void reverseWords(char[] str) {
        // reverse the whole string
        reverse(str, 0, str.length - 1);

        // reverse each word
        int start = 0;
        for(int i = 0; i < str.length; i++) {
            if(str[i] == ' ') {
                reverse(str, start, i - 1);
                start = i + 1;
            }
        }

        // reverse the last word
        reverse(str, start, str.length - 1);
    }

    private void reverse(char[] str, int start, int end) {
        while (start < end) {
            char temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start++;
            end--;
        }
    }
}
