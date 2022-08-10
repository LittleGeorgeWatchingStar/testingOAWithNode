public int removeElement( int[] nums, int val) {
    if(nums.length == 0) {
        return 0;
    }
    int first = 0, second = nums.length - 1;
    while( first < second) {
        while(first < second && nums[first] != val) {
            first++;
        }
         while(first < second && nums[second] == val) {
             second--;
        }
        if (first < second) {
            swap(nums, first++, second--);
        }
    }
    return nums[first] != val ? first+ 1 : first;
}

private void swap(int[] nums, int first, int second) {
    int temp = nums[first];
    nums[first] = nums[second];
    nums[second] = temp;
}

public int removeElement( int[] nums, int val) {

    int index = 0, len = nums.length;
    while( index < len) {
        if (nums[index] == val) {
           len--;
           nums[index] = nums[len];
        } else {
            index++;
        }
    }
    return len;
}