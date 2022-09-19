public Node cloneGraph(Node node) {
    if (node == null) {
        return node;
    }
    //第一次 BFS
    Queue<Node> queue = new LinkedList<>();
    Map<Integer, Node> map = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    queue.offer(node);
    visited.add(node.val);
    while (!queue.isEmpty()) {
        Node cur = queue.poll();
        //生成每一个节点
        Node n = new Node();
        n.val = cur.val;
        n.neighbors = new ArrayList<Node>();
        map.put(n.val, n);
        for (Node temp : cur.neighbors) {
            if (visited.contains(temp.val)) {
                continue;
            }
            queue.offer(temp);
            visited.add(temp.val);
        }
    }

    //第二次 BFS 更新所有节点的 neightbors
    queue = new LinkedList<>();
    queue.offer(node);
    visited = new HashSet<>();
    visited.add(node.val);
    while (!queue.isEmpty()) {
        Node cur = queue.poll();
        for (Node temp : cur.neighbors) {
            map.get(cur.val).neighbors.add(map.get(temp.val));
        }
        for (Node temp : cur.neighbors) {
            if (visited.contains(temp.val)) {
                continue;
            }
            queue.offer(temp);
            visited.add(temp.val);
        }
    }
    return map.get(node.val);
}
