public void pivotSort(int[] nums, int pivot) {
    int first = 0, second = nums.length - 1;
    while (first < second) {
        while (first < second && nums[first] <= pivot) {
            first++;
        } 
        while (first < second && nums[second] > pivot) {
            second--;
        }
        if(first < second) {
            swap(nums, first++, second--);
        }
    }
}

private void swap(int[] nums, int first, int second) {
    int temp = nums[first];
    nums[first] = nums[second];
    nums[second] = temp;
}