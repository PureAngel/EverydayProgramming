package oj557ReverseWordsInAStringIII;

/**
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 *
 * Example 1:
 * Input: "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 * Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 */

public class ReverseWordsInAStringIII {
    public String reverseWords(String s) {
        char[] characters = s.toCharArray();

        int start = 0;
        for(int i = 0; i < characters.length; i++) {
            if(characters[i] == ' ') {
                reverseString(characters, start, i - 1);
                start = i + 1;
            }
        }

        reverseString(characters, start, characters.length - 1);

//        for(int i = 0; i < characters.length; i++) {
//            System.out.println(characters[i]);
//        }
//
//        System.out.println(new String(characters));

        return new String(characters);
    }

    private void reverseString(char[] s, int start, int end) {
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        ReverseWordsInAStringIII reverseWordsInAStringIII = new ReverseWordsInAStringIII();
        String s = "Let's take LeetCode contest";
        reverseWordsInAStringIII.reverseWords(s);
    }
}
