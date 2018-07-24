package oj126WordLadderII;

import java.util.*;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:
 *
 * Only one letter can be changed at a time
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * Note:
 *
 * Return an empty list if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * Example 1:
 *
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * Output:
 * [
 *   ["hit","hot","dot","dog","cog"],
 *   ["hit","hot","lot","log","cog"]
 * ]
 * Example 2:
 *
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * Output: []
 *
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */

public class WordLadderII {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> lists = new ArrayList<>();
        List<String> list = new ArrayList<>();
        list.add(beginWord);
        wordList.add(endWord);
        backtrack(lists, list, new HashSet<>(wordList), endWord);
        return lists;
    }

    private void backtrack(List<List<String>> lists, List<String> list, Set<String> wordDict, String endWord) {
        if(list.contains(endWord)) {
            lists.add(list);
        } else {
            for(int i = 0; i < list.size(); i++) {
                char[] chars = list.get(i).toCharArray();
                for(int j = 0; j < chars.length; j++) {
                    for(char c = 'a'; c <= 'z'; c++) {
                        char ch = chars[j];
                        chars[j] = c;
                        String word = new String(chars);
                        if(wordDict.contains(word)) {
                            list.add(word);
                            wordDict.remove(word);
                            backtrack(lists, list, wordDict, endWord);
                            list.remove(word);
                            wordDict.add(word);
                        } else {
                            chars[j] = ch;
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        String[] strings = new String[]{"hot","dot","dog","lot","log"};
        List<String> wordList = new ArrayList<>(Arrays.asList(strings));
        WordLadderII wordLadderII = new WordLadderII();
        List<List<String>> lists = wordLadderII.findLadders(beginWord, endWord, wordList);
        for(int i = 0; i < lists.size(); i++) {
            for(int j = 0; j < lists.get(i).size(); j++) {
                System.out.print(lists.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
