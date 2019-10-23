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
        ListNode previous = null; 
        ListNode current = head; 
        ListNode next = current != null ? current.next : null; 
        while(next != null) {
            current.next = previous;
            previous = current; 
            current = next; 
            next = next.next;  
            // if (previous != null) { System.out.println("previous " + previous.val); }
            // if (current != null) { System.out.println("current " + current.val); }
            // if (next != null) { System.out.println("next " + next.val); }
            // System.out.println("-------");
        }
        return current; 
    }
    
    public ListNode reverseListRecursive(ListNode head) {
        // Recursively? Call function on the next node until we reach the end. Swap with the previous node. 
        return new ListNode(0); 
    }

    public static void main(String[] args) {
        
    }
}