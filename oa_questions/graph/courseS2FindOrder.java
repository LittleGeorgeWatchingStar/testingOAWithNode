public int[] findOrder(int numCourses, int[][] prerequisites) {
    HashMap<Integer, ArrayList<Integer>> outNodes = new HashMap<>();
    HashSet<Integer> set = new HashSet<>();
    int rows = prerequisites.length;
    for (int i = 0; i < rows; i++) {
        int key = prerequisites[i][0];
        int value = prerequisites[i][1];
        set.add(key);
        if (!outNodes.containsKey(key)) {
            outNodes.put(key, new ArrayList<>());
        }
        // 存储当前节点的所有先修课程
        ArrayList<Integer> list = outNodes.get(key);
        list.add(value);
    }

    int[] res = new int[numCourses];
    HashSet<Integer> resSet = new HashSet<>(); //防止重复的节点加入
    HashSet<Integer> visitedFinish = new HashSet<>();
    // 判断每一门课
    for (int k : set) {
        if (!dfs(k, outNodes, new HashSet<>(), visitedFinish, res, resSet)) {
            return new int[0];
        }
        visitedFinish.add(k);
    }
    //和之前一样，把独立的课加入
    for (int i = 0; i < numCourses; i++) {
        if (!resSet.contains(i)) {
            res[count++] = i;
        }
    }
    return res;
}

int count = 0;

private boolean dfs(int start, HashMap<Integer, ArrayList<Integer>> outNodes, HashSet<Integer> visited,
                    HashSet<Integer> visitedFinish, int[] res, HashSet<Integer> resSet) {
    // 已经处理过
    if (visitedFinish.contains(start)) {
        return true;
    }
    //**************主要修改的地方********************//
    // 到了叶子节点
    if (!outNodes.containsKey(start)) {
        if (!resSet.contains(start)) {
            resSet.add(start);
            res[count++] = start;
        }
        return true;
    }
   //**********************************************//
    // 出现了环
    if (visited.contains(start)) {
        return false;
    }
    // 将当前节点加入路径
    visited.add(start);
    ArrayList<Integer> list = outNodes.get(start);
    for (int k : list) {
        if (!dfs(k, outNodes, visited, visitedFinish, res, resSet)) {
            return false;
        }
    }
    //**************主要修改的地方********************//
    if (!resSet.contains(start)) {
        resSet.add(start);
        res[count++] = start;
    }
    //**********************************************//
    visited.remove(start);
    return true;
}
