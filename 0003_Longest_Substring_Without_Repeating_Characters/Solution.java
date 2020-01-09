import java.util.HashSet;

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
    // Implement sliding window using hashset. Sliding window is active 
    // until the right boundary reaches the end of string. 
    public static int lengthOfLongestSubstringWindow(String s) { 
        int longest = 0, i = 0, j = 0; 
        int length = s.length(); 
        HashSet<Character> substring = new HashSet<Character>(); 
        while (j < length) {
            if (substring.contains(s.charAt(j))) { 
                substring.remove(s.charAt(i)); 
                i++; 
            } else { 
                substring.add(s.charAt(j)); 
                j++; 
                longest = Math.max(longest, j-i); 
            }
        }
        return longest; 
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