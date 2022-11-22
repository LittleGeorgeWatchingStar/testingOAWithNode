class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
       Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        
        for(int i=0; i<nums.length; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            
            
            int left = i+1;
            int right = nums.length-1;
            
            while(left < right){
                int sum = nums[left] + nums[right] + nums[i];
                if(sum == 0){
                    res.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    left++;
                    while(nums[left] == nums[left-1] && left < right) left++;
                } else if(sum > 0){
                    right--;
                } else {
                    left++;
                }
            }
        }
        return res;
    }
}

// two pointers
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
       Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        
        for (int i = 0; i < nums.length && nums[i] <= 0; ++i)
            if (i == 0 || nums[i - 1] != nums[i]) {
                twoSumII(nums, i, res);
            }
        return res;
    }
    void twoSumII(int[] nums, int i, List<List<Integer>> res) {
        int lo = i + 1, hi = nums.length - 1;
        while (lo < hi) {
            int sum = nums[i] + nums[lo] + nums[hi];
            if (sum < 0) {
                ++lo;
            } else if (sum > 0) {
                --hi;
            } else {
                res.add(Arrays.asList(nums[i], nums[lo++], nums[hi--]));
                while (lo < hi && nums[lo] == nums[lo - 1])
                    ++lo;
            }
        }
    }
}