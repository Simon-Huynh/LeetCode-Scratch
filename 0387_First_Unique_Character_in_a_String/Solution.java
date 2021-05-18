// Given a string s, return the first non-repeating character in it and return its index. If it does not exist, return -1.

// Example 1:
// Input: s = "leetcode"
// Output: 0

// Example 2:
// Input: s = "loveleetcode"
// Output: 2

// Example 3:
// Input: s = "aabb"
// Output: -1
 
// Constraints:
// 1 <= s.length <= 105
// s consists of only lowercase English letters.

import java.util.HashMap; 

class Solution {
    // Not the fastest run ever. But it works. 
    public static int firstUniqChar(String s) {
        HashMap<Character, Integer> freqMap = new HashMap<Character, Integer>(); 
        for (int i = 0; i < s.length(); i++) { 
            Character current = s.charAt(i); 
            if (freqMap.containsKey(current)) { 
                freqMap.put(current, freqMap.get(current) + 1); 
            } else { 
                freqMap.put(current, 1); 
            }
        }
        for (int i = 0; i < s.length(); i++) {
            Character current = s.charAt(i); 
            if (freqMap.get(current) == 1) { 
                return i; 
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String test0 = "leetcode"; 
        System.out.println(firstUniqChar(test0));
        String test1 = "loveleetcode";
        System.out.println(firstUniqChar(test1));
        String test2 = "aabb"; 
        System.out.println(firstUniqChar(test2));
    }
}