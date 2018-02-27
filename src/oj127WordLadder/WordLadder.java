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
        wordList.add(endWord);
        Queue<String> queue = new LinkedList<String>();
        queue.add(beginWord);
        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String cur = queue.remove();
                if(cur.equals(endWord)){ return level + 1;}
                for(int j = 0; j < cur.length(); j++){
                    char[] word = cur.toCharArray();
                    for(char ch = 'a'; ch < 'z'; ch++){
                        word[j] = ch;
                        String check = new String(word);
                        if(!check.equals(cur) && wordList.contains(check)){
                            queue.add(check);
                            wordList.remove(check);
                        }
                    }
                }
            }
            level++;
        }
        return 0;
        /*
        Set<String> reached = new HashSet<String>();
        reached.add(beginWord);
        Set<String> wordDict = new HashSet<String>(wordList);
        wordDict.add(endWord);

        int distance = 1;
        while(!reached.contains(endWord)) {
            Set<String> newSet = new HashSet<String>();
            for(String word: reached) {
                int size = word.length();
                for(int i = 0; i < size; i++) {
                    char[] currentWord = word.toCharArray();
                    for(char c = 'a'; c <= 'z'; c++) {
                        currentWord[i] = c;
                        String newWord = new String(currentWord);
                        if(wordDict.contains(newWord)) {
                            newSet.add(newWord);
                            wordDict.remove(newWord);
                        }
                    }
                }
            }
            distance++;
            if(newSet.size() == 0) {
                return 0;
            }
            reached = newSet;
        }
        return distance;*/
    }
}
