// Given a collection of intervals, merge all overlapping intervals.

// Example 1: 
// Input: [[1,3],[2,6],[8,10],[15,18]]
// Output: [[1,6],[8,10],[15,18]]
// Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

// Example 2: 
// Input: [[1,4],[4,5]]
// Output: [[1,5]]
// Explanation: Intervals [1,4] and [4,5] are considered overlapping

import java.util.*; 
import java.lang.*; 

class Solution { 
    public static int[][] merge(int[][] intervals) {
        // I don't think we can assume that the intervals are sorted by their first point. 
        // If we have sorted intervals [a1, b1] and [a2, b2] where a1 <= a1. They are 
        // overlapping if b1 is within the interval [a2, b2] inclusive. So if we do a sort on the 
        // collection based on the starting index of the intervals. Then we can just iterate through 
        // the sorted array of intervals and merge the ones based on conditions defined above. 
        
        // First just use a collection library to sort. See if we can make it work. 
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]); 
            }
        }); 
        return intervals; 
    }

    public static String int2dArrayToString(int[][] array) {
        if (array == null) {
            return "null";
        }
        if (array.length == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");
        for (int[] item : array) {
            sb.append(Arrays.toString(item));
            sb.append(",");
        }

        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static void main(String[] args) {
        int[][] test0 = {{1,3},{8,10},{2,6},{15,18}};
        System.out.println(int2dArrayToString(merge(test0)));
    }
}