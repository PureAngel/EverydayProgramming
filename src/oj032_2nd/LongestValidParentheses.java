package oj032_2nd;

import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 *
 * Example 1:
 *
 * Input: "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()"
 * Example 2:
 *
 * Input: ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()"
 */

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        /* brute force */
//        int maxLen = 0;
//        for(int i = 0; i < s.length() - 1; i++) {
//            for(int j = i + 1; j < s.length(); j+=2) {
//                if(isValid(s, i ,j)) {
//                    maxLen = Math.max(maxLen, j - i + 1);
//                }
//            }
//        }
//        return maxLen;
        /* dp */
        int maxLen = 0;
        // dp[i]: 以i结尾的最长Valid
        int[] dp = new int[s.length()];
        for(int i = 1; i < dp.length; i++) {
            if(s.charAt(i) == ')') {
                if(s.charAt(i - 1) == '(') {
                    if(i >= 2) {
                        dp[i] = 2 + dp[i - 2];
                    } else {
                        dp[i] = 2;
                    }
                } else if(i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    if(i - dp[i - 1] >= 2) {
                        dp[i] = 2 + dp[i - dp[i - 1] - 2] + dp[i - 1];
                    } else {
                        dp[i] = 2 + dp[i - 1];
                    }
                }
                maxLen = Math.max(maxLen, dp[i]);
            }
        }
        return maxLen;
    }

    private boolean isValid(String s, int start, int end) {
        Stack<Character> stack = new Stack<>();
        for(int i = start; i <= end; i++) {
            char c = s.charAt(i);
            if(c == '(') {
                stack.push(c);
            } else {
                if(!stack.isEmpty() && stack.pop() == '(') {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
