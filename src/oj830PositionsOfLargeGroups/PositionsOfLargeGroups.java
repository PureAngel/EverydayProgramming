package oj830PositionsOfLargeGroups;

import java.util.ArrayList;
import java.util.List;

/**
 * In a string S of lowercase letters, these letters form consecutive groups of the same character.
 *
 * For example, a string like S = "abbxxxxzyy" has the groups "a", "bb", "xxxx", "z" and "yy".
 *
 * Call a group large if it has 3 or more characters.  We would like the starting and ending positions of every large group.
 *
 * The final answer should be in lexicographic order.
 *
 *
 *
 * Example 1:
 *
 * Input: "abbxxxxzzy"
 * Output: [[3,6]]
 * Explanation: "xxxx" is the single large group with starting  3 and ending positions 6.
 * Example 2:
 *
 * Input: "abc"
 * Output: []
 * Explanation: We have "a","b" and "c" but no large group.
 * Example 3:
 *
 * Input: "abcdddeeeeaabbbcd"
 * Output: [[3,5],[6,9],[12,14]]
 *
 *
 * Note:  1 <= S.length <= 1000
 */

public class PositionsOfLargeGroups {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> lists = new ArrayList<>();
        int start = 0;
        int end = 0;
        for(int i = 1; i < S.length(); i++) {
            if(S.charAt(i) == S.charAt(i - 1)) {
                end = i;
                if(end == S.length() - 1 && end - start + 1 >= 3) {
                    List<Integer> list = new ArrayList<>();
                    list.add(start);
                    list.add(end);
                    lists.add(new ArrayList<>(list));
                }
            } else {
                if(end - start + 1 >= 3) {
                    List<Integer> list = new ArrayList<>();
                    list.add(start);
                    list.add(end);
                    lists.add(new ArrayList<>(list));
                }
                start = end + 1;
                end++;
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        String s = "aaa";
        PositionsOfLargeGroups positionsOfLargeGroups = new PositionsOfLargeGroups();
        List<List<Integer>> lists = positionsOfLargeGroups.largeGroupPositions(s);
        for(int i = 0 ; i < lists.size(); i++) {
            System.out.println(lists.get(i).get(0) + ", " + lists.get(i).get(1));
        }
    }
}
