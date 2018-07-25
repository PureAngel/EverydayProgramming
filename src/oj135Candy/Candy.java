package oj135Candy;

import java.util.Arrays;

/**
 * There are N children standing in a line. Each child is assigned a rating value.
 *
 * You are giving candies to these children subjected to the following requirements:
 *
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 *
 * Example 1:
 *
 * Input: [1,0,2]
 * Output: 5
 * Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
 * Example 2:
 *
 * Input: [1,2,2]
 * Output: 4
 * Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
 *              The third child gets 1 candy because it satisfies the above two conditions.
 */

public class Candy {
    public int candy(int[] ratings) {
        int[] count = new int[ratings.length];
        Arrays.fill(count, 1);
        boolean flag = true;
        int sum = 0;
        while (flag) {
            flag = false;
            for(int i = 0; i < ratings.length; i++) {
                if(i > 0 && ratings[i] > ratings[i - 1] && count[i] <= count[i - 1]) {
                    count[i] = count[i - 1] + 1;
                    flag = true;
                }
                if(i < ratings.length - 1 && ratings[i] > ratings[i + 1] && count[i] <= count[i + 1]) {
                    count[i] = count[i + 1] + 1;
                    flag = true;
                }
            }
        }
        for(int i = 0; i < count.length; i++) {
            sum += count[i];
        }
        return sum;
    }
}
