public int[] maxSlidingWindow(int[] nums, int k) {
    // 建立最大堆
    Queue<Integer> max = new PriorityQueue<Integer>(new Comparator<Integer>() {
        @Override
        public int compare(Integer i1, Integer i2) {
            // TODO Auto-generated method stub
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
        //移除第一个元素
        if (max.size() >= k) {
            max.remove(nums[i - k]);
        }
        max.offer(nums[i]);
        //更新 result
        if (i >= k - 1) {
            result[index++] = max.peek();
        }
    }
    return result;
}
