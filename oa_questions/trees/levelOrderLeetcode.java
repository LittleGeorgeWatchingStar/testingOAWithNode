public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> results = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    if (root != null) {
        queue.offer(root);
    }
    while (!queue.isEmpty()) {
        List<Integer> oneResult = new ArrayList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        while (!queue.isEmpty()) {
            TreeNode top = queue.poll();
            if (top.left != null) {
                queue2.offer(top.left);
            }
            if (top.right != null) {
                queue2.offer(top.right);
            }
            oneResult.add(top.val);
        }
        results.add(oneResult);
        queue = queue2;
    }
    return results;
}

// [
// [3],
// [9,20],
// [15,7]
// ]