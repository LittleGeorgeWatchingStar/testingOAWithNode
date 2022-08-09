public int[] maxSlidingWindow(int[] nums, int k) {
    int n = nums.length;
    if (n == 0) {
        return nums;
    }

    //当前数到自己的左边界的最大值
    int leftMax[] = new int[n];
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
        if (i % k == 0) {
            max = Integer.MIN_VALUE;
        }
        if (max < nums[i]) {
            max = nums[i];
        }
        leftMax[i] = Math.max(nums[i], max);
    }

    //当前数到自己的右边界的最大值
    int rightMax[] = new int[n];
    max = Integer.MIN_VALUE;
    for (int i = n - 1; i >= 0; i--) {
        if (max < nums[i]) {
            max = nums[i];
        }
        rightMax[i] = Math.max(nums[i], max);
        if (i % k == 0) {
            max = Integer.MIN_VALUE;
        }
    }

    int result[] = new int[n - k + 1];
    for (int i = 0; i < result.length; i++) {
        int j = i + k - 1;
        result[i] = Math.max(rightMax[i], leftMax[j]);
    }
    return result;
}
