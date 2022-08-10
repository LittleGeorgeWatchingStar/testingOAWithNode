public void reverseArray( int[] nums) {
    int first = 0, end = nums.length - 1;
    while (first < end) {
        swap(nums, first++, end--);
    }
}

private void swap(int[] nums, int first, int second) {
    int temp = nums[first];
    nums[first] = nums[second];
    nums[second] = temp;
}