public void oddEvenSort(int[] nums) {
    int first = 0, second = nums.length - 1;
    while (first < second) {
        while (first < second && nums[first] % 2 == 1) {
            first++;
        }
        while (first < second && nums[first] % 2 == 0) {
            second--;
        }
        if (first < second) {
            swap(nums, first++, second--);
        }
    }
}

private void swap(int[] nums, int first, int second) {
    int temp = nums[first];
    nums[first] = nums[second];
    nums[second] = temp;
}