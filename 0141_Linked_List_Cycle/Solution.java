// Given a linked list, determine if it has a cycle in it.

// To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.

// Example 1:

// Input: head = [3,2,0,-4], pos = 1
// Output: true
// Explanation: There is a cycle in the linked list, where tail connects to the second node.


// Example 2:

// Input: head = [1,2], pos = 0
// Output: true
// Explanation: There is a cycle in the linked list, where tail connects to the first node.


// Example 3:

// Input: head = [1], pos = -1
// Output: false
// Explanation: There is no cycle in the linked list.

import java.io.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Solution {
    public static boolean hasCycle(ListNode head) {
        // How to detect cycle? Could use hashtable on each value as we traverse through 
        //  the linked list. But what if there are two nodes with the same value? Though
        //  a hashtable should be fine if it hashes the ListNode object itself as the next 
        //  pointer would be the differentiator. I remember now. The two pointer solution. 
        //  I totally didn't just kinda peek at a google search. At least I get practice. 
        if (head == null || head.next == null) { 
            return false; 
        }
        ListNode mario = head; 
        ListNode sonic = head.next; 
        while (mario != null || sonic != null) {
            if (mario == sonic) { 
                return true; 
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Weird implementation of the test code. Use leetcode playground for debugging.
    }
}