// Given a sorted (in ascending order) integer array nums of n elements and a target value, write a function to search target in nums. If target exists, then return its index, otherwise return -1.

// Example 1:
// Input: nums = [-1,0,3,5,9,12], target = 9
// Output: 4
// Explanation: 9 exists in nums and its index is 4

// Example 2:
// Input: nums = [-1,0,3,5,9,12], target = 2
// Output: -1
// Explanation: 2 does not exist in nums so return -1
 

// Note:

// You may assume that all elements in nums are unique.
// n will be in the range [1, 10000].
// The value of each element in nums will be in the range [-9999, 9999].

import java.util.*; 

class Solution { 
    public static int search(int[] nums, int target) {
        int pivot, l = 0, r = nums.length - 1; 
        while (l <= r) { 
            // If the sum of r and l is greater than maximum value of integer, we have a bug and unexpected behavior occurs. 
            // To get around this, we do l + ((r - l) / 2). r - l is the length of the array, / 2 to get middle. Add to left index. 
            pivot = l + ((r - l) / 2);
            if (target == nums[pivot]) {
                return pivot;
            } else if (target < nums[pivot]) {
                r = pivot - 1;
            } else if (target > nums[pivot]) {
                l = pivot + 1;
            }
        }
        return -1; 
    }

    public static void main(String[] args) {
        int[] test0array = {-1,0,3,5,9,12}; 
        int test0target = 9; 
        System.out.println(Arrays.toString(test0array) + ", target: " + test0target + " at index: " + search(test0array, test0target)); 

        int[] test1array = {-1,0,3,5,9,12}; 
        int test1target = 2; 
        System.out.println(Arrays.toString(test1array) + ", target: " + test1target + " at index: " + search(test1array, test1target));

        int[] test2array = {0}; 
        int test2target = 0; 
        System.out.println(Arrays.toString(test2array) + ", target: " + test2target + " at index: " + search(test2array, test2target));

        int[] test3array = {};
        int test3target = 0;
        System.out.println(Arrays.toString(test3array) + ", target: " + test3target + " at index: " + search(test3array, test3target));
    }
}