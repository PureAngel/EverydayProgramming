package oj127WordLadder;

import java.util.*;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

 Only one letter can be changed at a time.
 Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 For example,

 Given:
 beginWord = "hit"
 endWord = "cog"
 wordList = ["hot","dot","dog","lot","log","cog"]
 As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 return its length 5.

 Example 2:

 Input:
 beginWord = "hit"
 endWord = "cog"
 wordList = ["hot","dot","dog","lot","log"]

 Output: 0

 Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.

 Note:
 Return 0 if there is no such transformation sequence.
 All words have the same length.
 All words contain only lowercase alphabetic characters.
 You may assume no duplicates in the word list.
 You may assume beginWord and endWord are non-empty and are not the same.
 UPDATE (2017/1/20):
 The wordList parameter had been changed to a list of strings (instead of a set of strings). Please reload the code definition to get the latest changes.

 * Created by xueyingbai on 2/10/18.
 */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> reached = new HashSet<>();
        reached.add(beginWord);
        Set<String> wordDict = new HashSet<>(wordList);
        int distance = 1;
        while (!reached.contains(endWord)) {
            Set<String> toAdd = new HashSet<>();
            for(String each: reached) {
                for(int i = 0; i < each.length(); i++) {
                    char[] chars = each.toCharArray();
                    for(char c = 'a'; c <= 'z'; c++) {
                        chars[i] = c;
                        String word = new String(chars);
                        if(wordDict.contains(word)) {
                            toAdd.add(word);
                            wordDict.remove(word);
                        }
                    }
                }
            }
            distance++;
            if(toAdd.size() == 0) {
                return 0;
            }
            reached = toAdd;
        }
        return distance;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        String[] strings = new String[]{"hot","dot","dog","lot","log"};
        List<String> wordList = new ArrayList<>(Arrays.asList(strings));
        WordLadder wordLadder = new WordLadder();
        System.out.println(wordLadder.ladderLength(beginWord, endWord, wordList));
    }
}
