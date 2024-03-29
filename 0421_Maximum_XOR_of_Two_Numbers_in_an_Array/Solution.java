// Given an integer array nums, return the maximum result of nums[i] XOR nums[j], where 0 ≤ i ≤ j < n.

// Follow up: Could you do this in O(n) runtime?

// Example 1:
// Input: nums = [3,10,5,25,2,8]
// Output: 28
// Explanation: The maximum result is 5 XOR 25 = 28.

// Example 2:
// Input: nums = [0]
// Output: 0

// Example 3:
// Input: nums = [2,4]
// Output: 6

// Example 4:
// Input: nums = [8,10,2]
// Output: 10

// Example 5:
// Input: nums = [14,70,53,83,49,91,36,80,92,51,66,70]
// Output: 127
 

// Constraints:

// 1 <= nums.length <= 2 * 104
// 0 <= nums[i] <= 231 - 1

class Solution {
    public static int findMaximumXOR(int[] nums) {
        return 0; 
    }

    public static void main(String[] args) {
        System.out.println("[3,10,5,25,2,8] result: " + findMaximumXOR(new int[]{3,10,5,25,2,8}));
        System.out.println("[0] result: " + findMaximumXOR(new int[]{0}));
        System.out.println("[2,4] result: " + findMaximumXOR(new int[]{2,4}));
        System.out.println("[8,10,2] result: " + findMaximumXOR(new int[]{8,10,2}));
        System.out.println("[14,70,53,83,49,91,36,80,92,51,66,70] result: " + findMaximumXOR(new int[]{14,70,53,83,49,91,36,80,92,51,66,70}));
    }
}