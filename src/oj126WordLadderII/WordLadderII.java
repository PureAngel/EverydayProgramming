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

// use bfs to find the shortest distance from beginWord to endWord, and store each node's neighbours.
// use dfs to output paths with the same distance as the shortest distance from distance map.
public class WordLadderII {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        Map<String, List<String>> nodeNeighbors = new HashMap<>();
        Set<String> wordDict = new HashSet<>(wordList);
        Map<String, Integer> distance = new HashMap<>(); // distance from each word to beginWord

        wordDict.add(beginWord);
        bfs(beginWord, endWord, wordDict, nodeNeighbors, distance);
        dfs(beginWord, endWord, wordDict, res, path, nodeNeighbors, distance);

        return res;
    }

    private void bfs(String beginWord, String endWord, Set<String> wordDict, Map<String, List<String>> nodeNeighbors, Map<String, Integer> distance) {
        for(String s: wordDict) {
            nodeNeighbors.put(s, new ArrayList<>());
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        distance.put(beginWord, 0);
        while(!queue.isEmpty()) {
            int count = queue.size();
            boolean foundEnd = false;
            for(int i = 0; i < count; i++) {
                String word = queue.poll();
                List<String> neighbors = getNeighbors(word, wordDict);
                int curDistance = distance.get(word);

                for(String neighbor: neighbors) {
                    nodeNeighbors.get(word).add(neighbor);
                    if(!distance.containsKey(neighbor)) {
                        distance.put(neighbor, curDistance + 1);
                        if(endWord.equals(neighbor)) {
                            foundEnd = true;
                        } else {
                            queue.add(neighbor);
                        }
                    }
                }
            }
            if(foundEnd) {
                break;
            }
        }
    }

    private void dfs(String curWord, String endWord, Set<String> wordDict, List<List<String>> res,
                     List<String> path, Map<String, List<String>> nodeNeighbors, Map<String, Integer> distance) {
        path.add(curWord);
        if(endWord.equals(curWord)) {
            res.add(new ArrayList<>(path));
        } else {
            for(String neighbor: nodeNeighbors.get(curWord)) {
                if(distance.get(neighbor) == distance.get(curWord) + 1) {
                    dfs(neighbor, endWord, wordDict, res, path, nodeNeighbors, distance);
                }
            }
        }
        path.remove(curWord);
    }

    private List<String> getNeighbors(String word, Set<String> wordDict) {
        List<String> neighbors = new ArrayList<>();
        char[] chars = word.toCharArray();
        for(int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            for(char c = 'a'; c <= 'z'; c++) {
                chars[i] = c;
                String newWord = new String(chars);
                if(wordDict.contains(newWord)) {
                    neighbors.add(newWord);
                }
                chars[i] = ch;
            }
        }
        return neighbors;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        String[] strings = new String[]{"hot","dot","dog","lot","log","cog"};
        List<String> wordList = new ArrayList<>(Arrays.asList(strings));
        WordLadderII wordLadderII = new WordLadderII();
        List<List<String>> lists = wordLadderII.findLadders(beginWord, endWord, wordList);
        System.out.println(lists.size());
        for(int i = 0; i < lists.size(); i++) {
            for(int j = 0; j < lists.get(i).size(); j++) {
                System.out.print(lists.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
