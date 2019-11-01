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
    // Implementation returning current doesn't work because if next is null, it breaks 
    public ListNode reverseListIterative(ListNode head) { 
        ListNode previous = null; 
        ListNode current = head; 
        ListNode next;
        while(current != null) {
            next = current.next; 
            current.next = previous;
            previous = current; 
            current = next; 
        }
        return previous; 
    }
    
    public ListNode reverseListRecursive(ListNode head) {
        // Recursive implementation. Would be same runtime but O(n) space complexity due to stack size. 
        return new ListNode(0); 
    }

    public static void main(String[] args) {
        
    }
}