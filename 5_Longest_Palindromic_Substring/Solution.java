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
        if (s == null || s.length() < 1) { return ""; }
        
        int right = 0; 
        int left = 0; 
        
        for (int i = 0; i < s.length(); i++) {
            int palinLength0 = expandAroundCenter(s, i, i); 
            int palinLength1 = expandAroundCenter(s, i, i + 1); 

            int bestPalindrome = Math.max(palinLength0, palinLength1); 
            if (bestPalindrome > right-left+1) {
                if (bestPalindrome == palinLength0) {
                    // If center one character
                } else if (bestPalindrome == palinLength1) {
                    // If center two characters
                }
            }
        }

        // string babad
        //        01234
        // i is 1, length is 3
        // left = 0, right = 2 

        // string cbbd
        //        0123
        // i is 1 or 2, length is 2
        // left = 1, right = 2

    }

    // Helper function that returns length of the palindrome created from that center. 
    public static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left --; 
            right ++; 
        }
        // Solution says this is right - left - 1. Why? Doesn't index 2 and 0 mean length of palindrome is 3?
        // I see now. It's because if in 012345 and the entire thing is a palindrome, we'll actually end up with 
        // (-1, 6). Because 0 and 5 are going to satisfy the while loop and they will both be incremented/decremented
        // So to account for this, we subtract 2 to the right - left - 1 to account for those two characters. 
        return right - left + 1 - 2;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome(null)); 
        System.out.println(longestPalindrome("")); 
        System.out.println(longestPalindrome("babad")); 
        System.out.println(longestPalindrome("cbbd")); 
        System.out.println(longestPalindrome("bb")); 
        System.out.println(longestPalindrome("bad")); 
        System.out.println(longestPalindrome("badd"));
    }
}