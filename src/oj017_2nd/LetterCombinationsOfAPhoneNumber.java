package oj017_2nd;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a digit string,
 * return all possible letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 *
 * 1       2(abc) 3(def)
 * 4(ghi)  5(jkl) 6(mno)
 * 7(pqrs) 8(tuv) 9(wxyz)
 *
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * Note:
 * Although the above answer is in lexicographical order,
 * your answer could be in any order you want.
 */

 public class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> list = new LinkedList<>();
        String[] keys = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        list.add("");
        for(int i = 0; i < digits.length(); i++) {
            int index = digits.charAt(i) - '0';
            while (list.peek().length() == i) {
                String temp = list.poll();
                for(char c: keys[index].toCharArray()) {
                    list.add(temp + c);
                }
            }
        }
        if(list.peek().equals("")) {
            list.poll();
        }
        return list;
    }
}
