package oj022_2nd;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generate(list, n, "", 0, 0);
        return list;
    }

    private void generate(List<String> list, int n, String s, int open, int close) {
        if(s.length() == 2 * n) {
            list.add(s);
        }
        if(open < n) {
            generate(list, n, s + '(', open + 1, close);
        }
        if(close < open) {
            generate(list, n, s + ')', open, close + 1);
        }
    }
}
