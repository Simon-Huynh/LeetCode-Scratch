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

        // If index is 1000, we could treat 0.5 as index, and 999.5 as index. 
        // As we expand around a center or iterate we +- 0.5. 
        if (s == null || s.length < 1) { return ""; }
        int center = 0; 
        int maxLength = 0; 
        for (double i = 0; i < s.length; i=i+0.5){
            double indiceLeft = i-0.5; 
            double indiceRight = i+0.5; 
            if (indiceLeft < 0) {return s.substring()}
            if (i % 1 == 0.5) {
                
            } 
        }
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad")); 

        System.out.println(longestPalindrome("cbbd")); 
    }
}