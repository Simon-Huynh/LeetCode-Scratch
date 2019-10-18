// Reverse a singly linked list.

// Example:
// Input: 1->2->3->4->5->NULL
// Output: 5->4->3->2->1->NULL

// Follow up:
// A linked list can be reversed either iteratively or recursively. Could you implement both?

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class ListNode { 
    int val; 
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode reverseListIterative(ListNode head) {
        // Iterate through linked list, could store values. Iterate through it in reverse, create new one. 
        // Or could just reverse the pointers as we iterate through. Using pointers to keep track of previous and current node. 
        return new ListNode(0); 
    }
    
    public ListNode reverseListRecursive(ListNode head) {
        // Recursively? Call function on the next node until we reach the end. Swap with the previous node. 
        return new ListNode(0); 
    }

    public static void main(String[] args) {
        
    }
}