import java.util.Arrays;

// Given an integer array nums of size n, return the minimum number of moves required to make all array elements equal.

// In one move, you can increment or decrement an element of the array by 1.

// Example 1:
// Input: nums = [1,2,3]
// Output: 2
// Explanation:
// Only two moves are needed (remember each move increments or decrements one element):
// [1,2,3]  =>  [2,2,3]  =>  [2,2,2]

// Example 2:
// Input: nums = [1,10,2,9]
// Output: 16
 

// Constraints:
// n == nums.length
// 1 <= nums.length <= 105
// -109 <= nums[i] <= 109

class Solution {
    public static int minMoves2(int[] nums) {
        // We can do mean, or we can do the median. 
        // Median. Middle value. 20 40 50 = 40. mean would be 36.667
        // The moves for 40, would be 20 + 10 = 30 
        // Moves for 36.667, would be 16.667 + 3.334 + 13.333 = 33.334
        // How would we prove median is the cohice for all cases? 
        // Let's assume array of sorted nums of length n. 
        //  There is a meet point x that we're going to converge on. This point is between n_0 and n_n. 
        //  So since the 'moves' for both n_0 and n_n to the meet point is the difference between the two numbers, 
        //  Because that value is constant, we can reduce the problem space to n_1 to n_n-1. We do this constantly until 
        //  we hit one number, or two numbers. So the meeting point is that single number, or any point within those two numbers. 
        //  This value IS the median! 
        // We can use this same process to find the amount of moves. 
        Arrays.sort(nums);
        int moves = 0; 
        int start = 0; int end = nums.length - 1; 
        while (start < end) { 
            moves += nums[end] - nums[start]; 
            start ++; 
            end --; 
        }
        return moves;
    }

    public static void main(String[] args) {
        System.out.println(minMoves2(new int[] { 1, 2, 3 }));
        System.out.println(minMoves2(new int[] { 1, 10, 2, 9 }));
        System.out.println(minMoves2(new int[] { 2 }));
    }
}