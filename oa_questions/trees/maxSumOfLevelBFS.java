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
class Solution {
    public int maxLevelSum(TreeNode root) {
        int currLevel = 1, maxLevel = 1;
        int maxSum = root.val, currSum = 0;

        LinkedList<TreeNode> queue = new LinkedList();
        TreeNode marker = null, x = root;
        queue.addLast(root);
        queue.addLast(marker);

        while (queue.size() > 1) {
            x = queue.removeFirst();
            // continue current level
            if (x != marker) {
                currSum += x.val;
                if (x.left != null) queue.addLast(x.left);
                if (x.right != null) queue.addLast(x.right);
            } else {
                // end of current level, go to the next level
                if (currSum > maxSum) {
                    maxSum = currSum;
                    maxLevel = currLevel;
                }
                currSum = 0;
                currLevel++;
                queue.addLast(marker);
            }
        }
        
        if (currSum > maxSum) {
            maxLevel = currLevel;
        }

        return maxLevel;
    }
}