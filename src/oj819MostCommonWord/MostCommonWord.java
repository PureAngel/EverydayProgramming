package oj819MostCommonWord;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.  It is guaranteed there is at least one word that isn't banned, and that the answer is unique.
 *
 * Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not case sensitive.  The answer is in lowercase.
 *
 *
 *
 * Example:
 *
 * Input:
 * paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
 * banned = ["hit"]
 * Output: "ball"
 * Explanation:
 * "hit" occurs 3 times, but it is a banned word.
 * "ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
 * Note that words in the paragraph are not case sensitive,
 * that punctuation is ignored (even if adjacent to words, such as "ball,"),
 * and that "hit" isn't the answer even though it occurs more because it is banned.
 *
 *
 * Note:
 *
 * 1 <= paragraph.length <= 1000.
 * 1 <= banned.length <= 100.
 * 1 <= banned[i].length <= 10.
 * The answer is unique, and written in lowercase (even if its occurrences in paragraph may have uppercase symbols, and even if it is a proper noun.)
 * paragraph only consists of letters, spaces, or the punctuation symbols !?',;.
 * There are no hyphens or hyphenated words.
 * Words only consist of letters, never apostrophes or other punctuation symbols.
 */

public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        char[] words = paragraph.toCharArray();
        Map<String, Integer> countMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < words.length; i++) {
            if(Character.isLetter(words[i])) {
                sb.append(Character.toLowerCase(words[i]));
            } else {
                if(sb.length() > 0) {
                    String word = sb.toString();
                    countMap.put(word, countMap.getOrDefault(word, 0) + 1);
                }
                sb = new StringBuilder();
            }
        }
        if(sb.length() > 0) {
            String word = sb.toString();
            countMap.put(word, countMap.getOrDefault(word, 0) + 1);
        }
        for(int i = 0; i < banned.length; i++) {
            if(countMap.containsKey(banned[i])) {
                countMap.put(banned[i], 0);
            }
        }
        String word = "";
        int max = 0;
        for(String key: countMap.keySet()) {
            if(max < countMap.get(key)) {
                max = countMap.get(key);
                word = key;
            }
        }
        return word;
    }

    public static void main(String[] args) {
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};
        MostCommonWord mostCommonWord = new MostCommonWord();
        System.out.println(mostCommonWord.mostCommonWord(paragraph, banned));
    }
}
