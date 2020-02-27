// Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

// (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

// You are given a target value to search. If found in the array return its index, otherwise return -1.

// You may assume no duplicate exists in the array.

// Your algorithm's runtime complexity must be in the order of O(log n).

// Example 1:
// Input: nums = [4,5,6,7,0,1,2], target = 0
// Output: 4

// Example 2:
// Input: nums = [4,5,6,7,0,1,2], target = 3
// Output: -1

class Solution { 
    public static int searchFirstAttempt(int[] nums, int target) {
        int pivot, l = 0, r = nums.length - 1;
        while (l <= r) {
            pivot = l + ((r - l) / 2);
            if (target == nums[pivot]) {
                return pivot;
            } else if (nums[pivot] > nums[r]) {
                // If the pivot is greater than the right, the break in continuity is on the right. 
                // If the target is greater than the pivot or less than the left value. THEN we can prune the left. 
                // We need both of those checks as the right side contains values less than the left as well as 
                //  those greater than the pivot. 
                if (target > nums[pivot] || target < nums[l]) { 
                    l = pivot + 1; 
                } else {
                    r = pivot - 1; 
                }
            } else if (nums[pivot] < nums[l]) { 
                if (target < nums[pivot] || target > nums[r]) { 
                    r = pivot - 1; 
                } else { 
                    l = pivot + 1; 
                }
            } else { 
                // Normal binary search as the left and right values are now valid. 
                if (target < nums[pivot]) { 
                    r = pivot - 1; 
                } else if (target > nums[pivot]) { 
                    l = pivot + 1; 
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] test0array = {4, 5, 6, 7, 0, 1, 2};
        int test0num = 0; 
        System.out.println(searchFirstAttempt(test0array, test0num));

        int[] test1array = {4, 5, 6, 7, 0, 1, 2};
        int test1num = 3; 
        System.out.println(searchFirstAttempt(test1array, test1num));

        int[] test2array = { 0 };
        int test2num = 0;
        System.out.println(searchFirstAttempt(test2array, test2num));

        int[] test3array = { 1, 2, 0 };
        int test3num = 2;
        System.out.println(searchFirstAttempt(test3array, test3num));
    }
}