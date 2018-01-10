package oj728SelfDividingNumbers;

import java.util.List;
import java.util.LinkedList;

/**
 * A self-dividing number is a number that is divisible by every digit it contains.

 For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.

 Also, a self-dividing number is not allowed to contain the digit zero.

 Given a lower and upper number bound, output a list of every possible self dividing number, including the bounds if possible.

 Example 1:
 Input:
 left = 1, right = 22
 Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
 Note:

 The boundaries of each input argument are 1 <= left <= right <= 10000.

 * Created by xueyingbai on 18/1/10.
 */
public class SelfDividingNumbers {
    public List<Integer> selfDividingNumbers(int left, int right) {
        int first, second, thrid, forth; // from high to low digit
        List<Integer> list = new LinkedList<Integer>();
        for(int i = left; i <= right; i++) {
            first = i / 1000;
            second = i / 100 % 10;
            thrid = i / 10 % 10;
            forth = i % 10;
            if(first != 0 && i % first != 0) {
                continue;
            }
            if(second != 0 && i % second != 0) {
                continue;
            }
            if(thrid != 0 && i % thrid != 0) {
                continue;
            }
            if(forth != 0 && i % forth != 0) {
                continue;
            }
            if(first != 0 && (second == 0 || thrid == 0 || forth == 0)) {
                continue;
            } else if(second != 0 && (thrid == 0 || forth == 0)) {
                continue;
            } else if(thrid != 0 && forth == 0) {
                continue;
            } else {
                list.add(i);
            }
        }
        return list;
    }
}
