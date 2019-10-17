// Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

// Example 1:
// Input: "babad"
// Output: "bab"
// Note: "aba" is also a valid answer.

// Example 2:
// Input: "cbbd"
// Output: "bb"

class Solution {
    public static String longestPalindrome(String s) {
        // Could pretend there are gaps in betweeen each character of the string. 
        // Iterate through that new string, and create palindromes as you branch out.
        // Store that index and the length of the palindrome for checking.  

        // Instead of thinking about indexes as being 0, 0.5, and 1, etc...
        // We can treat a palindrome as a pair of indices. This way we can easily 
        // get their length and it supports both even and odd length palindromes.  
        if (s == null || s.length < 1) { return ""; }
        
        int palinLeft = 0; 
        int palinRight = 0; 

        
    }

    // Helper function that returns length of the palindrome created from that center. 
    public static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left --; 
            right ++; 
        }
        return right - left + 1; // Solution says this is right - left - 1. Why? Doesn't index 2 and 0 mean length of palindrome is 3? 
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome(null)); 
        System.out.println(longestPalindrome("babad")); 
        System.out.println(longestPalindrome("cbbd")); 
    }
}