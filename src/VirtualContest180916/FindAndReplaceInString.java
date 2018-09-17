package VirtualContest180916;

import java.util.*;

public class FindAndReplaceInString {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        List<int[]> indexList = new ArrayList<>();
        for(int i = 0; i < indexes.length; i++) {
            indexList.add(new int[]{indexes[i], i});
        }
        Collections.sort(indexList, Comparator.comparing(i -> i[0]));

        String output = "";
        int firstIndex = 0;
        for(int[] index: indexList) {
            int i = index[0];
            int i_index = index[1];
            if(i > firstIndex) {
                output += S.substring(firstIndex, i);
                firstIndex = i;
            }
            if(S.substring(i, i + sources[i_index].length()).equals(sources[i_index])) {
                output += targets[i_index];
                firstIndex = i + sources[i_index].length();
            }
        }
        if(firstIndex < S.length()) {
            output += S.substring(firstIndex);
        }

        return output;
    }

    public static void main(String[] args) {
        String S = "jjievdtjfb";
        int[] indexes = {4, 6, 1};
        String[] sources = {"md","tjgb","jf"};
        String[] targets = {"foe","oov","e"};
        FindAndReplaceInString findAndReplaceInString = new FindAndReplaceInString();
        String output = findAndReplaceInString.findReplaceString(S, indexes, sources, targets);
        System.out.println(output);
    }
}
