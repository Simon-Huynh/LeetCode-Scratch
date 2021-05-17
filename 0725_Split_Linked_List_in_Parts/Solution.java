// Given a (singly) linked list with head node root, write a function to split the linked list into k consecutive linked list "parts".

// The length of each part should be as equal as possible: no two parts should have a size differing by more than 1. This may lead to some parts being null.

// The parts should be in order of occurrence in the input list, and parts occurring earlier should always have a size greater than or equal parts occurring later.

// Return a List of ListNode's representing the linked list parts that are formed.

// Examples 1->2->3->4, k = 5 // 5 equal parts [ [1], [2], [3], [4], null ]
// Example 1:
// Input:
// root = [1, 2, 3], k = 5
// Output: [[1],[2],[3],[],[]]
// Explanation:
// The input and each element of the output are ListNodes, not arrays.
// For example, the input root has root.val = 1, root.next.val = 2, \root.next.next.val = 3, and root.next.next.next = null.
// The first element output[0] has output[0].val = 1, output[0].next = null.
// The last element output[4] is null, but it's string representation as a ListNode is [].
// Example 2:
// Input: 
// root = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3
// Output: [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
// Explanation:
// The input has been split into consecutive parts with size difference at most 1, and earlier parts are a larger size than the later parts.
// Note:

// The length of root will be in the range [0, 1000].
// Each value of a node in the input will be an integer in the range [0, 999].
// k will be an integer in the range [1, 50].

import java.io.*;
import java.util.ArrayList; 
import java.lang.*; 

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class HelperClass {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for (int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }

        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String listOfListNodeToString(ListNode[] nodes) { 
        ArrayList<String> output = new ArrayList<String>(); 
        for (int i = 0; i < nodes.length; i++) { 
            output.add(listNodeToString(nodes[i])); 
        }
        return String.join(", ", output);
    }

    public static void main(String[] args) throws IOException {

    }
}

class Solution {
    public static ListNode[] splitListToParts(ListNode root, int k) {
        int count = 0; 
        ListNode temp = root; 
        while (temp != null) { 
            temp = temp.next; 
            count++; 
        }

        int partLength = count / k; 
        int partsToPlusOne = count % k; 

        ListNode[] result = new ListNode[k]; 
        temp = root; 
        for (int i = 0; i < k; i++) {
            ListNode head = temp; 
            int plusOne = (i < partsToPlusOne ? 1 : 0) - 1;
            for (int j = 0; j < partLength + plusOne; j++) { 
                if (temp != null) { temp = temp.next; }
            }
            if (temp != null) { 
                ListNode pre = temp; 
                temp = temp.next; 
                pre.next = null; 
            }
            result[i] = head; 
        }
        return result; 
    }

    public static void main(String[] args) { 
        System.out.println(HelperClass.listOfListNodeToString(
            splitListToParts(HelperClass.stringToListNode("[1,2,3]"), 5)
        ));
        System.out.println("---------------------------------------------------");
        System.out.println(HelperClass.listOfListNodeToString(
            splitListToParts(HelperClass.stringToListNode("[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]"), 3)
        ));
        System.out.println("---------------------------------------------------");
        System.out.println(HelperClass.listOfListNodeToString(
            splitListToParts(HelperClass.stringToListNode("[]"), 1)
        ));
    }
}