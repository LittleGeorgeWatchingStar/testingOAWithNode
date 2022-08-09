class Solution {
    int n = 10000;
    int maxDepth = 1;
    int[] levelSum = new int[n];

    public void inorder(TreeNode node, int level) {
        if (node != null) {
            maxDepth = Math.max(maxDepth, level);
            inorder(node.left, level + 1);
            levelSum[level] += node.val;
            inorder(node.right, level + 1);
        }
    }
    
    public int maxLevelSum(TreeNode root) {
        inorder(root, 1);

        int maxIdx = 1;
        for (int i = 1; i <= maxDepth; ++i)
            maxIdx = levelSum[i] > levelSum[maxIdx] ? i : maxIdx;
        return maxIdx;
    }
}