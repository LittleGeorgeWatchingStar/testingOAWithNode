public int[] threeSum(int[] nums, int target) {
    int[] results = new int[3];
    if (nums.length < 3) {
        return nums;
    }

    Arrays.sort(nums);

    for (int i = 0; i < nums.length -2; i++) {
        twoSum(nums[i+1..], target - nums[i]);
        if (twoSum has results) {
            result = {nums[i], (twoSum result)}
        }
    }
    return result;
}
// concept


public int[] threeSum(int[] nums, int target) {
    int[] results = new int[3];
    if (nums.length < 3) {
        return nums;
    }

    Arrays.sort(nums);

    for (int i = 0; i < nums.length -2; i++) {
        int first = i + 1, second = nums.length -1, new_target = target-num[i];
        while (first < second) {
            if (nums[first] + nums[second] == new_target) {
                result[0] = nums[i];
                result[1] = nums[first];
                result[2] = nums[second];
                return result;
            }
            if (nums[first] + nums[second] > new_target) {
                second--;
            }
            if (nums[first] + nums[second] < new_target) {
                first++;
            }
        }
    }
    return result;
}

