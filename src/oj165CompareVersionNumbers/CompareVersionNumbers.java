package oj165CompareVersionNumbers;

/**
 * Compare two version numbers version1 and version2.
 * If version1 > version2 return 1; if version1 < version2 return -1;otherwise return 0.
 *
 * You may assume that the version strings are non-empty and contain only digits and the . character.
 * The . character does not represent a decimal point and is used to separate number sequences.
 * For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.
 *
 * Example 1:
 *
 * Input: version1 = "0.1", version2 = "1.1"
 * Output: -1
 * Example 2:
 *
 * Input: version1 = "1.0.1", version2 = "1"
 * Output: 1
 * Example 3:
 *
 * Input: version1 = "7.5.2.4", version2 = "7.5.3"
 * Output: -1
 */

public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] str1 = version1.split("\\.");
        String[] str2 = version2.split("\\.");
        if(str1.length < str2.length) {
            int i;
            for(i = 0; i < str1.length; i++) {
                if(Integer.valueOf(str1[i]) < Integer.valueOf(str2[i])) {
                    return -1;
                } else if(Integer.valueOf(str1[i]) > Integer.valueOf(str2[i])) {
                    return 1;
                }
            }
            for(; i < str2.length; i++) {
                if(Integer.valueOf(str2[i]) > 0) {
                    return -1;
                }
            }
        } else if (str1.length > str2.length) {
            int i;
            for(i = 0; i < str2.length; i++) {
                if(Integer.valueOf(str1[i]) < Integer.valueOf(str2[i])) {
                    return -1;
                } else if(Integer.valueOf(str1[i]) > Integer.valueOf(str2[i])) {
                    return 1;
                }
            }
            for(; i < str1.length; i++) {
                if(Integer.valueOf(str1[i]) > 0) {
                    return 1;
                }
            }
        } else {
            for(int i = 0; i < str1.length; i++) {
                if(Integer.valueOf(str1[i]) < Integer.valueOf(str2[i])) {
                    return -1;
                } else if(Integer.valueOf(str1[i]) > Integer.valueOf(str2[i])) {
                    return 1;
                }
            }
        }
        return 0;
    }

    public static void main(String args[]) {
        CompareVersionNumbers compareVersionNumbers = new CompareVersionNumbers();
        String version1 = "0.1";
        String version2 = "1.1";
        System.out.println(compareVersionNumbers.compareVersion(version1,version2));
    }
}
