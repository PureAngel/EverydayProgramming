package oj249GroupShiftedStrings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:
 *
 * "abc" -> "bcd" -> ... -> "xyz"
 * Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.
 *
 * Example:
 *
 * Input: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
 * Output:
 * [
 *   ["abc","bcd","xyz"],
 *   ["az","ba"],
 *   ["acef"],
 *   ["a","z"]
 * ]
 */

public class GroupShiftedStrings {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> lists = new ArrayList<>();
        Map<String, ArrayList<String>> map = new HashMap<>();
        for(String string: strings) {
            char[] chars = string.toCharArray();
            String key = "";
            for(int i = 1; i < chars.length; i++) {
                key += (char)((chars[i] - chars[0] + 26) % 26 + 97);
            }
            if(map.containsKey(key)) {
                map.get(key).add(string);
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(string);
                map.put(key, list);
            }
        }

        for(Map.Entry<String, ArrayList<String>> each: map.entrySet()) {
            lists.add(each.getValue());
        }
        return lists;
    }
}
