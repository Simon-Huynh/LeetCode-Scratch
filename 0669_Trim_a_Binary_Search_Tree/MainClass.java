// Given a binary search tree and the lowest and highest boundaries as L and R, trim the tree so that all its elements lies in [L, R] (R >= L). 
// You might need to change the root of the tree, so the result should return the new root of the trimmed binary search tree.

// Example 1:
// Input: 
//     1
//    / \
//   0   2

//   L = 1
//   R = 2

// Output: 
//     1
//       \
//        2
// Example 2:
// Input: 
//     3
//    / \
//   0   4
//    \
//     2
//    /
//   1

//   L = 1
//   R = 3

// Output: 
//       3
//      / 
//    2   
//   /
//  1

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.lang.Math;

class Solution { 
    public TreeNode trimBST(TreeNode root, int L, int R) {
       if (root == null) { 
           return null; 
       }
       // As we recurse, the root x can be (x < L), (L < x < R), (R < x)
       if (root.val < L) { 
           // If the root is less than L, the node we want is on the right. 
           return trimBST(root.right, L, R); 
       }
       if (root.val > R) { 
           // If root is greater than R, the node we want is in the left. 
           return trimBST(root.left, L, R); 
       }
       // Current node is within the ranges. So we know it doesn't get trimmed. 
       // We then trim the right and left nodes. As we recurse through the tree, 
       // the invalid nodes will be trimmed out by the if statements above. 
       root.left = trimBST(root.left, L, R); 
       root.right = trimBST(root.right, L, R); 
       return root; 
    }
}

public class MainClass {
    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    public static String treeNodeToString(TreeNode root) {
        if (root == null) {
            return "[]";
        }

        String output = "";
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (node == null) {
                output += "null, ";
                continue;
            }

            output += String.valueOf(node.val) + ", ";
            nodeQueue.add(node.left);
            nodeQueue.add(node.right);
        }
        return "[" + output.substring(0, output.length() - 2) + "]";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);
            line = in.readLine();
            int L = Integer.parseInt(line);
            line = in.readLine();
            int R = Integer.parseInt(line);

            TreeNode ret = new Solution().trimBST(root, L, R);

            String out = treeNodeToString(ret);

            System.out.print(out);
        }
    }
}