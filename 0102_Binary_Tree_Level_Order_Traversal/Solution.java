import java.util.ArrayList;

// Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

// Example 1:
// Input: root = [3,9,20,null,null,15,7]
// Output: [[3],[9,20],[15,7]]

// Example 2:
// Input: root = [1]
// Output: [[1]]

// Example 3:
// Input: root = []
// Output: []

// Constraints:

// The number of nodes in the tree is in the range [0, 2000].
// -1000 <= Node.val <= 1000

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

import java.util.Queue;
import java.util.LinkedList;

class Solution {
    // So this would be a breadth first search then
    // as bfs explores all neighbor nodes at each depth before moving onto next depth 
    // but that's if we do it iteratively no? There are solutions that use dfs that 
    // work recursively. How does that work? 
    // Solution below uses a depth first search. At each height we're creating a new 
    // list of values. Every node we go to that list within our list, adds a new value 
    // Since we're doing depth first from left -> right, we're maintaining the order. 
    // Although we are not technically visiting each node in level order traversal. 
    public void traverse(TreeNode root, List<List<Integer>> res, int height) { 
        if (root == null) { return; }
        // Make list of integer at each new encounter of height 
        if (height == res.size) { 
            res.add(new List<Integer>());
        }
        res.get(height).add(root.val); 
        traverse(root.left, res, height + 1);
        traverse(root.right, res, height + 1);
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>(); 
        traverse(root, res, 0); 
        return res; 
    }
}