public int[] twoSum(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] == target - nums[i]) {
                return new int[] { i, j };
            }
        }
    }
    throw new IllegalArgumentException("No two sum solution");
}

//two pass hashtable:
public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        map.put(nums[i], i);
    }
    for (int i = 0; i < nums.length; i++) {
        int complement = target - nums[i];
        if (map.containsKey(complement) && map.get(complement) != i) {
            return new int[] { i, map.get(complement) };
        }
    }
    throw new IllegalArgumentException("No two sum solution");
}


//one pass hash table:
public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        int complement = target - nums[i];
        if (map.containsKey(complement)) {
            return new int[] { map.get(complement), i };
        }
        map.put(nums[i], i);
    }
    throw new IllegalArgumentException("No two sum solution");
}

int[] twoSum(int[] nums, int target) {
    int[] results = new int[2];
    if (nums.length < 2) {
        return result;
    }

    for (int i = 0; i < nums.length -1; i++) {
        for (int j = i +1; j < nums.length; j++) {
            int temp = nums[i] + nums[j];
            if (temp == target) {
                result[0] = nums[i];
                result[1] = nums[j];
                return result;
            }
        }
    }
    return result;
}


// sort first
int[] twoSum(int[] nums, int target) {
    int[] results = new int[2];
    Arrays.sort(nums);

    int first = 0, second = nums.length -1;

    while(first < second) {
        if (nums[first] + nums[second] == target) {
            result[0] = nums[first];
            result[1] = nums[second];
            return result;
        }

        if (nums[first] + nums[second] > target) {
            second --;
        }
        if (nums[first] + nums[second] < target) {
            first ++;
        }
    }
    return result;
}
