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

class Solution { 
    // Brute Force would be to go through every character in string
    // Keep creating a substring starting from that char until hitting a repeated character or the end
    // Record length at the end of it. Complexity is O(n^2). Each char has potential to go through entire string.
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

    // How to optimize method above. Dynamic programming. Find a recurrence. 

    public static void main(String[] args) {
         System.out.println("test: " + lengthOfLongestSubstring("test")); 
         System.out.println("abcabcbb: " + lengthOfLongestSubstring("abcabcbb")); 
         System.out.println("bbbbb: " + lengthOfLongestSubstring("bbbbb")); 
         System.out.println("pwwkew: " + lengthOfLongestSubstring("pwwkew")); 
    }
}