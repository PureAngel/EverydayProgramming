package oj375GuessNumberHigherOrLowerII;

/**
 * We are playing the Guess Game. The game is as follows:
 *
 * I pick a number from 1 to n. You have to guess which number I picked.
 *
 * Every time you guess wrong, I'll tell you whether the number I picked is higher or lower.
 *
 * However, when you guess a particular number x, and you guess wrong, you pay $x. You win the game when you guess the number I picked.
 *
 * Example:
 *
 * n = 10, I pick 8.
 *
 * First round:  You guess 5, I tell you that it's higher. You pay $5.
 * Second round: You guess 7, I tell you that it's higher. You pay $7.
 * Third round:  You guess 9, I tell you that it's lower. You pay $9.
 *
 * Game over. 8 is the number I picked.
 *
 * You end up paying $5 + $7 + $9 = $21.
 * Given a particular n ≥ 1, find out how much money you need to have to guarantee a win.
 */

public class GuessNumberHigherOrLowerII {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        //len = 1, cost = 0
        for(int len = 2; len <= n; len++) {
            for(int i = 1; i <= n - len + 1; i++) {
                int min_cost = Integer.MAX_VALUE;
                for(int pivot = i + (len - 1) / 2; pivot < i + len - 1; pivot++) {
                    int cost = pivot + Math.max(dp[i][pivot - 1], dp[pivot + 1][i + len - 1]);
                    min_cost = Math.min(min_cost, cost);
                }
                dp[i][i + len - 1] = min_cost;
            }
        }
        return dp[1][n];
    }
}
