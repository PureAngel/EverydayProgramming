package oj247StrobogrammaticNumberII;

import java.util.ArrayList;
import java.util.List;

/**
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 *
 * Find all strobogrammatic numbers that are of length = n.
 *
 * Example:
 *
 * Input:  n = 2
 * Output: ["11","69","88","96"]
 */

public class StrobogrammaticNumberII {
    public List<String> findStrobogrammatic(int n) {
        List<String> list = new ArrayList<>();
        int[][] rotation = {{0, 0}, {1, 1}, {6, 9}, {8, 8}, {9, 6}};
        helper("", "", rotation, 0, n, list);
        return list;
    }

    private void helper(String prefix, String suffix, int[][] rotation, int count, int n, List<String> list) {
        if(count + 1 == n) {
            list.add(prefix + "0" + suffix);
            list.add(prefix + "1" + suffix);
            list.add(prefix + "8" + suffix);
            return;
        } else if(count == n) {
            list.add(prefix + suffix);
            return;
        } else {
            if(prefix.length() == 0) {
                for(int i = 1; i < rotation.length; i++) {
                    helper(prefix + rotation[i][1], rotation[i][0] + suffix, rotation, count + 2, n, list);
                }
            } else {
                for(int i = 0; i < rotation.length; i++) {
                    helper(prefix + rotation[i][1], rotation[i][0] + suffix, rotation, count + 2, n, list);
                }
            }
        }
    }
}
