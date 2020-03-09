// Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

// An input string is valid if:

// Open brackets must be closed by the same type of brackets.
// Open brackets must be closed in the correct order.
// Note that an empty string is also considered valid.

// Example 1:
// Input: "()"
// Output: true

// Example 2:
// Input: "()[]{}"
// Output: true

// Example 3:
// Input: "(]"
// Output: false

// Example 4:
// Input: "([)]"
// Output: false

// Example 5:
// Input: "{[]}"
// Output: true

import java.util.*; 
import java.lang.*; 

class Solution {
    public static boolean isValid(String s) {
        // We can have a stack. Iterate through string. If we find a new opening character. We add to the stack. 
        // If we find a closing character, we pop the latest item on the stack if it's a matching opening character. 
        String openingBrackets = "([{"; 
        String closingBrackets = ")]}"; 
        Stack<Character> st = new Stack<Character>(); 
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i); 
            if (openingBrackets.indexOf(currChar) > -1) {
                st.push(currChar); 
            } else if (closingBrackets.indexOf(currChar) > -1) {
                if (st.empty()) { return false; }
                if (closingBrackets.indexOf(currChar) != openingBrackets.indexOf(st.pop())) {
                    return false; 
                }
            }
        }
        if (!st.empty()) {
            return false; 
        }
        return true; 
    }

    public static void main(String[] args) {
        System.out.println("()" + " isValid: " + Boolean.toString(isValid("()"))); 
        System.out.println("()[]{}" + " isValid: " + Boolean.toString(isValid("()[]{}"))); 
        System.out.println("(]" + " isValid: " + Boolean.toString(isValid("(]"))); 
        System.out.println("([)]" + " isValid: " + Boolean.toString(isValid("([)]"))); 
        System.out.println("{[]}" + " isValid: " + Boolean.toString(isValid("{[]}"))); 
        System.out.println("]}" + " isValid: " + Boolean.toString(isValid("]}")));
    }
}