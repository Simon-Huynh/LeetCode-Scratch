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
        int[] memo = new int[amount+1]; 
        Arrays.fill(memo, -1); 
        memo[0] = 0; 
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] > amount ) { break; }
            memo[coins[i]] = 1; 
        }
        for (int i = coins[0]; i <= amount; i++) {
            System.out.println(Arrays.toString(memo));
            // For each amount, we calculate the optimal. 
            for (int j = 0; j < coins.length; j++) {
                // For each coin denomination, we check to see if the amount is reachable by that denomination away. 
                // If there is an optimal result from that coin denomination away. We add 1 to get a new possible result for current amount. 
                // Then we check this against the current amount's optimal result. If it's 0, we insert. If it's not, we compare to see if it's less. 
                if (memo[i - coins[j]] != -1) {
                    if (memo[i] == -1) {
                        memo[i] = memo[i - coins[j]] + 1; 
                    } else {
                        memo[i] = Math.min(memo[i], memo[i - coins[j]] + 1); 
                    }
                }
            }
        }
        if (memo[amount] != -1) { return memo[amount]; }
        return -1; 
    }

    public static int coinChangeIterativeV2(int[] coins, int amount) {
        int[] memo = new int[amount+1]; 
        Arrays.fill(memo, amount+1); // Fill with amount+1, becaus eyou can't have more than 1001 coins to get to amount 1000. 
        memo[0] = 0; 


        return 0; 
    }

    public static void main(String[] args) {
        System.out.println("Array: {1,2,5} Amount: 11, Expected: 3,  Result: " + coinChangeIterative(new int[] {1,2,5}, 11)); 
        System.out.println("Array: {2}     Amount: 3,  Expected: -1, Result: " + coinChangeIterative(new int[] {2}, 3));
        System.out.println("Array: {1}     Amount: 3,  Expected: 3,  Result: " + coinChangeIterative(new int[] {1}, 3));
        System.out.println("Array: {2}     Amount: 5,  Expected: -1, Result: " + coinChangeIterative(new int[] {2}, 5));
        System.out.println("Array: {1}     Amount: 0,  Expected: 0,  Result: " + coinChangeIterative(new int[] {1}, 0));
        System.out.println("Array: {1,max} Amount: 2,  Expected: 2,  Result: " + coinChangeIterative(new int[] {1,2147483647}, 2)); 
    }
}