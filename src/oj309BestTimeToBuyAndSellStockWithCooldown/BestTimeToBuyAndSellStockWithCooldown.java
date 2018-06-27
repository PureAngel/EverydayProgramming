package oj309BestTimeToBuyAndSellStockWithCooldown;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:
 *
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
 * Example:
 *
 * Input: [1,2,3,0,2]
 * Output: 3
 * Explanation: transactions = [buy, sell, cooldown, buy, sell]
 */

public class BestTimeToBuyAndSellStockWithCooldown {
    public int maxProfit(int[] prices) {
        int sell = 0, pre_sell = 0, buy = Integer.MIN_VALUE, pre_buy;
        for(int price: prices) {
            pre_buy = buy;
            buy = Math.max(pre_buy, pre_sell - price);
            pre_sell = sell;
            sell = Math.max(pre_sell, pre_buy + price);
        }
        return sell;
    }
}
