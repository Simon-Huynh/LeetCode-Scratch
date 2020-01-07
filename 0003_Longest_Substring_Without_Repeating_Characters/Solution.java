// Given a string, find the length of the longest substring without repeating characters.

// Example 1:

// Input: "abcabcbb"
// Output: 3 
// Explanation: The answer is "abc", with the length of 3. 
// Example 2:

// Input: "bbbbb"
// Output: 1
// Explanation: The answer is "b", with the length of 1.
// Example 3:

// Input: "pwwkew"
// Output: 3
// Explanation: The answer is "wke", with the length of 3. 
// Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

import java.util.*; 

class Solution { 
    // Brute Force would be to go through every character in string
    // Keep creating a substring starting from that char until hitting a repeated character or the end
    // Record length at the end of it. Complexity is O(n^2). Each char has potential to go through entire string.
    // My mistake, if we use indexOf to check if char is in string, that makes it potentially O(n^3). 
    public static int lengthOfLongestSubstring(String s) {
        int longestLen = 0; 
        for (int i = 0; i < s.length(); i++) {
            String temp = ""; 
            for (int j = i; j < s.length(); j++) { 
                if (temp.indexOf(s.charAt(j)) == -1) { 
                    temp = temp + s.charAt(j);
                } else {
                    break; 
                }
            }
            if (temp.length() > longestLen) { longestLen = temp.length(); } 
        }
        return longestLen; 
    }

    // Sliding window solution, linear time O(n)
    // Is actually O(2n), O(n) for the i and j traversals of string. 
    // If we increment i, we don't have to reset j, because we've already found a substring 
    // that is larger than the substrings that we missed. 
    public static int lengthOfLongestSubstringWindow(String s) { 
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                // If set does not contain j, increment j to increase sliding window on the right. 
                set.add(s.charAt(j));
                j++; 
                ans = Math.max(ans, j - i);
                System.out.println(set + ", ans: " + ans); 
            } else {
                // If set does contain item j, we've found the largest substring starting from character i. 
                set.remove(s.charAt(i));
                i++; 
                System.out.println(set + ", i removed: " + s.charAt(i-1)); 
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        //  System.out.println("test: " + lengthOfLongestSubstring("test"));            // 3
        //  System.out.println("abcabcbb: " + lengthOfLongestSubstring("abcabcbb"));    // 3 
        //  System.out.println("bbbbb: " + lengthOfLongestSubstring("bbbbb"));          // 1
        //  System.out.println("pwwkew: " + lengthOfLongestSubstring("pwwkew"));        // 3
        System.out.println("test: " + lengthOfLongestSubstringWindow("test")); 
        System.out.println("abcabcbb: " + lengthOfLongestSubstringWindow("abcabcbb")); 
        System.out.println("bbbbb: " + lengthOfLongestSubstringWindow("bbbbb")); 
        System.out.println("pwwkew: " + lengthOfLongestSubstringWindow("pwwkew")); 
        System.out.println("abcaefgh: " + lengthOfLongestSubstringWindow("abcaefgh")); 
        System.out.println("zabcaefgh: " + lengthOfLongestSubstringWindow("zabcaefgh")); 
        System.out.println("zabcaefbgh: " + lengthOfLongestSubstringWindow("zabcaefbgh"));  
    }
}