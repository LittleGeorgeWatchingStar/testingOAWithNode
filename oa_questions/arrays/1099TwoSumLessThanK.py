class Solution:
    def twoSumLessThanK(self, nums: List[int], k: int) -> int:
        nums.sort()
        l, r = 0, len(nums) -1
        ans = -1
        while l < r:
            s = nums[l] + nums[r]
            if k <= s: 
                r-=1
            else:
                l+=1
                ans = max(ans, s)
        return ans