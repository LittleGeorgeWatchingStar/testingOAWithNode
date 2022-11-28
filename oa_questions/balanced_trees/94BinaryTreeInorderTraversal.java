import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
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
// recursive 
public static class 94BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        return inOrder(root, new ArrayList());
    }

    List<Integer> inOrder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return result;
        }
        inOrder(root.left, result);
        result.add(root.val);
        return inOrder(root.right, result);
    }
}

// iteratively
public static class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList();
            Stack<TreeNode> stack = new Stack();
            while (root != null || !stack.isEmpty()) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                result.add(root.val);
                root = root.right;
            }
            return result;
    }
}