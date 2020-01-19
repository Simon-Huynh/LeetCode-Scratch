// Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

// Example:

// Input: [-2,1,-3,4,-1,2,1,-5,4],
// Output: 6
// Explanation: [4,-1,2,1] has the largest sum = 6.
// Follow up:

// If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.


import java.util.*; 
import java.lang.*;

class Solution {
    public static int maxSubArray(int[] nums) {
        // We find the maximum subarray ending at each index as we iterate through array. 
        // SumAt(A[i+1]) = SumAt(A[i]) + A[i+1]. 
        // At each iteration, we are comparing the previous maximum subarray ending at the previous 
        //  element with that same subarray plus the value at the current index. As we do this, we 
        //  compare those two values with the global maximum that we maintain as we iterate. 
        int globalMaxSum = nums[0]; 
        int localMaxSum = nums[0]; 
        for (int i = 1; i < nums.length; i++) {
            // Compare the previous localMaxSum with localMaxSum + nums[i] and nums[i]
            //  Confused me for a sec. But it's because we're looking for the localMaxSum AT THAT INDEX
            //  So the only two possibilities is for it to be the previous sum plus current val, or the current val itself
            localMaxSum = Math.max(nums[i], localMaxSum + nums[i]);
            // Compare the new localMaxSum with the globalMaxSum
            globalMaxSum = Math.max(localMaxSum, globalMaxSum); 
        }
        return globalMaxSum; 
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}