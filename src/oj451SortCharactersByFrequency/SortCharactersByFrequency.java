package oj451SortCharactersByFrequency;

import java.util.*;

/**
 * Given a string, sort it in decreasing order based on the frequency of characters.
 *
 * Example 1:
 *
 * Input:
 * "tree"
 *
 * Output:
 * "eert"
 *
 * Explanation:
 * 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 * Example 2:
 *
 * Input:
 * "cccaaa"
 *
 * Output:
 * "cccaaa"
 *
 * Explanation:
 * Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
 * Note that "cacaca" is incorrect, as the same characters must be together.
 * Example 3:
 *
 * Input:
 * "Aabb"
 *
 * Output:
 * "bbAa"
 *
 * Explanation:
 * "bbaA" is also a valid answer, but "Aabb" is incorrect.
 * Note that 'A' and 'a' are treated as two different characters.
 */

public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
//        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
//        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
//            @Override
//            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
//                if(o1.getValue() > o2.getValue()) {
//                    return -1;
//                } else if(o1.getValue() < o2.getValue()) {
//                    return 1;
//                } else {
//                    return 0;
//                }
//            }
//        });
//
//        String result = "";
//        for(int i = 0; i < list.size(); i++) {
//            Character c = list.get(i).getKey();
//            for(int j = 0; j < map.get(c); j++) {
//                result += c;
//            }
//        }
//        String result = "";
//        int max = 0;
//        char curr = ' ';
//        while(map.size() != 0) {
//            for (char c: map.keySet()) {
//                if(map.get(c) > max) {
//                    max = map.get(c);
//                    curr = c;
//                }
//            }
//            for(int i = 0; i < max; i++) {
//                result += curr;
//            }
//            map.remove(curr);
//            max = 0;
//        }
//        return result;
        List<Character>[] lists = new List[s.length() + 1];
        for(char c: map.keySet()) {
            int count = map.get(c);
            if(lists[count] == null) {
                lists[count] = new ArrayList<>();
            }
            lists[count].add(c);
        }
//        String result = "";
//        for(int i = lists.length - 1; i > 0; i--) {
//            if(lists[i] != null) {
//                for(char c: lists[i]) {
//                    for(int j = 0; j < map.get(c); j++) {
//                        result += c;
//                    }
//                }
//            }
//        }
//        return result;
        StringBuilder sb = new StringBuilder();
        for (int pos = lists.length - 1; pos >=0; pos--) {
            if (lists[pos] != null) {
                for (char num : lists[pos]) {
                    for (int i = 0; i < map.get(num); i++) {
                        sb.append(num);
                    }
                }
            }
        }
        return sb.toString();
    }
}
