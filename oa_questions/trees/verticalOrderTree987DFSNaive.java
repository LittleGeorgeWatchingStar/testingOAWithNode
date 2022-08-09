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
    private Queue<int[]> nodeEntries;

    private void DFS(TreeNode node, Integer row, Integer column) {
        if (node == null)
            return;
        nodeEntries.add(new int[]{column, row, node.val});
        // preorder DFS traversal
        this.DFS(node.left, row + 1, column - 1);
        this.DFS(node.right, row + 1, column + 1);
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        nodeEntries = new PriorityQueue<>((e1, e2) -> {
            // 0 - col, 1 - row, 2 - val
            for (int i = 0; i < e1.length; i++) {
                if (e1[i] != e2[i]) return e1[i] - e2[i];
            }
            return 0;
        });
        DFS(root, 0, 0);
        List<List<Integer>> result = new ArrayList();
        
        int currentCol = Integer.MIN_VALUE;
        while(!nodeEntries.isEmpty()) {
            int[] entry = nodeEntries.remove();
            if (entry[0] != currentCol) {
                currentCol = entry[0];
                result.add(new ArrayList<>());
            }
            result.get(result.size() - 1).add(entry[2]);
        }

        return result;
    }
}