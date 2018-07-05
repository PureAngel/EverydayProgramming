package oj014_2nd;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 */

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {

        /* horizontal scanning */
//        if(strs.length == 0) {
//            return "";
//        }
//        String prefix = strs[0];
//        for(int i = 1; i < strs.length; i++) {
//            while (strs[i].indexOf(prefix) != 0) {
//                prefix = prefix.substring(0, prefix.length() - 1);
//                if(prefix.equals("")) {
//                    return "";
//                }
//            }
//        }
//        return prefix;

        /* vertical scanning */
//        if(strs.length == 0) {
//            return "";
//        }
//        for(int i = 0; i < strs[0].length(); i++) {
//            char c = strs[0].charAt(i);
//            for(int j = 1; j < strs.length; j++) {
//                if(i == strs[j].length() || strs[j].charAt(i) != c) {
//                    return strs[0].substring(0, i);
//                }
//            }
//        }
//        return strs[0];

        /* divide & conquer */
        if(strs.length == 0) {
            return "";
        }
        return divide(strs, 0, strs.length - 1);
    }

    private String divide(String[] strs, int left, int right) {
        if(left == right) {
            return strs[left];
        }
        int mid = left + (right - left) / 2;
        String prefix1 = divide(strs, left, mid);
        String prefix2 = divide(strs, mid + 1, right);
        return commonPrefix(prefix1, prefix2);
    }

    private String commonPrefix(String string1, String string2) {
        int minLen = Math.min(string1.length(), string2.length());
        for(int i = 0; i < minLen; i++) {
            if(string1.charAt(i) != string2.charAt(i)) {
                return string1.substring(0, i);
            }
        }
        return string1.substring(0, minLen);
    }
}
