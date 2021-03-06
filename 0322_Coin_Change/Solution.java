// You are given coins of different denominations and a total amount of money amount. 
// Write a function to compute the fewest number of coins that you need to make up that amount. 
// If that amount of money cannot be made up by any combination of the coins, return -1.

// Example 1:
// Input: coins = [1, 2, 5], amount = 11
// Output: 3 
// Explanation: 11 = 5 + 5 + 1

// Example 2:
// Input: coins = [2], amount = 3
// Output: -1

// Note:
// You may assume that you have an infinite number of each kind of coin.

import java.util.*;
import java.lang.*;

class Solution { 
    public static int coinChangeIterative(int[] coins, int amount) {
        // This is definitely a dp problem. But what do we memoize? 
        // At each value up to the target amount, there is an optimal amount of coins to achieve that amount. 
        // Initialize our memo with the coin denominations and the base amounts. 
        // Looks like the array of coin denominations isn't ordered. This is a lost cause. Trash. 
        // Couldn't do this problem without literally copying the answer. What am I doing? 
        Arrays.sort(coins);
        int[] memo = new int[amount+1]; 
        Arrays.fill(memo, -1); 
        memo[0] = 0; 
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] > amount ) { break; }
            memo[coins[i]] = 1; 
        }
        for (int i = coins[0]; i <= amount; i++) {
            // System.out.println(Arrays.toString(memo));
            // For each amount, we calculate the optimal. 
            for (int j = 0; j < coins.length; j++) {
                // For each coin denomination, we check to see if the amount is reachable by that denomination away. 
                // If there is an optimal result from that coin denomination away. We add 1 to get a new possible result for current amount. 
                // Then we check this against the current amount's optimal result. If it's 0, we insert. If it's not, we compare to see if it's less. 
                if (coins[j] < i) {  
                    if (memo[i - coins[j]] != -1) {
                        if (memo[i] == -1) {
                            memo[i] = memo[i - coins[j]] + 1; 
                        } else {
                            memo[i] = Math.min(memo[i], memo[i - coins[j]] + 1); 
                        }
                    }
                }
            }
        }
        if (memo[amount] != -1) { return memo[amount]; }
        return -1; 
    }

    public static int coinChangeIterativeV2(int[] coins, int amount) {
        int[] memo = new int[amount+1]; 
        // Fill with amount+1, because you can't have more than 1001 coins to get to amount 1000. 
        // It's an arbitrary number that we are using to denote amounts that can't be reached. 
        Arrays.fill(memo, amount+1); 
        memo[0] = 0; 
        for (int i = 1; i <= amount; i++) {
            // System.out.println(Arrays.toString(memo));
            for (int j = 0; j < coins.length; j++) {
                // If coin value is less than our target amount. This check also 
                // covers the corner cases where memo[i - coins[j]] will give us an out of index. 
                if (coins[j] <= i) { 
                    // System.out.println("Coin Value: " + coins[j] + ", Amount: " + i);
                    // System.out.println("memo[i]: " + memo[i]); 
                    // System.out.println("memo[i - coins[j]] + 1: " +  (memo[i - coins[j]] + 1)); 
                    // System.out.println(); 
                    memo[i] = Math.min(memo[i], memo[i - coins[j]] + 1); 
                }
            }
        }
        if (memo[amount] > amount) { 
            return -1; 
        } else { 
            return memo[amount]; 
        }
    }

    public static void main(String[] args) {
        System.out.println("---------------coinChangeIterative---------------");
        System.out.println("Array: {1,2,5} Amount: 11, Expected: 3,  Result: " + coinChangeIterative(new int[] {1,2,5}, 11)); 
        System.out.println("Array: {2}     Amount: 3,  Expected: -1, Result: " + coinChangeIterative(new int[] {2}, 3));
        System.out.println("Array: {1}     Amount: 3,  Expected: 3,  Result: " + coinChangeIterative(new int[] {1}, 3));
        System.out.println("Array: {2}     Amount: 5,  Expected: -1, Result: " + coinChangeIterative(new int[] {2}, 5));
        System.out.println("Array: {1}     Amount: 0,  Expected: 0,  Result: " + coinChangeIterative(new int[] {1}, 0));
        System.out.println("Array: {1,max} Amount: 2,  Expected: 2,  Result: " + coinChangeIterative(new int[] {1,2147483647}, 2)); 
        System.out.println("Array: {474,83,404,3}     Amount: 264,  Expected: 8,  Result: " + coinChangeIterative(new int[] {474,83,404,3}, 8));
        System.out.println("--------------coinChangeIterativeV2--------------");
        System.out.println("Array: {1,2,5} Amount: 11, Expected: 3,  Result: " + coinChangeIterativeV2(new int[] {1,2,5}, 11)); 
        System.out.println("Array: {2}     Amount: 3,  Expected: -1, Result: " + coinChangeIterativeV2(new int[] {2}, 3));
        System.out.println("Array: {1}     Amount: 3,  Expected: 3,  Result: " + coinChangeIterativeV2(new int[] {1}, 3));
        System.out.println("Array: {2}     Amount: 5,  Expected: -1, Result: " + coinChangeIterativeV2(new int[] {2}, 5));
        System.out.println("Array: {1}     Amount: 0,  Expected: 0,  Result: " + coinChangeIterativeV2(new int[] {1}, 0));
        System.out.println("Array: {1,max} Amount: 2,  Expected: 2,  Result: " + coinChangeIterativeV2(new int[] {1,2147483647}, 2)); 
    }
}