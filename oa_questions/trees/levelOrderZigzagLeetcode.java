public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> results = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    if (root != null) {
        queue.offer(root);
    }
    boolean isOdd = true;
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
        if (!isOdd) {
            Collections.reverse(oneResult);
        }
        results.add(oneResult);
        isOdd = !isOdd;
        queue = queue2;
    }
    return results;
}
12