int secondMinimum(int[] nums) {
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] < min) {
            min = nums[i];
        }
    }

    int secondMin = Integer.MAX_VALUE;
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] == min) {
            continue;
        }

        if (nums[i] < secondMin) {
            secondMin = nums[i];
        }
    }

    return secondMin;
}



int secondMinimum(int[] nums) {
    int min = Math.min(nums[0], nums[1]);
    int secondMin = Math.max(nums[0], nums[1]);

    for (int i = 2; i < nums.length; i++) {
        if (nums[i] < min) {
            secondMin = min;
            min = nums[i];
        } else if (nums[i] == min) {
            secondMin = min;
        } else if (nums[i] > min && nums[i] < secondMin) {
            secondMin = nums[i];
        } else if (nums[i] == secondMin) {
            continue;
        } else {
            continue;
        }
    }

    return secondMin;
}



int secondMinimum(int[] nums) {
    int min = Math.min(nums[0], nums[1]);
    int secondMin = Math.max(nums[0], nums[1]);

    for (int i = 2; i < nums.length; i++) {
        if (nums[i] < min) {
            secondMin = min;
            min = nums[i];
        } else if (nums[i] < secondMin) {
            secondMin = nums[i];
        }
    }

    return secondMin;
}