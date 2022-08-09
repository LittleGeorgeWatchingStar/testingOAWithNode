public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> results = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    queue.offer(null);
    List<Integer> oneResult = new ArrayList<>();

    while (!queue.isEmpty()) {
        TreeNode top = queue.poll();
        if (top == null) {
            results.add(oneResult);
            if (!queue.isEmpty()) {
                queue.offer(null);
            }
            oneResult = new ArrayList<>();
        } else {
            if (top.left != null) {
                queue.offer(top.left);
            }
            if (top.right != null) {
                queue.offer(top.right);
            }
            oneResult.add(top.val);
        }
    }
    return results;
}