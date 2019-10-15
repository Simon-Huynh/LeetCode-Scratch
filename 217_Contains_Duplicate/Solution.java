// Given an array of integers, find if the array contains any duplicates.

// Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.

// Example 1: 
// Input: [1,2,3,1]
// Output: true

// Example 2: 
// Input: [1,2,3,4]
// Output: false

// Example 3: 
// Input: [1,1,1,3,3,4,3,2,4,2]
// Output: true

import java.util.HashSet;

class Solution {
    public static boolean containsDuplicateBruteForce(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true; 
                }
            }
        }
        return false; 
    }

    public static boolean containsDuplicateHashSet(int[] nums) {
        HashSet<Integer> hSet = new HashSet<Integer>(); 
        for (int i = 0; i < nums.length; i++) {
            if (hSet.contains(nums[i])) { 
                return true; 
            }
            hSet.add(nums[i]); 
        }
        return false; 
    }

    public static void main(String[] args) {
        int[] test0array0 = {1,2,3,1};
        System.out.println(containsDuplicateBruteForce(test0array0)); 

        int[] test0array1 = {1,2,3,4};
        System.out.println(containsDuplicateBruteForce(test0array1)); 

        int[] test0array2 = {1,1,1,3,3,4,3,2,4,2};
        System.out.println(containsDuplicateBruteForce(test0array2)); 

        int[] test1array0 = {1,2,3,1};
        System.out.println(containsDuplicateHashSet(test1array0)); 

        int[] test1array1 = {1,2,3,4};
        System.out.println(containsDuplicateHashSet(test1array1)); 

        int[] test1array2 = {1,1,1,3,3,4,3,2,4,2};
        System.out.println(containsDuplicateHashSet(test1array2)); 
    }
}