public int[] maxSlidingWindow(int[] nums, int k) {
    TreeMap<Integer, Integer> treeMap = new TreeMap<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer i1, Integer i2) {
            return i2 - i1;
        }
    });
    int n = nums.length;
    if (n == 0) {
        return nums;
    }
    int result[] = new int[n - k + 1];
    int index = 0;
    for (int i = 0; i < n; i++) {
        //此时不能用 treeMap 的大小和 k 比较, 因为 nums 中有相等的元素
        //当 i >= k 的时候每次都需要删除一个元素
        if (i >= k) {
            Integer v = treeMap.get(nums[i - k]);
            if (v == 1) {
                treeMap.remove(nums[i - k]);
            } else {
                treeMap.put(nums[i - k], v - 1);
            }
        }
        //添加元素
        Integer v = treeMap.get(nums[i]);
        if (v == null) {
            treeMap.put(nums[i], 1);
        } else {
            treeMap.put(nums[i], v + 1);
        }
        //更新 result
        if (i >= k - 1) {
            result[index++] = treeMap.firstKey();
        }
    }
    return result;
}
