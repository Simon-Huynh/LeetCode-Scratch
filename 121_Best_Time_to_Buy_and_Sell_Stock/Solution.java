// Say you have an array for which the ith element is the price of a given stock on day i.

// If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.

// Note that you cannot sell a stock before you buy one.

// Example 1:
// Input: [7,1,5,3,6,4]
// Output: 5
// Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
//              Not 7-1 = 6, as selling price needs to be larger than buying price.

// Example 2: 
// Input: [7,6,4,3,1]
// Output: 0
// Explanation: In this case, no transaction is done, i.e. max profit = 0.


class Solution {
    public static int maxProfitBruteForce(int[] prices) {
        int currentMaxProfit = 0; 
        for (int i = 0; i < prices.length; i++) {
            for (int j = i; j < prices.length; j++) {
                int profit = prices[j] - prices[i]; 
                if (profit > currentMaxProfit) {
                    currentMaxProfit = profit; 
                } 
            }
        }
        return currentMaxProfit; 
    }

    public static int maxProfitOnePass(int[] prices) {
        int minPrice = prices[0]; 
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice; 
            } 
            if (prices[i] < minPrice) {
                minPrice = prices[i]; 
            }
        }
        return maxProfit; 
    }

    public static void main(String []args) {
        int[] test0array0 = {7,1,5,3,6,4}; 
        System.out.println(maxProfitBruteForce(test0array0)); 

        int[] test0array1 = {7,6,4,3,1};
        System.out.println(maxProfitBruteForce(test0array1));

        int[] test1array0 = {7,1,5,3,6,4}; 
        System.out.println(maxProfitOnePass(test1array0)); 

        int[] test1array1 = {7,6,4,3,1};
        System.out.println(maxProfitOnePass(test1array1));
    }
}