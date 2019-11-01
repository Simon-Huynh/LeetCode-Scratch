// Given an array of integers, return indices of the two numbers such that they add up to a specific target.

// You may assume that each input would have exactly one solution, and you may not use the same element twice.

import java.util.Arrays;
import java.lang.Math; 
import java.util.HashMap;

class Solution {
    public static int[] twoSumBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
              if (nums[i] + nums[j] == target) {
                  return new int[]{i, j};
              }
            }
        }
        throw new IllegalArgumentException("No valid solution."); 
    }

    public static int[] twoSumHashTable(int[] nums, int target) {
        HashMap<Integer, Integer> OnePassHashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i]; 
            if (OnePassHashMap.containsKey(complement)) {
                return new int[]{OnePassHashMap.get(complement), i}; 
            }
            OnePassHashMap.put(nums[i], i); 
        }
        throw new IllegalArgumentException("No valid solution."); 
    }

    public static void main(String[] args) {
        int[] test0array0 = {9, 14, 6};
        System.out.println(Arrays.toString(twoSumBruteForce(test0array0, 20)));
        int[] test0array1 = {10, 41, 42};
        System.out.println(Arrays.toString(twoSumBruteForce(test0array1, 52)));

        int[] test1array0 = {9, 14, 6};
        System.out.println(Arrays.toString(twoSumHashTable(test1array0, 20))); 
        int[] test1array1 = {10, 41, 42};
        System.out.println(Arrays.toString(twoSumHashTable(test1array1, 52))); 
    }
}
