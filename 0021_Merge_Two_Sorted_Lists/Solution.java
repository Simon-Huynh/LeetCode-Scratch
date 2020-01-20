/* -----------------------------------
 *  WARNING:
 * -----------------------------------
 *  Your code may fail to compile
 *  because it contains public class
 *  declarations.
 *  To fix this, please remove the
 *  "public" keyword from your class
 *  declarations.
 */

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */

import java.io.*; 

class ListNode { 
    int val; 
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    // Time limit exceeded when ran on Leetcode. Ah, when two node values are equal. 
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) { return l2; }
        if (l2 == null) { return l1; }
        ListNode temp, head;
        if (l1.val < l2.val) { 
            head = l1; 
            l1 = l1.next; 
        } else {
            head = l2; 
            l2 = l2.next; 
        }
        temp = head; 
        while (l1 != null || l2 != null) {
            // System.out.println(HelperClass.listNodeToString(head)); 
            // System.out.println("++l1: " + HelperClass.listNodeToString(l1)); 
            // System.out.println("++l2: " + HelperClass.listNodeToString(l2));
            if (l1 == null) { temp.next = l2; break;}
            if (l2 == null) { temp.next = l1; break;}
            if (l1.val < l2.val || l1.val == l2.val) { 
                temp.next = l1; 
                temp = temp.next; 
                l1 = l1.next; 
            } else if (l2.val < l1.val) {
                temp.next = l2; 
                temp = temp.next; 
                l2 = l2.next; 
            }
            // System.out.println("--l1: " + HelperClass.listNodeToString(l1));
            // System.out.println("--l2: " + HelperClass.listNodeToString(l2));
        }
        return head; 
    }

    public static void main(String[] args) {
        System.out.println(HelperClass.listNodeToString(
            mergeTwoLists(HelperClass.stringToListNode("[1,3,5]"), HelperClass.stringToListNode("[2,4,6]"))));
        System.out.println(HelperClass.listNodeToString(
            mergeTwoLists(HelperClass.stringToListNode("[1]"), HelperClass.stringToListNode("[2]"))));
        System.out.println(HelperClass.listNodeToString(
            mergeTwoLists(HelperClass.stringToListNode("[1]"), HelperClass.stringToListNode("[2,4,5,6,7,8]"))));
        System.out.println(HelperClass.listNodeToString(
            mergeTwoLists(HelperClass.stringToListNode("[1,2,4]"), HelperClass.stringToListNode("[1,3,4]"))));
        System.out.println(HelperClass.listNodeToString(
            mergeTwoLists(HelperClass.stringToListNode("[]"), HelperClass.stringToListNode("[]"))));
        System.out.println(HelperClass.listNodeToString(
            mergeTwoLists(HelperClass.stringToListNode("[]"), HelperClass.stringToListNode("[19]"))));
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

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode l1 = stringToListNode(line);
            line = in.readLine();
            ListNode l2 = stringToListNode(line);
            
            ListNode ret = Solution.mergeTwoLists(l1, l2);

            String out = listNodeToString(ret);

            System.out.print(out);
        }
    }
}